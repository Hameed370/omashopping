package com.niit.hiber.omashoppingfront.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.hiber.omashoppingbackend.dao.CategoryDAO;
import com.niit.hiber.omashoppingbackend.dto.Category;

@Controller
@RequestMapping("/admin")
public class AdminController {

	//this page is for category
	
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		Category category = new Category();
		model.addAttribute("category", category);
		model.addAttribute("userClickAdmin", true);
		return "page";
	}

	
	//this method will return list of categories in the form of JSON 
	@GetMapping("/allCategories")
	@ResponseBody
	public List<Category> allCategories() {

		return categoryDAO.list();
	}

	
	
	//CODE FOR ADDING CATEGORY
	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("category") Category category, BindingResult result,
			SessionStatus status, ModelMap model) {
		System.out.println(category);
		if (result.hasErrors()) {
			model.addAttribute("category", category);
			model.addAttribute("userClickAdmin", true);
			return "page";
		}
		// code to upload image
		String uploadsDir = "/assets/images/";
		String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);

		if (!new File(realPathtoUploads).exists())
			new File(realPathtoUploads).mkdirs();

		MultipartFile file = (MultipartFile) category.getFiles();

		String orgName = file.getOriginalFilename() + ".jpg";

		String filePath = realPathtoUploads + orgName;

		System.out.println(filePath);

		File destination = new File(filePath);
		try {

			file.transferTo(destination);

		} catch (IllegalStateException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// category.setImageURL(file.getOriginalFilename());
		if (category.getId() != 0) {
			if (categoryDAO.update(category)) {
				model.addAttribute("success", "category updated");
			}
		} else {
			if (categoryDAO.add(category)) {
				model.addAttribute("success", "category added");
			}
		}

		return "redirect:/admin";

	}

	@RequestMapping("/delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		categoryDAO.delete(id);
		return "redirect:/admin";
	}

	@GetMapping(value = "/showCategory/{id}")
	public ModelAndView getProduct(@PathVariable("id") int id) {
		Category category = categoryDAO.get(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("category", category);
		mv.addObject("userClickAdmin", "true");

		return mv;
	}

	/*
	 * 
	 * 
	 * @RequestMapping(value={"/myadmin"}) public ModelAndView index() {
	 * ModelAndView mv = new ModelAndView("page"); mv.addObject("title","Home");
	 * mv.addObject("categories", categoryDAO.list());
	 * mv.addObject("products",productDAO.list()); mv.addObject("product",new
	 * Product()); mv.addObject("userClickAdmin", true); return mv; }
	 * 
	 * 
	 * @RequestMapping("/myadmin/products/all") public @ResponseBody
	 * List<Product> getAProducts() { return productDAO.list(); }
	 * 
	 * 
	 * 
	 * /*@RequestMapping("/myadmin/add/product") public ModelAndView listPro() {
	 * ModelAndView mv = new ModelAndView("page"); mv.addObject("title","Home");
	 * mv.addObject("categories", categoryDAO.list());
	 * mv.addObject("products",productDAO.list());
	 * mv.addObject("userClickAdmin", true); return mv; }
	 */

	/*
	 * @RequestMapping("/myadmin/edit/product/{id}") public ModelAndView
	 * getProduct(@PathVariable("id") int id) { ModelAndView mv = new
	 * ModelAndView("page"); mv.addObject("products",productDAO.get(id));
	 * mv.addObject("userClickAdmin", true);; //mv.addObject("greeting",id);
	 * return mv; }
	 */

}
