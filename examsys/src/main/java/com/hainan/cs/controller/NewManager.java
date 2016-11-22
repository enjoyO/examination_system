package com.hainan.cs.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hainan.cs.bean.ChoiceQuestionBean;
import com.hainan.cs.bean.JudgeQuestionBean;
import com.hainan.cs.bean.MCQBean;
import com.hainan.cs.bean.NewAnswer;
import com.hainan.cs.bean.NewTest;
import com.hainan.cs.bean.QuestionBean;
import com.hainan.cs.bean.UserBean;
import com.hainan.cs.dao.ChoiceDaoImp;
import com.hainan.cs.dao.JudgeDaoImp;
import com.hainan.cs.dao.MCQDaoImp;
import com.hainan.cs.dao.NewAnswerDaoImp;
import com.hainan.cs.dao.NewTestDaoImp;
import com.hainan.cs.dao.QuestionDaoImp;
import com.hainan.cs.dao.UserDaoImp;
import com.hainan.cs.util.CountScoreImp;

@Controller
@RequestMapping(value="/newmanage")
public class NewManager {
	@RequestMapping()
	public ModelAndView manage(String paperid){
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		NewTestDaoImp tdi=context.getBean(NewTestDaoImp.class);
		UserDaoImp udi=context.getBean(UserDaoImp.class);
		List<NewTest> tlist=tdi.queryPaperId(paperid);
		String result="";
		for(int i=0;i<tlist.size();i++){
			NewTest test=tlist.get(i);
			UserBean user=udi.getUser(test.getExamineeid());
			String str="<tr class=\"danger\"><td>"+user.getUsername()+"</td><td>"+user.getPhone()+"</td><td>"+
			user.getEmail()+"</td><td>"+test.getScore()+"</td><td>"+test.getSingle()+"</td><td>"+
			test.getMultiple()+"</td><td>"+test.getJudge()+"</td><td>"+test.getEssay()+"</td><td>"+
			test.getTeacherscore()+"</td><td><a href=\"newmanage/check?paperid="+paperid+"&examineeid="+user.getId()+"\">check</a>";
			result=result+str;
		}
		mav.setViewName("new_manage_exame");
		mav.addObject("result", result);
		context.close();
		return mav;
	}
	@RequestMapping(value="/check")
	public ModelAndView check(String paperid,String examineeid){
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		NewAnswerDaoImp adi=context.getBean(NewAnswerDaoImp.class);
		NewTestDaoImp tdi=context.getBean(NewTestDaoImp.class);
		QuestionDaoImp qdi=context.getBean(QuestionDaoImp.class);
		ChoiceDaoImp cdi=context.getBean(ChoiceDaoImp.class);
		MCQDaoImp mdi=context.getBean(MCQDaoImp.class);
		JudgeDaoImp jdi=context.getBean(JudgeDaoImp.class);
		CountScoreImp csi=new CountScoreImp();
		//获取用户提交的所有题的答案
		float totalscore=0;
		int paperscore=0;
		float singlescore=0;
		float multiplescore=0;
		float judgescore=0;
		int essayscore=0;
		int totalsingle=0;
		int totalmultiple=0;
		int totaljudge=0;
		int totalessay=0;
		String result="";
		List<NewAnswer> answerlist=adi.queryPaperIdAndExamineeId(paperid, examineeid);
		System.out.println("题目数量="+answerlist.size());
		for(int i=0;i<answerlist.size();i++){
			int k=i+1;
			NewAnswer answer=answerlist.get(i);
			ChoiceQuestionBean cqb=cdi.getCQB(answer.getQuestionid());
			QuestionBean qb=qdi.getQuestion(answer.getQuestionid());
			JudgeQuestionBean jqb=jdi.getJQB(answer.getQuestionid());
			MCQBean mqb=mdi.getMCQB(answer.getQuestionid());
			//该题是单选
			if(cqb!=null){
				System.out.println("该题是单选");
				float score=0;
				score=csi.judgeSingle(answer.getCredita(), answer.getCreditb(), 
						answer.getCreditc(), answer.getCreditd(), answer.getAnswer());
				singlescore=singlescore+score;
				totalscore=totalscore+score;
				paperscore=paperscore+5;
				totalsingle=totalsingle+5;
				String single="<tr class=\"success\"><td>"+k+". "+cqb.getDescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>A. "+cqb.getAdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>B. "+cqb.getBdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>C. "+cqb.getCdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>D. "+cqb.getDdescription()+"</td></tr>"
						+"<tr class=\"danger\"><td>Right answer is:"+cqb.getAnsewer()
						+"</td></tr><tr class=\"danger\"><td>his answer is:"+answer.getAnswer()
						+"</td></tr><tr class=\"danger\"><td>his confidence is: A_"+answer.getCredita()
						+" B_"+answer.getCreditb()+" C_"+answer.getCreditc()+" D_"+answer.getCreditd()
						+"</td></tr><tr class=\"danger\"><td>his score is:"+score+"</td></tr>";
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
							"<tr class=\"danger\"><td>his answer is:"+answer.getAnswer()+"</td></tr>"+
							"<tr class=\"danger\"><td>his score is:"+score+"</td></tr>";
				result=result+essay;
			}
			//该题是判断
			if(jqb!=null){
				System.out.println("该题是判断");
				float score=0;
				score=csi.judgeJudge(answer.getCredity(), answer.getCreditn(), jqb.getAnswer());
				judgescore=judgescore+score;
				paperscore=paperscore+5;
				totalscore=totalscore+score;
				totaljudge=totaljudge+5;
				String judge="<tr class=\"success\"><td>"+k+". "+jqb.getDescription()+"</td></tr>"+
							"<tr class=\"danger\"><td>right answer is: "+jqb.getAnswer()+"</td></tr>"+
							"<tr class=\"danger\"><td>his answer is:"+answer.getAnswer()+"</td></tr>"+
							"<tr class=\"danger\"><td>his confidence is: Right_"+answer.getCredity()+
							" Wrong_"+answer.getCreditn()+
							"</td></tr>"+
							"<tr class=\"danger\"><td>his score is:"+score+"</td></tr>";
				result=result+judge;
			}
			//改题是多选
			if(mqb!=null){
				System.out.println("该题是多选");
				float score=0;
				score=csi.judgeMultiple(answer.getCredita(), answer.getCreditb(), answer.getCreditc(), 
						answer.getCreditd(), mqb.getAnsewer(), answer.getAnswer());
				multiplescore=multiplescore+score;
				paperscore=paperscore+5;
				totalscore=totalscore+score;
				totalmultiple=totalmultiple+5;
				String multiple="<tr class=\"success\"><td>"+k+". "+mqb.getDescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>A. "+mqb.getAdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>B. "+mqb.getBdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>C. "+mqb.getCdescription()+"</td></tr>"
						+"<tr class=\"warning\"><td>D. "+mqb.getDdescription()+"</td></tr>"
						+"<tr class=\"danger\"><td>Right answer is:"+mqb.getAnsewer()
						+"</td></tr><tr class=\"danger\"><td>his answer is:"+answer.getAnswer()
						+"</td></tr><tr class=\"danger\"><td>his confidence is: A_"+answer.getCredita()
						+" B_"+answer.getCreditb()+" C_"+answer.getCreditc()+" D_"+answer.getCreditd()
						+"</td></tr><tr class=\"danger\"><td>his score is:"+score+"</td></tr>";
				result=result+multiple;
			}
		}
		List<NewTest> tlist=tdi.queryPaperIdAndExamineeId(paperid, examineeid);
		mav.addObject("totalscore", totalscore);
		mav.addObject("result", result);
		mav.addObject("paperscore", paperscore);
		mav.addObject("singlescore", singlescore+"/"+totalsingle);
		mav.addObject("multiplescore", multiplescore+"/"+totalmultiple);
		mav.addObject("judgescore", judgescore+"/"+totaljudge);
		mav.addObject("essayscore", essayscore+"/"+totalessay);
		mav.setViewName("new_grade_paper");
		mav.addObject("paperid", paperid);
		mav.addObject("testid", tlist.get(0).getId());
		context.close();
		return mav;
	}
	@RequestMapping(value="/submitscore")
	public ModelAndView submitScore(String testid,String teacherscore){
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		NewTestDaoImp tdi=context.getBean(NewTestDaoImp.class);
		NewTest test=tdi.getNewTest(testid);
		tdi.updateTeacherScore(testid, teacherscore);
		mav.setViewName("redirect:/newmanage?paperid="+test.getPaperid());
		context.close();
		return mav;
	}
	
	@RequestMapping(value="/return")
	public ModelAndView goback(){
		return new ModelAndView("redirect:/homepage?tag="+1);
	}
	
}
