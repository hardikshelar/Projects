package com.ecom.Ecommerce_Website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.Ecommerce_Website.dto.Category;
import com.ecom.Ecommerce_Website.dto.Customers;
import com.ecom.Ecommerce_Website.dto.Product;
import com.ecom.Ecommerce_Website.service.CategoryService;
import com.ecom.Ecommerce_Website.service.CustomerService;
import com.ecom.Ecommerce_Website.service.iml.ProductServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	public CustomerService customerservice;
	
	@Autowired
	public CategoryService cetegoryService;
	
	@Autowired
	public ProductServiceImpl productService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("/product")
	public String product(Model m, @RequestParam(value= "/category", defaultValue = "") String category) {
		System.out.println("Category= "+category);
		List<Category> categories = cetegoryService.getAllActiveCategory();
		List<Product> products = productService.getAllActiveProducts(category);
		m.addAttribute("categories",categories);
		m.addAttribute("products",products);
		m.addAttribute("paramValue",category);
		return "product";
	}
	
	@GetMapping("/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model  m) {
		Product productById = productService.getProductById(id);
		m.addAttribute("product",productById);
		return "viewProduct";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute Customers customers,HttpSession session) {
		Customers saveCustomer = customerservice.saveCustomer(customers);
		
		if(!ObjectUtils.isEmpty(saveCustomer)) {
			session.setAttribute("succMsg", "Registered Successfully");
		}
		else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/register";
	}
}
