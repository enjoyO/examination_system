package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hainan.cs.bean.UserBean;

public class UserDaoImp implements UserDao{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public UserBean getUser(String id){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserBean user=(UserBean) session.get(UserBean.class, id);
		session.close();
		return user;
	}
	@Override
	public void insert(UserBean user){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(String id){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserBean user=(UserBean) session.get(UserBean.class, id);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<UserBean> queryUser(String username){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String str="from UserBean user where username='"+username+"'";
		Query query=session.createQuery(str);
		List<UserBean> userlist=query.list();
		session.close();
		return userlist;
	}
	@Override
	public void updateName(String userid,String username){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserBean user=(UserBean) session.get(UserBean.class, userid);
		user.setUsername(username);
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updatePassword(String userid,String password){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserBean user=(UserBean) session.get(UserBean.class, userid);
		user.setPassword(password);;
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateEmail(String userid,String email){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserBean user=(UserBean) session.get(UserBean.class, userid);
		user.setEmail(email);;
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updatePhone(String userid,String phone){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserBean user=(UserBean) session.get(UserBean.class, userid);
		user.setPhone(phone);;
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateAddress(String userid,String address){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserBean user=(UserBean) session.get(UserBean.class, userid);
		user.setAddress(address);;
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	public static void main(String args[]){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/application-config.xml");
		UserDaoImp udi=context.getBean(UserDaoImp.class);
		UserBean user=new UserBean();
		user.setUsername("zhangsan");
		user.setPassword("zhangsan");
		udi.insert(user);
		List<UserBean> ulist=udi.queryUser("zhangsan");
		for(int i=0;i<ulist.size();i++){
			System.out.println(ulist.get(i).getId());
		}
	}
	
}
