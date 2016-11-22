package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.AnswerBean;
import com.hainan.cs.bean.NewAnswer;

public class NewAnswerDaoImp implements NewAnswerDao {
private SessionFactory sessionfactory;
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sesstionfactory) {
		this.sessionfactory = sesstionfactory;
	}
	@Override
	public NewAnswer getAnswer(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewAnswer answer=(NewAnswer) session.get(NewAnswer.class, id);
		session.close();
		return answer;
	}
	@Override
	public void insert(NewAnswer answer){
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
		NewAnswer answer=(NewAnswer) session.get(NewAnswer.class, id);
		session.delete(answer);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<NewAnswer> queryQuestionId(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from NewAnswer answer where answer.questionid='"+id+"'";
		Query query=session.createQuery(str);
		List<NewAnswer> alist=query.list();
		session.close();
		return alist;
	}
	@Override
	public List<NewAnswer> queryExamineeId(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from NewAnswer answer where answer.examineeid='"+id+"'";
		Query query=session.createQuery(str);
		List<NewAnswer> elist=query.list();
		session.close();
		return elist;
	}
	@Override
	public void update(String id,String answer){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewAnswer ab=(NewAnswer) session.get(NewAnswer.class, id);
		ab.setAnswer(answer);
		session.update(ab);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<NewAnswer> queryPaperIdAndExamineeId(String paperid,String examineeid){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from NewAnswer answer where answer.examineeid='"+examineeid+"' and answer.paperid='"+paperid+"'";
		Query query=session.createQuery(str);
		List<NewAnswer> elist=query.list();
		session.close();
		return elist;
	}
	@Override
	public List<NewAnswer> queryPaperIdAndExamineeIdAndQuestionid(String paperid,String examineeid,String questionid){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from NewAnswer answer where answer.examineeid='"+examineeid+"' and answer.paperid='"+paperid+"'"
				+" and answer.questionid='"+questionid+"'";
		Query query=session.createQuery(str);
		List<NewAnswer> elist=query.list();
		session.close();
		return elist;
	}
	@Override
	public void updateCreditA(String id,String credit){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewAnswer ab=(NewAnswer) session.get(NewAnswer.class, id);
		ab.setCredita(credit);;
		session.update(ab);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateCreditB(String id,String credit){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewAnswer ab=(NewAnswer) session.get(NewAnswer.class, id);
		ab.setCreditb(credit);;
		session.update(ab);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateCreditC(String id,String credit){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewAnswer ab=(NewAnswer) session.get(NewAnswer.class, id);
		ab.setCreditc(credit);;
		session.update(ab);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateCreditD(String id,String credit){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewAnswer ab=(NewAnswer) session.get(NewAnswer.class, id);
		ab.setCreditd(credit);;
		session.update(ab);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateCreditY(String id,String credit){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewAnswer ab=(NewAnswer) session.get(NewAnswer.class, id);
		ab.setCredity(credit);;
		session.update(ab);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateCreditN(String id,String credit){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		NewAnswer ab=(NewAnswer) session.get(NewAnswer.class, id);
		ab.setCreditn(credit);;
		session.update(ab);
		session.getTransaction().commit();
		session.close();
	}
}
