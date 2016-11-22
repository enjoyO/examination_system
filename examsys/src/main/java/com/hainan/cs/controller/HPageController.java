package com.hainan.cs.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hainan.cs.bean.NewTest;
import com.hainan.cs.bean.PaperBean;
import com.hainan.cs.bean.TestBean;
import com.hainan.cs.bean.UserBean;
import com.hainan.cs.dao.NewTestDaoImp;
import com.hainan.cs.dao.PaperDaoImp;
import com.hainan.cs.dao.TestDaoImp;
import com.hainan.cs.dao.UserDaoImp;
import com.hainan.cs.singleton.PassAndName;

@Controller
@RequestMapping(value="/homepage")
public class HPageController {
	@RequestMapping()
	public ModelAndView home(String tag,String pps){
		ModelAndView mav=new ModelAndView();
		PassAndName pan=PassAndName.getInstance();
		System.out.println("用户名是："+pan.getUsername());
		if(pan.getUsername()!=null){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		//显示个人信息
		UserDaoImp udi=context.getBean(UserDaoImp.class);
		UserBean user=udi.queryUser(pan.getUsername()).get(0);
		mav.addObject("username", user.getUsername());
		mav.addObject("email", user.getEmail());
		mav.addObject("phone", user.getPhone());
		mav.addObject("address", user.getAddress());
		mav.addObject("userid",user.getId());
		//显示创建的试卷信息
		PaperDaoImp pdi=context.getBean(PaperDaoImp.class);
		List<PaperBean> paperlist=pdi.queryCreatorId(user.getId());
		String papers="";
		for(int i=0;i<paperlist.size();i++){
			PaperBean paper=paperlist.get(i);
			System.out.println("试卷的ID"+paper.getId());
			papers=papers+"<tr class=\"danger\"><td>"+paper.getId()+"</td><td>"+
			paper.getPapername()+"</td><td>"+
			paper.getType()+"</td><td>"+paper.getTime()+"</td><td><a class=\"btn btn-primary\" href=\"paper?paperid="+paper.getId()+"\">modify questions</a>"+
			"</td><td><a class=\"btn btn-primary\" href=\"manage?paperid="+paper.getId()+"\">manage</a>"
			+"</td><td><a class=\"btn btn-primary\" href=\"newmanage?paperid="+paper.getId()+"\">new type manage</a>"
			+"</td></tr>";
			
		}
		mav.addObject("papers", papers);
		//显示参加的考试的信息
		TestDaoImp tdi=context.getBean(TestDaoImp.class);
		List<TestBean> tlist=tdi.queryExamineeId(user.getId());
		String joined="";
		for(int i=0;i<tlist.size();i++){
			String str="<tr class=\"danger\"><td>";
			TestBean test=tlist.get(i);
			PaperBean pb=pdi.getPaper(test.getPaperid());
			str=str+pb.getPapername()+"</td><td>"+pb.getType()+"</td><td>"+test.getScore()+"</td><td>"+test.getTeacherscore()+
					"</td><td>"+"<a class=\" btn btn-primary\" href=\"score?paperid="+test.getPaperid()+"&examineeid="+user.getId()
					+"\">check</a></td><td>"+"<a class=\"btn btn-primary\" href=\"examine?paperid="+
					test.getPaperid()+"\">test again</a></td></tr>";
			joined=joined+str;
		}
		mav.addObject("joined", joined);
		
		//显示参加的新型考试信息
		NewTestDaoImp ntdi=context.getBean(NewTestDaoImp.class);
		List<NewTest> ntlist=ntdi.queryExamineeId(user.getId());
		String newjoined="";
		for(int i=0;i<ntlist.size();i++){
			String str="<tr class=\"danger\"><td>";
			NewTest test=ntlist.get(i);
			PaperBean pb=pdi.getPaper(test.getPaperid());
			str=str+pb.getPapername()+"</td><td>"+pb.getType()+"</td><td>"+test.getScore()+"</td><td>"+test.getTeacherscore()+
					"</td><td>"+"<a class=\" btn btn-primary\" href=\"newscore?paperid="+test.getPaperid()+"&examineeid="+user.getId()
					+"\">check</a></td><td>"+"<a class=\"btn btn-primary\" href=\"newexamine?paperid="+
					test.getPaperid()+"\">test again</a></td></tr>";
			newjoined=newjoined+str;
		}
		mav.addObject("newjoined", newjoined);
		context.close();
		}

		//tag标记的作用是确定重定向时显示的图层
		mav.addObject("tag", tag);
		//显示搜索的结果信息
		mav.addObject("pps", pps);
		mav.setViewName("personpage");
		
		return mav;
	}
	@RequestMapping(value="/createpaper")
	public ModelAndView addPaperInfo(String papername, String papertype,String paperinfo,String papertime){
		ModelAndView mav=new ModelAndView();
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		PassAndName pan=PassAndName.getInstance();
		if(pan.getUsername()!=null){
		UserDaoImp udi=context.getBean(UserDaoImp.class);
		UserBean user=udi.queryUser(pan.getUsername()).get(0);
		PaperDaoImp pdi=context.getBean(PaperDaoImp.class);
		PaperBean paper=new PaperBean();
		paper.setPapername(papername);
		paper.setType(papertype);
		paper.setTime(papertime);
		paper.setPaperinfo(paperinfo);
		paper.setCreatorid(user.getId());
		pdi.insert(paper);
		}
		mav.setViewName("redirect:/homepage?tag="+1);
		System.out.println("类型"+papertype);
		context.close();
		return mav;
	}
	@RequestMapping(value="/modify")
	public ModelAndView modify(String username,String password,String phone
			,String email, String address,String userid){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		UserDaoImp udi=context.getBean(UserDaoImp.class);
		udi.updateAddress(userid, address);
		udi.updateEmail(userid, email);
		udi.updateName(userid, username);
		udi.updatePassword(userid, password);
		udi.updatePhone(userid, phone);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/login/userlogin?username="+username+"&password="+password);
		context.close();
		return mav;
	}
}
