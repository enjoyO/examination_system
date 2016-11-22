package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.TestBean;

public class TestDaoImp implements TestDao{
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	public TestBean getTest(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		TestBean tb=(TestBean) session.get(TestBean.class,id);
		session.close();
		return tb;
	}
	@Override
	public void insert(TestBean tb){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(tb);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		TestBean tb=(TestBean) session.get(TestBean.class,id);
		session.delete(tb);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<TestBean> queryPaperId(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from TestBean tb where tb.paperid='"+id+"'";
		Query query=session.createQuery(str);
		List<TestBean> tlist=query.list();
		session.close();
		return tlist;
	}
	@Override
	public List<TestBean> queryExamineeId(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from TestBean tb where tb.examineeid='"+id+"'";
		Query query=session.createQuery(str);
		List<TestBean> tlist=query.list();
		session.close();
		return tlist;
	}
	@Override
	public List<TestBean> queryPaperIdAndExamineeId(String paperid, String Examineeid){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from TestBean tb where tb.examineeid='"+Examineeid+"' and tb.paperid='"+paperid+"'";
		Query query=session.createQuery(str);
		List<TestBean> tlist=query.list();
		session.close();
		return tlist;
	}
	@Override
	public void updateScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		TestBean test=(TestBean) session.get(TestBean.class, id);
		test.setScore(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateSingleScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		TestBean test=(TestBean) session.get(TestBean.class, id);
		test.setSingle(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateMultipleScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		TestBean test=(TestBean) session.get(TestBean.class, id);
		test.setMultiple(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateJudgeScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		TestBean test=(TestBean) session.get(TestBean.class, id);
		test.setJudge(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateEssayScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		TestBean test=(TestBean) session.get(TestBean.class, id);
		test.setEssay(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateTeacherScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		TestBean test=(TestBean) session.get(TestBean.class, id);
		test.setTeacherscore(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
}
