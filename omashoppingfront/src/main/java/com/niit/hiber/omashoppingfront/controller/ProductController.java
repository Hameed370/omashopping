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

import com.niit.hiber.omashoppingbackend.dao.ProductDAO;
import com.niit.hiber.omashoppingbackend.dto.Product;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

	@Autowired
	private  ProductDAO productDAO;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String newProduct(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("userClickAdminProduct", true);
		return "page";
	}
	
	
	
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("product") Product product, BindingResult result,
			SessionStatus status, ModelMap model) {
		System.out.println(product);
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("userClickAdminProduct", true);
			return "page";
		}
		// code to upload image
		String uploadsDir = "/assets/images/products/";
		String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);

		if (!new File(realPathtoUploads).exists())
			new File(realPathtoUploads).mkdirs();

		MultipartFile file = (MultipartFile) product.getFiles();

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
		if (product.getId() != 0) {
			if (productDAO.update(product)) {
				model.addAttribute("success", "product updated");
			}
		} else {
			if (productDAO.add(product)) {
				model.addAttribute("success", "product added");
			}
		}

		return "redirect:/admin/product";

	}

	
	
	@RequestMapping("/allproduct")
	public @ResponseBody List<Product> getAProducts()
	{
	return productDAO.listAll();	
	}
	
	

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		productDAO.delete(productDAO.get(id));
		return "redirect:/admin/product";
	}
	
	
	@RequestMapping(value="/edit/{id}")
	public String updateProduct(@PathVariable("id") int id) {
		productDAO.update(productDAO.get(id));
		return "redirect:/admin/product";
	}
	
	
	/*@RequestMapping(value="/edit/product/{id}")
	public ModelAndView getProduct(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Product Description");
		
		mv.addObject("product",id);
		return mv;
	}*/
	
	
	@GetMapping(value = "/showProduct/{id}")
	public ModelAndView getProduct(@PathVariable("id") int id) {
		Product product = productDAO.get(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("product", product);
		mv.addObject("userClickAdminProduct", "true");

		return mv;
	}
	
	
	
	
	
}
