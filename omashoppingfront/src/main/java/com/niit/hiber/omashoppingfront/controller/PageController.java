package com.niit.hiber.omashoppingfront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.hiber.omashoppingbackend.dao.CategoryDAO;
import com.niit.hiber.omashoppingbackend.dao.ProductDAO;
import com.niit.hiber.omashoppingbackend.dto.Product;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired 
	private ProductDAO productDAO;
	
	//@ModelAttribute("")
	
	/*@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcoome to spring");
		return mv;
	}
	*/
	
	
	
	@RequestMapping(value={"/","/home","/index","/Home"})
	public ModelAndView index()
	{
		//System.out.println(prin.getName());
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title","Home");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	/*
	
	@RequestMapping(value="/{greeting}")
	public ModelAndView greeting(@PathVariable("greeting") String greeting)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
	*/
	
	@RequestMapping("/products/all")
	public @ResponseBody List<Product> getAProducts()
	{
	return productDAO.list();	
	}
	
	
	
	
	/*
	@RequestMapping("/admin/products/all")
	public @ResponseBody List<Product> getAdminProd()
	{
		return productDAO.list();
	}
	
	

	@RequestMapping(value="/admin/products")
	public   ModelAndView getAdminProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("products",productDAO.list());
		mv.addObject("userClickAdmin", true);
		return mv;
	}
	
	
	
	
	*/
	@RequestMapping(value="/products")
	public   ModelAndView getAllProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("products",productDAO.list());
		mv.addObject("userClickProduct", true);
		return mv;
	}
	
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView getProduct(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Product Description");
		mv.addObject("product",productDAO.get(id));
		mv.addObject("userClickSProduct", true);
		return mv;
	}
	
	
	
	  // display the login view

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false)String error, Model model) {
	if(error!=null) {
	model.addAttribute("error","Authentication Failed - Invalid credentials!");
	}
	model.addAttribute("title", "Login");
	return "login";
	} 

	
	

}
