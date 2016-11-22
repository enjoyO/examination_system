package com.hainan.cs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hainan.cs.bean.AnswerBean;
import com.hainan.cs.bean.ChoiceQuestionBean;
import com.hainan.cs.bean.JudgeQuestionBean;
import com.hainan.cs.bean.MCQBean;
import com.hainan.cs.bean.NewAnswer;
import com.hainan.cs.bean.NewTest;
import com.hainan.cs.bean.QuestionBean;
import com.hainan.cs.bean.TestBean;
import com.hainan.cs.bean.UserBean;
import com.hainan.cs.dao.AnswerDaoImp;
import com.hainan.cs.dao.ChoiceDaoImp;
import com.hainan.cs.dao.JudgeDaoImp;
import com.hainan.cs.dao.MCQDaoImp;
import com.hainan.cs.dao.NewAnswerDaoImp;
import com.hainan.cs.dao.NewTestDaoImp;
import com.hainan.cs.dao.QuestionDaoImp;
import com.hainan.cs.dao.TestDaoImp;
import com.hainan.cs.dao.UserDaoImp;
import com.hainan.cs.singleton.Examine;
import com.hainan.cs.singleton.PassAndName;
import com.hainan.cs.singleton.Questions;

@Controller
@RequestMapping(value="/newexamine")
public class NewExamineController {
	@RequestMapping()
	public ModelAndView examine(String paperid){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		ChoiceDaoImp cdi=context.getBean(ChoiceDaoImp.class);
		JudgeDaoImp jdi=context.getBean(JudgeDaoImp.class);
		MCQDaoImp mdi=context.getBean(MCQDaoImp.class);
		QuestionDaoImp qdi=context.getBean(QuestionDaoImp.class);
		PassAndName pn=PassAndName.getInstance();
		String username=pn.getUsername();
		UserDaoImp udi=context.getBean(UserDaoImp.class);
		UserBean user=udi.queryUser(username).get(0);
		String examineeid=user.getId();
		//将本次新型测试加入测试表(如果是重复做同一套试卷的话，啥都不干)
		NewTestDaoImp tdi=context.getBean(NewTestDaoImp.class);
		List<NewTest> tlist=tdi.queryPaperIdAndExamineeId(paperid, examineeid);
		if(tlist.size()==0){
			NewTest tb=new NewTest();
			tb.setExamineeid(examineeid);
			tb.setPaperid(paperid);
			tdi.insert(tb);
		}
		//两个单例
		Questions ques=Questions.getInstance();
		Examine examinee=Examine.getInstance();
		examinee.setExamineeid(examineeid);
		examinee.setPaperid(paperid);
		ArrayList<String> all=ques.getAll();
		HashMap<String,String> allhash=ques.getAllhash();
		//获取所有单选题
		ArrayList<String> single=ques.getSingle();
		List<ChoiceQuestionBean> clist=cdi.queryPaper(paperid);
		for(int i=0;i<clist.size();i++){
			single.add(clist.get(i).getId());
			all.add(clist.get(i).getId());
			allhash.put(clist.get(i).getId(), "single");
		}
		//获取所有多选题
		ArrayList<String> multiple=ques.getMultiple();
		List<MCQBean> mlist=mdi.queryPaper(paperid);
		for(int i=0;i<mlist.size();i++){
			multiple.add(mlist.get(i).getId());
			all.add(mlist.get(i).getId());
			allhash.put(mlist.get(i).getId(), "multiple");
		}
		//获取所有判断题
		ArrayList<String> judge=ques.getJudge();
		List<JudgeQuestionBean> jlist=jdi.queryPaper(paperid);
		for(int i=0;i<jlist.size();i++){
			judge.add(jlist.get(i).getId());
			all.add(jlist.get(i).getId());
			allhash.put(jlist.get(i).getId(), "judge");
		}
		//获取问答题
		ArrayList<String> essay=ques.getEssay();
		List<QuestionBean> qlist=qdi.queryPaperId(paperid);
		for(int i=0;i<qlist.size();i++){
			essay.add(qlist.get(i).getId());
			all.add(qlist.get(i).getId());
			allhash.put(qlist.get(i).getId(), "essay");
		}
		//测试
		for(Map.Entry<String, String>entry:allhash.entrySet()){
			String value=entry.getValue();
			System.out.println("类型是="+value+"  id是="+entry.getKey()+"下标是"+all.indexOf(entry.getKey()));
		}
		ModelAndView mav=new ModelAndView();
		if(all.size()!=0){
			//初始的题目
			String str=all.get(0);
			String type=allhash.get(str);
			if(type.equals("single")){
				mav.addObject("tag", 0);
				ChoiceQuestionBean cqb=cdi.getCQB(str);
				mav.addObject("questionid", str);
				mav.addObject("question", cqb.getDescription());
				mav.addObject("choicea", cqb.getAdescription());
				mav.addObject("choiceb", cqb.getBdescription());
				mav.addObject("choicec", cqb.getCdescription());
				mav.addObject("choiced", cqb.getDdescription());
				mav.addObject("type", "single choice");
				mav.addObject("score", 4);
				mav.addObject("number", 1);
				mav.addObject("total", all.size());
			}
			if(type.equals("multiple")){
				mav.addObject("tag", 1);
				MCQBean mb=mdi.getMCQB(str);
				if(mb!=null){
				mav.addObject("questionid", str);
				mav.addObject("question", mb.getDescription());
				mav.addObject("choicea", mb.getAdescription());
				mav.addObject("choiceb", mb.getBdescription());
				mav.addObject("choicec", mb.getCdescription());
				mav.addObject("choiced", mb.getDdescription());
				}
				mav.addObject("type", "multiple choice");
				mav.addObject("score", 6);
				mav.addObject("number", 1);
				mav.addObject("total", all.size());
			}
			if(type.endsWith("judge")){
				mav.addObject("tag",2);
				JudgeQuestionBean jb=jdi.getJQB(str);
				mav.addObject("questionid", str);
				mav.addObject("question", jb.getDescription());
				mav.addObject("type", "judge");
				mav.addObject("score", 4);
				mav.addObject("number", 1);
				mav.addObject("total", all.size());
			}
			if(type.equals("essay")){
				mav.addObject("tag",3);
				QuestionBean qb=qdi.getQuestion(str);
				mav.addObject("questionid", str);
				mav.addObject("question", qb.getDescription());
				mav.addObject("type", "essay question");
				mav.addObject("score", 10);
				mav.addObject("number", 1);
				mav.addObject("total", all.size());
			}
		}else{
			//没有题目的话
			mav.addObject("tag", 4);
			
		}
		mav.setViewName("new_examine");
		context.close();
		return mav;
	}
	@RequestMapping(value="/submitanswer")
	public ModelAndView subSingle(String answer,String questionid,
			String credita,String creditb,String creditc,
			String creditd,String credity,String creditn){
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		ChoiceDaoImp cdi=context.getBean(ChoiceDaoImp.class);
		JudgeDaoImp jdi=context.getBean(JudgeDaoImp.class);
		MCQDaoImp mdi=context.getBean(MCQDaoImp.class);
		QuestionDaoImp qdi=context.getBean(QuestionDaoImp.class);
		NewAnswerDaoImp adi=context.getBean(NewAnswerDaoImp.class);
		Examine examinee=Examine.getInstance();
		//将答案提交到答题库,如果之前做过该题目要将答案跟新
		List<NewAnswer> alist=adi.queryPaperIdAndExamineeIdAndQuestionid(examinee.getPaperid(), examinee.getExamineeid(), questionid);
		if(alist.size()==0){
			//之前没有做过提交答案
			NewAnswer ab=new NewAnswer();
			ab.setAnswer(answer);
			ab.setExamineeid(examinee.getExamineeid());
			ab.setQuestionid(questionid);
			ab.setPaperid(examinee.getPaperid());
			ab.setCredita(credita);
			ab.setCreditb(creditb);
			ab.setCreditc(creditc);
			ab.setCreditd(creditd);
			ab.setCreditn(creditn);
			ab.setCredity(credity);
			adi.insert(ab);
		}else{
			//之前做过更新答案
			adi.update(alist.get(0).getId(), answer);
			adi.updateCreditA(alist.get(0).getId(), credita);
			adi.updateCreditB(alist.get(0).getId(), creditb);
			adi.updateCreditC(alist.get(0).getId(), creditc);
			adi.updateCreditD(alist.get(0).getId(), creditd);
			adi.updateCreditY(alist.get(0).getId(), credity);
			adi.updateCreditN(alist.get(0).getId(), creditn);
		}
		//确定下一题内容
		Questions ques=Questions.getInstance();
		ArrayList<String> single=ques.getSingle();
		ArrayList<String> multiple=ques.getMultiple();
		ArrayList<String> judge=ques.getJudge();
		ArrayList<String> essay=ques.getEssay();
		HashMap<String,String> allhash=ques.getAllhash();
		ArrayList<String> all=ques.getAll();
		int number=all.indexOf(questionid);
		System.out.println("当前下表是="+number);
		if(number+1<all.size()){
			String str=all.get(number+1);
			System.out.println("下一个下标是="+(number+1)+"id是="+str);
			String type=allhash.get(str);
			//如果是单选题
			if(type.equals("single")){
				System.out.println("类型是单选");
				mav.addObject("tag", 0);
				ChoiceQuestionBean cqb=cdi.getCQB(str);
				mav.addObject("questionid", str);
				mav.addObject("question", cqb.getDescription());
				mav.addObject("choicea", cqb.getAdescription());
				mav.addObject("choiceb", cqb.getBdescription());
				mav.addObject("choicec", cqb.getCdescription());
				mav.addObject("choiced", cqb.getDdescription());
				mav.addObject("type", "single choice");
				mav.addObject("score", 4);
				mav.addObject("number", number+2);
				mav.addObject("total", single.size());
			}
			//如果是多选题
			if(type.equals("multiple")){
				System.out.println("类型是多选");
				mav.addObject("tag", 1);
				MCQBean mb=mdi.getMCQB(str);
				mav.addObject("questionid", str);
				mav.addObject("question", mb.getDescription());
				mav.addObject("choicea", mb.getAdescription());
				mav.addObject("choiceb", mb.getBdescription());
				mav.addObject("choicec", mb.getCdescription());
				mav.addObject("choiced", mb.getDdescription());
				mav.addObject("type", "multiple choice");
				mav.addObject("score", 6);
				mav.addObject("number", number+2);
				mav.addObject("total", multiple.size());
			}
			//如果是判断题
			if(type.equals("judge")){
				System.out.println("类型是判断");
				System.out.println("进入有判断");
				mav.addObject("tag",2);
				JudgeQuestionBean jb=jdi.getJQB(str);
				mav.addObject("questionid", str);
				mav.addObject("question", jb.getDescription());
				mav.addObject("type", "judge");
				mav.addObject("score", 4);
				mav.addObject("number", number+2);
				mav.addObject("total", judge.size());
			}
			//如果是简答题
			if(type.equals("essay")){
				System.out.println("类型是简答");
				mav.addObject("tag",3);
				QuestionBean qb=qdi.getQuestion(str);
				mav.addObject("questionid", str);
				mav.addObject("question", qb.getDescription());
				mav.addObject("type", "essay question");
				mav.addObject("score", 10);
				mav.addObject("number", number+2);
				mav.addObject("total", essay.size());
			}
			mav.setViewName("new_examine");
		}else{
			//答题完成
			//清空单例中的list
			single.clear();
			multiple.clear();
			judge.clear();
			essay.clear();
			all.clear();
			allhash.clear();
			mav.setViewName("redirect:/newscore?paperid="+examinee.getPaperid()+
					"&examineeid="+examinee.getExamineeid());
		}
		context.close();
		return mav;
	}
	@RequestMapping(value="/return")
	public ModelAndView goBack(){
		//返回的话也要将单利清空
		Questions ques=Questions.getInstance();
		ArrayList<String> single=ques.getSingle();
		ArrayList<String> multiple=ques.getMultiple();
		ArrayList<String> judge=ques.getJudge();
		ArrayList<String> essay=ques.getEssay();
		HashMap<String,String> allhash=ques.getAllhash();
		ArrayList<String> all=ques.getAll();
		single.clear();
		multiple.clear();
		judge.clear();
		essay.clear();
		all.clear();
		allhash.clear();
		return new ModelAndView("redirect:/homepage?tag="+2);
		
	}
}
