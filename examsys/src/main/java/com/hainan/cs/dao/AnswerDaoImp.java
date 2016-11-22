package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.AnswerBean;

public class AnswerDaoImp implements AnswerDao {
	private SessionFactory sessionfactory;
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sesstionfactory) {
		this.sessionfactory = sesstionfactory;
	}
	@Override
	public AnswerBean getAnswer(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		AnswerBean answer=(AnswerBean) session.get(AnswerBean.class, id);
		session.close();
		return answer;
	}
	@Override
	public void insert(AnswerBean answer){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(answer);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		AnswerBean answer=(AnswerBean) session.get(AnswerBean.class, id);
		session.delete(answer);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<AnswerBean> queryQuestionId(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from AnswerBean answer where answer.questionid='"+id+"'";
		Query query=session.createQuery(str);
		List<AnswerBean> alist=query.list();
		session.close();
		return alist;
	}
	@Override
	public List<AnswerBean> queryExamineeId(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from AnswerBean answer where answer.examineeid='"+id+"'";
		Query query=session.createQuery(str);
		List<AnswerBean> elist=query.list();
		session.close();
		return elist;
	}
	@Override
	public void update(String id,String answer){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		AnswerBean ab=(AnswerBean) session.get(AnswerBean.class, id);
		ab.setAnswer(answer);
		session.update(ab);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<AnswerBean> queryPaperIdAndExamineeId(String paperid,String examineeid){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from AnswerBean answer where answer.examineeid='"+examineeid+"' and answer.paperid='"+paperid+"'";
		Query query=session.createQuery(str);
		List<AnswerBean> elist=query.list();
		session.close();
		return elist;
	}
	@Override
	public List<AnswerBean> queryPaperIdAndExamineeIdAndQuestionid(String paperid,String examineeid,String questionid){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from AnswerBean answer where answer.examineeid='"+examineeid+"' and answer.paperid='"+paperid+"'"+
		" and answer.questionid='"+questionid+"'";
		Query query=session.createQuery(str);
		List<AnswerBean> elist=query.list();
		session.close();
		return elist;
	}
}
