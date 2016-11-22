package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.ChoiceQuestionBean;
import com.hainan.cs.bean.UserBean;

public class ChoiceDaoImp implements ChoiceDao{
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	public ChoiceQuestionBean getCQB(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		ChoiceQuestionBean cqb=(ChoiceQuestionBean) session.get(ChoiceQuestionBean.class, id);
		session.close();
		return cqb;
	}
	@Override
	public void insert(ChoiceQuestionBean cqb){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(cqb);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		ChoiceQuestionBean cqb=(ChoiceQuestionBean) session.get(ChoiceQuestionBean.class, id);
		session.delete(cqb);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<ChoiceQuestionBean> queryPaper(String paperid){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from ChoiceQuestionBean cqb where cqb.paperid='"+paperid+"'";
		Query query=session.createQuery(str);
		List<ChoiceQuestionBean> cqb=query.list();
		session.close();
		return cqb;
	}
}
