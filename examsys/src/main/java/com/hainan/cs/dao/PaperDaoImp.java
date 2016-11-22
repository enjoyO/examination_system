package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.PaperBean;

public class PaperDaoImp implements PaperDao {
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	public PaperBean getPaper(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		PaperBean paper=(PaperBean) session.get(PaperBean.class,id);
		session.close();
		return paper;
	}
	@Override
	public void insert(PaperBean paper){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(paper);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		PaperBean paper=(PaperBean) session.get(PaperBean.class, id);
		session.delete(paper);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<PaperBean> queryCreatorId(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from PaperBean paper where paper.creatorid='"+id+"'";
		Query query=session.createQuery(str);
		List<PaperBean> plist=query.list();
		session.close();
		return plist;
	}
	@Override
	public List<PaperBean> queryType(String type){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from PaperBean paper where paper.type='"+type+"'";
		Query query=session.createQuery(str);
		List<PaperBean> plist=query.list();
		session.close();
		return plist;
	}
	@Override
	public List<PaperBean> queryName(String papername){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from PaperBean paper where paper.papername='"+papername+"'";
		Query query=session.createQuery(str);
		List<PaperBean> plist=query.list();
		session.close();
		return plist;
	}
	
}
