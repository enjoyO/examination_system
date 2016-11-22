package com.hainan.cs.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hainan.cs.bean.PaperBean;
import com.hainan.cs.dao.PaperDaoImp;
import com.hainan.cs.dao.UserDaoImp;
import com.hainan.cs.singleton.PassAndName;

@Controller
@RequestMapping(value="/search")
public class SearchController {
	@RequestMapping(value="/bypapername")
	public ModelAndView byname(String papername){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		PaperDaoImp pdi=context.getBean(PaperDaoImp.class);
		List<PaperBean> plist=pdi.queryName(papername);
		String str="";
		for(int i=0;i<plist.size();i++){
			PaperBean paper=plist.get(i);
			str=str+"<tr class=\"danger\"><td>"+paper.getId()+"</td><td>"+paper.getPapername()+"</td><td>"
					+paper.getPaperinfo()+"</td><td>"+paper.getType()+
					"</td><td><a class=\"btn\" href=\"examine?paperid="+paper.getId()+"\">test</a>"+
					"</td><td><a class=\"btn\" href=\"newexamine?paperid="+paper.getId()+"\">new test</a>"+
					"</td></tr>";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/homepage?tag="+3+"&pps="+str);
		context.close();
		return mav;
	}
	
	@RequestMapping(value="/bypaperid")
	public ModelAndView byId(String paperid){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		PaperDaoImp pdi=context.getBean(PaperDaoImp.class);
		PaperBean paper=pdi.getPaper(paperid);
		String str="<tr class=\"danger\"><td>"+paper.getId()+"</td><td>"+paper.getPapername()+"</td><td>"
				+paper.getPaperinfo()+"</td><td>"+paper.getType()+
				"</td><td><a class=\"btn\" href=\"examine?paperid="+paperid+"\">test</a>"+
				"</td><td><a class=\"btn\" href=\"newexamine?paperid="+paperid+"\">new test</a>"+
				"</td></tr>";
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/homepage?tag="+3+"&pps="+str);
		context.close();
		return mav;
	}
}
