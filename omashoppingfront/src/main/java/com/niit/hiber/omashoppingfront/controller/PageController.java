package com.niit.hiber.omashoppingfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value={"/","/home","/index","/Home"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	
	@RequestMapping(value="/{greeting}")
	public ModelAndView greeting(@PathVariable("greeting") String greeting)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
	
	
	@RequestMapping(value={"/login","/Login"})
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("Login");
		mv.addObject("title","Login");
		mv.addObject("userClickLogin", true);
		return mv;
	}
	
	

}
