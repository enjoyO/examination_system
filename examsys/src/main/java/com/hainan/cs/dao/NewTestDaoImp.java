package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.NewTest;
import com.hainan.cs.bean.TestBean;

public class NewTestDaoImp implements NewTestDao {
	private SessionFactory sessionfactory;

	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}


	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public NewTest getNewTest(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewTest test=(NewTest) session.get(NewTest.class,id);
		session.close();
		return test;
	}
	@Override
	public List<NewTest> queryExamineeId(String examineeid){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from NewTest newtest where newtest.examineeid='"+examineeid+"'";
		Query query=session.createQuery(str);
		List<NewTest> nlist=query.list();
		session.close();
		return nlist;
	}
	@Override
	public List<NewTest> queryPaperId(String paperid){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from NewTest newtest where newtest.paperid='"+paperid+"'";
		Query query=session.createQuery(str);
		List<NewTest> nlist=query.list();
		session.close();
		return nlist;
	}
	@Override
	public void insert(NewTest test){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewTest tb=(NewTest) session.get(NewTest.class,id);
		session.delete(tb);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<NewTest> queryPaperIdAndExamineeId(String paperid, String Examineeid){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from NewTest tb where tb.examineeid='"+Examineeid+"' and tb.paperid='"+paperid+"'";
		Query query=session.createQuery(str);
		List<NewTest> tlist=query.list();
		session.close();
		return tlist;
	}
	@Override
	public void updateScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewTest test=(NewTest) session.get(NewTest.class,id);
		test.setScore(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateSingleScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewTest test=(NewTest) session.get(NewTest.class,id);
		test.setSingle(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateMultipleScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewTest test=(NewTest) session.get(NewTest.class,id);
		test.setMultiple(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateJudgeScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewTest test=(NewTest) session.get(NewTest.class,id);
		test.setJudge(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateEssayScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewTest test=(NewTest) session.get(NewTest.class,id);
		test.setEssay(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateTeacherScore(String id,String score){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewTest test=(NewTest) session.get(NewTest.class,id);
		test.setTeacherscore(score);
		session.update(test);
		session.getTransaction().commit();
		session.close();
	}
}
