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
import com.hainan.cs.bean.NewAnswer;
import com.hainan.cs.bean.PaperBean;
import com.hainan.cs.bean.QuestionBean;
import com.hainan.cs.dao.AnswerDaoImp;
import com.hainan.cs.dao.ChoiceDaoImp;
import com.hainan.cs.dao.JudgeDaoImp;
import com.hainan.cs.dao.MCQDaoImp;
import com.hainan.cs.dao.NewAnswerDaoImp;
import com.hainan.cs.dao.PaperDaoImp;
import com.hainan.cs.dao.QuestionDaoImp;

@Controller
@RequestMapping(value="/paper")
public class PaperController {
	@RequestMapping()
	public ModelAndView paper(String paperid){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("createpaper");
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		PaperDaoImp pdi=context.getBean(PaperDaoImp.class);
		//试卷信息
		PaperBean paper=pdi.getPaper(paperid);
		mav.addObject("papername", paper.getPapername());
		mav.addObject("papertype", paper.getType());
		mav.addObject("papertime", paper.getTime());
		mav.addObject("paperinfo", paper.getPaperinfo());
		//创建的单选题信息
		ChoiceDaoImp cdi=context.getBean(ChoiceDaoImp.class);
		List<ChoiceQuestionBean> clist=cdi.queryPaper(paperid);
		String single="";
		for(int i=0;i<clist.size();i++){
			single=single+"<tr class=\"success\"><td>"+(i+1)+". "+clist.get(i).getDescription()+
					"</td></tr><tr class=\"warning\"><td>A. "+
					clist.get(i).getAdescription()+"</td></tr><tr class=\"warning\"><td>B. "+
					clist.get(i).getBdescription()+"</td></tr><tr class=\"warning\"><td>C. "+
					clist.get(i).getCdescription()+"</td></tr><tr class=\"warning\"><td>D. "+
					clist.get(i).getDdescription()+"</td></tr><tr class=\"warning\"><td>Answer = "+
					clist.get(i).getAnsewer()+"</td></tr>"+"<tr class=\"warning\">"
							+ "<td><a class=\"btn btn-default\" href=\"paper/deletesingle?questionid="+clist.get(i).getId()+
							"&paperid="+paperid
							+ "\">delete this question</a></td></tr>";
		}
		mav.addObject("singleques",single);
		//创建的多选题信息
		MCQDaoImp mdi=context.getBean(MCQDaoImp.class);
		List<MCQBean> mlist=mdi.queryPaper(paperid);
		String multiple="";
		for(int i=0;i<mlist.size();i++){
			multiple=multiple+"<tr class=\"success\"><td>"+(i+1)+". "+mlist.get(i).getDescription()+
					"</td></tr><tr class=\"warning\"><td>A. "+
					mlist.get(i).getAdescription()+"</td></tr><tr class=\"warning\"><td>B. "+
					mlist.get(i).getBdescription()+"</td></tr><tr class=\"warning\"><td>C. "+
					mlist.get(i).getCdescription()+"</td></tr><tr class=\"warning\"><td>D. "+
					mlist.get(i).getDdescription()+"</td></tr><tr class=\"warning\"><td>Answer = "+
					mlist.get(i).getAnsewer()+"</td></tr>"+"<tr class=\"warning\">"
							+ "<td><a class=\"btn btn-default\" href=\"paper/deletemultiple?questionid="+mlist.get(i).getId()+
							"&paperid="+paperid
							+ "\">delete this question</a></td></tr>";
		}
		mav.addObject("multipleques",multiple);
		//创建的判断题信息
		JudgeDaoImp jdi=context.getBean(JudgeDaoImp.class);
		List<JudgeQuestionBean> jlist=jdi.queryPaper(paperid);
		String judge="";
		for(int i=0;i<jlist.size();i++){
			judge=judge+"<tr class=\"success\"><td>"+(i+1)+". "+jlist.get(i).getDescription()+
					"</td></tr><tr class=\"warning\"><td>Answer = "+jlist.get(i).getAnswer()+"</td></tr>"
							+"<tr class=\"warning\">"
							+ "<td><a class=\"btn btn-default\" href=\"paper/deletejudge?questionid="+jlist.get(i).getId()+
							"&paperid="+paperid
							+ "\">delete this question</a></td></tr>";
		}
		mav.addObject("judgeques", judge);
		//创建的简答题信息
		QuestionDaoImp qdi=context.getBean(QuestionDaoImp.class);
		List<QuestionBean>  qlist=qdi.queryPaperId(paperid);
		String essay="";
		for(int i=0;i<qlist.size();i++){
			essay=essay+"<tr class=\"success\"><td>"+(i+1)+". "+qlist.get(i).getDescription()+
					"</td></tr><tr class=\"warning\"><td>Answer = "+qlist.get(i).getAnswer()+"</td></tr>"
							+"<tr class=\"warning\">"
							+ "<td><a class=\"btn btn-default\" href=\"paper/deleteessay?questionid="+qlist.get(i).getId()+
							"&paperid="+paperid
							+ "\">delete this question</a></td></tr>";
		}
		mav.addObject("essayques", essay);
		mav.addObject("paperid", paperid);
		return mav;
	}
	@RequestMapping(value="/addsingle")
	public ModelAndView addSingle(String question,String choicea,String choiceb,
			String choicec,String choiced,String answer,String paperid){
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		ChoiceDaoImp cdi=context.getBean(ChoiceDaoImp.class);
		ChoiceQuestionBean cqb=new ChoiceQuestionBean();
		cqb.setDescription(question);
		cqb.setAdescription(choicea);
		cqb.setBdescription(choiceb);
		cqb.setCdescription(choicec);
		cqb.setDdescription(choiced);
		cqb.setAnsewer(answer);
		cqb.setPaperid(paperid);
		cdi.insert(cqb);
		context.close();
		mav.setViewName("redirect:/paper?paperid="+paperid);
		return mav;
	}
	@RequestMapping(value="/addmultiple")
	public ModelAndView addMultiple(String question,String choicea,String choiceb,
			String choicec,String choiced,String answer,String paperid){
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		MCQDaoImp mdi=context.getBean(MCQDaoImp.class);
		MCQBean mb=new MCQBean();
		mb.setAdescription(choicea);
		/*
		String str="";
		for(int i=0;i<answer.length;i++){
			str=str+answer[i];
		}
		*/
		//复选框传过来的答案是数组如果用string接受的话会用逗号隔开
		System.out.println("答案是="+answer);
		mb.setAnsewer(answer);
		mb.setBdescription(choiceb);
		mb.setCdescription(choicec);
		mb.setDdescription(choiced);
		mb.setDescription(question);
		mb.setPaperid(paperid);
		mdi.insert(mb);
		context.close();
		mav.setViewName("redirect:/paper?paperid="+paperid);
		return mav;
	}
	@RequestMapping(value="/addjudge")
	public ModelAndView addJudge(String question,String answer,String paperid){
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		JudgeDaoImp jdi=context.getBean(JudgeDaoImp.class);
		JudgeQuestionBean jb=new JudgeQuestionBean();
		jb.setDescription(question);
		jb.setAnswer(answer);
		jb.setPaperid(paperid);
		jdi.insert(jb);
		context.close();
		mav.setViewName("redirect:/paper?paperid="+paperid);
		return mav;
	}
	@RequestMapping(value="/addessay")
	public ModelAndView addEssay(String question,String answer,String paperid){
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		QuestionDaoImp qdi=context.getBean(QuestionDaoImp.class);
		QuestionBean qb=new QuestionBean();
		qb.setAnswer(answer);
		qb.setDescription(question);
		qb.setPaperid(paperid);
		qdi.insert(qb);
		context.close();
		mav.setViewName("redirect:/paper?paperid="+paperid);
		return mav;
	}
	@RequestMapping(value="/return")
	public ModelAndView backHome(){
		return new ModelAndView("redirect:/homepage?tag="+1);
	}
	@RequestMapping(value="/deletesingle")
	public ModelAndView deletesingle(String questionid,String paperid){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		ChoiceDaoImp cdi=context.getBean(ChoiceDaoImp.class);
		AnswerDaoImp adi=context.getBean(AnswerDaoImp.class);
		NewAnswerDaoImp nadi=context.getBean(NewAnswerDaoImp.class);
		cdi.delete(questionid);
		List<AnswerBean> alist=adi.queryQuestionId(questionid);
		for(int i=0;i<alist.size();i++){
			adi.delete(alist.get(i).getId());
		}
		List<NewAnswer> nlist=nadi.queryQuestionId(questionid);
		for(int i=0;i<nlist.size();i++){
			nadi.delete(nlist.get(i).getId());
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/paper?paperid="+paperid);
		context.close();
		return mav;
	}
	@RequestMapping(value="/deletemultiple")
	public ModelAndView deleteMultiple(String questionid,String paperid){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		MCQDaoImp mdi=context.getBean(MCQDaoImp.class);
		AnswerDaoImp adi=context.getBean(AnswerDaoImp.class);
		NewAnswerDaoImp nadi=context.getBean(NewAnswerDaoImp.class);
		mdi.delete(questionid);
		List<AnswerBean> alist=adi.queryQuestionId(questionid);
		for(int i=0;i<alist.size();i++){
			adi.delete(alist.get(i).getId());
		}
		List<NewAnswer> nlist=nadi.queryQuestionId(questionid);
		for(int i=0;i<nlist.size();i++){
			nadi.delete(nlist.get(i).getId());
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/paper?paperid="+paperid);
		context.close();
		return mav;
	}
	@RequestMapping(value="/deletejudge")
	public ModelAndView deleteJudge(String questionid,String paperid){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		JudgeDaoImp jdi=context.getBean(JudgeDaoImp.class);
		AnswerDaoImp adi=context.getBean(AnswerDaoImp.class);
		NewAnswerDaoImp nadi=context.getBean(NewAnswerDaoImp.class);
		jdi.delete(questionid);
		List<AnswerBean> alist=adi.queryQuestionId(questionid);
		for(int i=0;i<alist.size();i++){
			adi.delete(alist.get(i).getId());
		}
		List<NewAnswer> nlist=nadi.queryQuestionId(questionid);
		for(int i=0;i<nlist.size();i++){
			nadi.delete(nlist.get(i).getId());
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/paper?paperid="+paperid);
		context.close();
		return mav;
	}
	@RequestMapping(value="/deleteessay")
	public ModelAndView deleteEssay(String questionid,String paperid){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		QuestionDaoImp qdi=context.getBean(QuestionDaoImp.class);
		AnswerDaoImp adi=context.getBean(AnswerDaoImp.class);
		NewAnswerDaoImp nadi=context.getBean(NewAnswerDaoImp.class);
		qdi.delete(questionid);
		List<AnswerBean> alist=adi.queryQuestionId(questionid);
		for(int i=0;i<alist.size();i++){
			adi.delete(alist.get(i).getId());
		}
		List<NewAnswer> nlist=nadi.queryQuestionId(questionid);
		for(int i=0;i<nlist.size();i++){
			nadi.delete(nlist.get(i).getId());
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/paper?paperid="+paperid);
		context.close();
		return mav;
	}
}
