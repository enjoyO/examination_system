package com.hainan.cs.singleton;

/**
 * 用户名和密码的单例
 * @author hl
 *
 */
public class PassAndName {
	private String password;
	private String username;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	private static PassAndName instance;
	private PassAndName(){}
	public static PassAndName getInstance(){
		if(instance==null){
			instance=new PassAndName();
			return instance;
		}else{
			return instance;
		}
	}
}
