package com.hainan.cs.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hainan.cs.bean.UserBean;
import com.hainan.cs.dao.UserDaoImp;
import com.hainan.cs.singleton.PassAndName;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	@RequestMapping()
	public ModelAndView login(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		mav.addObject("tag",0);
		return mav;
	}
	@RequestMapping(value="/userlogin")
	public ModelAndView submitLogin(String username,String password){
		System.out.println("用户名"+username);
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		UserDaoImp udi=context.getBean(UserDaoImp.class);
		List<UserBean> userlist=udi.queryUser(username);
		if(userlist.size()>0){
			UserBean user=userlist.get(0);
			String pass=user.getPassword();
			if(pass.equals(password)){
				//密码正确
				System.out.println("密码正确");
				//构建单例模式
				PassAndName pass_name=PassAndName.getInstance();
				pass_name.setPassword(password);
				pass_name.setUsername(username);
				mav.setViewName("redirect:/homepage?tag="+0);
				return mav;
			}else{
				//密码错误
				System.out.println("密码错误");
				mav.setViewName("login");
				mav.addObject("tag", 1);
				return mav;
			}
		}else{
			//用户不存在
			System.out.println("用户不存在");
			mav.setViewName("login");
			mav.addObject("tag", 1);
			return mav;
		}
	}
}
