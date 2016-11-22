package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.QuestionBean;

public class QuestionDaoImp implements QuestionDao {
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	public QuestionBean getQuestion(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		QuestionBean question=(QuestionBean) session.get(QuestionBean.class, id);
		session.close();
		return question;
	}
	@Override
	public void insert(QuestionBean question){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(question);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void deleteQuestion(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		QuestionBean question=(QuestionBean) session.get(QuestionBean.class, id);
		session.delete(id);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<QuestionBean> queryPaperId(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from QuestionBean qb where qb.paperid='"+id+"'";
		Query query=session.createQuery(str);
		List<QuestionBean> qlist=query.list();
		session.close();
		return qlist;
	}
	@Override
	public void delete(String questionid) {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		QuestionBean question=(QuestionBean) session.get(QuestionBean.class, questionid);
		session.delete(question);
		session.getTransaction().commit();
		session.close();
	}

}
