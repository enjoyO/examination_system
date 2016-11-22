package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hainan.cs.bean.JudgeQuestionBean;

public class JudgeDaoImp implements JudgeDao{
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	public JudgeQuestionBean getJQB(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		JudgeQuestionBean jqb=(JudgeQuestionBean) session.get(JudgeQuestionBean.class, id);
		session.close();
		return jqb;
	}
	@Override
	public void insert(JudgeQuestionBean jqb){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(jqb);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		JudgeQuestionBean jqb=(JudgeQuestionBean) session.get(JudgeQuestionBean.class, id);
		session.delete(jqb);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<JudgeQuestionBean> queryPaper(String id){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from JudgeQuestionBean jqb where jqb.paperid='"+id+"'";
		Query query=session.createQuery(str);
		List<JudgeQuestionBean> jlist=query.list();
		session.close();
		return jlist;
	}
	public static void main(String args[]){
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("spring/application-config.xml");
		JudgeDaoImp jdi=context.getBean(JudgeDaoImp.class);
		JudgeQuestionBean jqb=new JudgeQuestionBean();
		jqb.setDescription("Jobs is the creater of Apple?");
		jqb.setAnswer("yes");
		jqb.setPaperid("test");
		jdi.insert(jqb);
		List<JudgeQuestionBean> list=jdi.queryPaper("test");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId());
		}
	}
}
