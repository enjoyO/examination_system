package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.MCQBean;

public class MCQDaoImp implements MCQDao{
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	public MCQBean getMCQB(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		MCQBean mcqb=(MCQBean) session.get(MCQBean.class, id);
		session.close();
		return mcqb;
	}
	@Override
	public void insert(MCQBean mcqb){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(mcqb);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		MCQBean mcqb=(MCQBean) session.get(MCQBean.class, id);
		session.delete(mcqb);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<MCQBean> queryPaper(String paperid){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from MCQBean mcqb where mcqb.paperid='"+paperid+"'";
		Query query=session.createQuery(str);
		List<MCQBean> mcqb=query.list();
		session.close();
		return mcqb;
	}
}
