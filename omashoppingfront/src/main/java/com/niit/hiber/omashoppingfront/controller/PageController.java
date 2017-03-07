package com.niit.hiber.omashoppingfront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	
	
	
	@RequestMapping(value="/products")
	public   ModelAndView getAllProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("products",productDAO.list());
		mv.addObject("userClickProduct", true);
		return mv;
	}
	/*
	
	@RequestMapping(value="/show/product/{id}")
	public ModelAndView getProduct(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Product Description");
		mv.addObject("greeting",id);
		return mv;
	}
	
	
	*/
	
	@RequestMapping(value={"/login","/Login"})
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("Login");
		mv.addObject("title","Login");
		mv.addObject("userClickLogin", true);
		return mv;
	}
	
	

}
