package com.hainan.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class HomeController {
	@RequestMapping()
	public ModelAndView home(){
		return new ModelAndView("index");
	}
}
