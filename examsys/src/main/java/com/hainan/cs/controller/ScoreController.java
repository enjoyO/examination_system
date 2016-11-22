package com.hainan.cs.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hainan.cs.bean.AnswerBean;
import com.hainan.cs.bean.ChoiceQuestionBean;
import com.hainan.cs.bean.JudgeQuestionBean;
import com.hainan.cs.bean.MCQBean;
import com.hainan.cs.bean.QuestionBean;
import com.hainan.cs.bean.TestBean;
import com.hainan.cs.dao.AnswerDaoImp;
import com.hainan.cs.dao.ChoiceDaoImp;
import com.hainan.cs.dao.JudgeDaoImp;
import com.hainan.cs.dao.MCQDaoImp;
import com.hainan.cs.dao.QuestionDaoImp;
import com.hainan.cs.dao.TestDaoImp;

@Controller
@RequestMapping(value="/score")
public class ScoreController {
	@RequestMapping()
	public ModelAndView score(String paperid,String examineeid){
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		AnswerDaoImp adi=context.getBean(AnswerDaoImp.class);
		TestDaoImp tdi=context.getBean(TestDaoImp.class);
		QuestionDaoImp qdi=context.getBean(QuestionDaoImp.class);
		ChoiceDaoImp cdi=context.getBean(ChoiceDaoImp.class);
		MCQDaoImp mdi=context.getBean(MCQDaoImp.class);
		JudgeDaoImp jdi=context.getBean(JudgeDaoImp.class);
		//获取用户提交的所有题的答案
		int totalscore=0;
		int paperscore=0;
		int singlescore=0;
		int multiplescore=0;
		int judgescore=0;
		int essayscore=0;
		int totalsingle=0;
		int totalmultiple=0;
		int totaljudge=0;
		int totalessay=0;
		String result="";
		List<AnswerBean> answerlist=adi.queryPaperIdAndExamineeId(paperid, examineeid);
		System.out.println("题目数量="+answerlist.size());
		for(int i=0;i<answerlist.size();i++){
			int k=i+1;
			AnswerBean answer=answerlist.get(i);
			ChoiceQuestionBean cqb=cdi.getCQB(answer.getQuestionid());
			QuestionBean qb=qdi.getQuestion(answer.getQuestionid());
			JudgeQuestionBean jqb=jdi.getJQB(answer.getQuestionid());
			MCQBean mqb=mdi.getMCQB(answer.getQuestionid());
			//该题是单选
			if(cqb!=null){
				System.out.println("该题是单选");
				int score=0;
				if(cqb.getAnsewer().equals(answer.getAnswer())){
					score=5;
					singlescore=singlescore+5;
				}
				totalscore=totalscore+score;
				paperscore=paperscore+5;
				totalsingle=totalsingle+5;
				String single="<tr class=\"success\"><td>"+k+". "+cqb.getDescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>A. "+cqb.getAdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>B. "+cqb.getBdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>C. "+cqb.getCdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>D. "+cqb.getDdescription()+"</td></tr>"
						+"<tr class=\"danger\"><td>Right answer is:"+cqb.getAnsewer()
						+"</td></tr><tr class=\"danger\"><td>your answer is:"+answer.getAnswer()
						+"</td></tr><tr class=\"danger\"><td>score is:"+score+"</td></tr>";
				result=result+single;
				
			}
			//改题是问答
			if(qb!=null){
				System.out.println("该题是问答");
				int score=0;
				if(qb.getAnswer().equals(answer.getAnswer())){
					score=15;
					essayscore=essayscore+15;
				}
				paperscore=paperscore+15;
				totalscore=totalscore+score;
				totalessay=totalessay+15;
				String essay="<tr class=\"success\"><td>"+k+". "+qb.getDescription()+"</td></tr>"+
							"<tr class=\"danger\"><td>right answer is: "+qb.getAnswer()+"</td></tr>"+
							"<tr class=\"danger\"><td>your answer is:"+answer.getAnswer()+"</td></tr>"+
							"<tr class=\"danger\"><td>score is:"+score+"</td></tr>";
				result=result+essay;
			}
			//该题是判断
			if(jqb!=null){
				System.out.println("该题是判断");
				int score=0;
				if(jqb.getAnswer().equals(answer.getAnswer())){
					score=5;
					judgescore=judgescore+5;
				}
				paperscore=paperscore+5;
				totalscore=totalscore+score;
				totaljudge=totaljudge+5;
				String judge="<tr class=\"success\"><td>"+k+". "+jqb.getDescription()+"</td></tr>"+
							"<tr class=\"danger\"><td>right answer is: "+jqb.getAnswer()+"</td></tr>"+
							"<tr class=\"danger\"><td>your answer is:"+answer.getAnswer()+"</td></tr>"+
							"<tr class=\"danger\"><td>score is:"+score+"</td></tr>";
				result=result+judge;
			}
			//改题是多选
			if(mqb!=null){
				System.out.println("该题是多选");
				int score=0;
				if(mqb.getAnsewer().equals(answer.getAnswer())){
					score=5;
					multiplescore=multiplescore+5;
				}
				paperscore=paperscore+5;
				totalscore=totalscore+score;
				totalmultiple=totalmultiple+5;
				String multiple="<tr class=\"success\"><td>"+k+". "+mqb.getDescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>A. "+mqb.getAdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>B. "+mqb.getBdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>C. "+mqb.getCdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>D. "+mqb.getDdescription()+"</td></tr>"
						+"<tr class=\"danger\"><td>Right answer is:"+mqb.getAnsewer()
						+"</td></tr><tr class=\"danger\"><td>your answer is:"+answer.getAnswer()
						+"</td></tr><tr class=\"danger\"><td>score is:"+score+"</td></tr>";
				result=result+multiple;
			}
		}
		//把得分加入到测试表中
		List<TestBean> tlist=tdi.queryPaperIdAndExamineeId(paperid, examineeid);
		if(tlist==null){
			TestBean tb=new TestBean();
			tb.setExamineeid(examineeid);
			tb.setPaperid(paperid);
			tb.setScore(totalscore+"/"+paperscore);
			tb.setSingle(singlescore+"/"+totalsingle);
			tb.setMultiple(multiplescore+"/"+totalmultiple);
			tb.setJudge(judgescore+"/"+totaljudge);
			tb.setEssay(essayscore+"/"+totalessay);
			tdi.insert(tb);
		}else{
			TestBean test=tlist.get(0);
			//让得分变成字符串，考虑到以后可能得分不是数字的情况
			tdi.updateScore(test.getId(), totalscore+"/"+paperscore);
			tdi.updateSingleScore(test.getId(), singlescore+"/"+totalsingle);
			tdi.updateMultipleScore(test.getId(), multiplescore+"/"+totalmultiple);
			tdi.updateJudgeScore(test.getId(), judgescore+"/"+totaljudge);
			tdi.updateEssayScore(test.getId(), essayscore+"/"+totalessay);
		}
		mav.addObject("totalscore", totalscore);
		mav.addObject("result", result);
		mav.addObject("paperscore", paperscore);
		mav.addObject("singlescore", singlescore+"/"+totalsingle);
		mav.addObject("multiplescore", multiplescore+"/"+totalmultiple);
		mav.addObject("judgescore", judgescore+"/"+totaljudge);
		mav.addObject("essayscore", essayscore+"/"+totalessay);
		mav.setViewName("finish");
		context.close();
		return mav;
	}
	@RequestMapping(value="/return")
	public ModelAndView goBack(){
		return new ModelAndView("redirect:/homepage?tag="+2);
	}
}
