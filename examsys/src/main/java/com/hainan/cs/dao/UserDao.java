package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.UserBean;

public interface UserDao {
	public UserBean getUser(String id);
	public void insert(UserBean user);
	void delete(String id);
	List<UserBean> queryUser(String username);
	void updateAddress(String userid, String address);
	void updatePhone(String userid, String phone);
	void updateEmail(String userid, String email);
	void updatePassword(String userid, String password);
	void updateName(String userid, String username);
}
