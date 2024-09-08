package com.ecom.Ecommerce_Website.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.Ecommerce_Website.dto.Category;
import com.ecom.Ecommerce_Website.dto.Product;
import com.ecom.Ecommerce_Website.service.CategoryService;
import com.ecom.Ecommerce_Website.service.productService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private productService productService;
	
	@GetMapping("/")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/addProduct")
	public String loadAddProduct(Model m) {
		List<Category> allCategory = categoryService.getAllCategory();
		m.addAttribute("categories",allCategory);
		return "admin/add_product";
	}
	
	@GetMapping("/category")
	public String category(Model model) {
		model.addAttribute("categories",categoryService.getAllCategory());
		return "admin/category";
	}
	
	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute Category category,@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
		
		String imageName = file != null ? file.getOriginalFilename() : "default.jpg";
		category.setImageName(imageName);
		if(categoryService.existCategory(category.getName())) {
			session.setAttribute("errorMsg", "Category name already exists!");
		} else {
			Category saveCategory = categoryService.saveCategory(category);
			if(ObjectUtils.isEmpty(saveCategory)) {
				session.setAttribute("errorMsg", "Not Saved! internal server error");
			}
			else {
				
				File savefile = new ClassPathResource("static/img").getFile();
				
				Path path = Paths.get(savefile.getAbsolutePath()+File.separator+"Category"+File.separator+file.getOriginalFilename());
				System.out.println(path);
				
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				session.setAttribute("succMsg", "Saved Successfully");
			}
		}
		
		return "redirect:/admin/category";
	}
	
	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id,HttpSession session) {
		boolean deleteCategory = categoryService.deleteCategory(id);
		if(deleteCategory) {
			session.setAttribute("succMsg", "Category delete Success");
		}
		else {
			session.setAttribute("errorMsg", "Something Wrong on server");
		}
		return "redirect:/admin/category";
	}
	
	@GetMapping("/loadEditCategory/{id}")
	public String loadEditCategory(@PathVariable int id, Model m) {
		m.addAttribute("category",categoryService.getCategoryById(id));
		return "admin/edit_category";
	}
	
	@PostMapping("/updateCategory")
	public String updateCategory(@ModelAttribute Category category, @RequestParam("file") MultipartFile file,
			HttpSession session) throws IOException {
		
		Category categoryById = categoryService.getCategoryById(category.getId());
		String imageName = file.isEmpty() ? categoryById.getImageName():file.getOriginalFilename();
		if(!ObjectUtils.isEmpty(categoryById)) {
			categoryById.setName(category.getName());
			categoryById.setIsActive(category.getIsActive());
			categoryById.setImageName(imageName);
		}
		
		Category updateCategory = categoryService.saveCategory(categoryById);
		
		if(!ObjectUtils.isEmpty(updateCategory)) {
			
			if(!file.isEmpty()) {
				File savefile = new ClassPathResource("static/img").getFile();
				
				Path path = Paths.get(savefile.getAbsolutePath()+File.separator+"Category"+File.separator+file.getOriginalFilename());
				
				
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			}
			session.setAttribute("succMsg", "Category Update Success");
			
		} else 
			session.setAttribute("errorMsg", "Something Wrong on server");
		return "redirect:/admin/loadEditCategory/"+category.getId();
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute Product product,@RequestParam ("file")MultipartFile image, HttpSession session) throws IOException {
		
		String imageName = image.isEmpty() ? "default.jpg": image.getOriginalFilename();
		product.setImage(imageName);
		product.setDiscount(0);
		product.setDiscountPrice(product.getPrice());
		Product saveProduct = productService.saveProduct(product);
		
		if(!ObjectUtils.isEmpty(saveProduct)) {
			File savefile = new ClassPathResource("static/img").getFile();
			
			Path path = Paths.get(savefile.getAbsolutePath()+File.separator+"Category"+File.separator+image.getOriginalFilename());
//			System.out.println(path);
			
			Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			session.setAttribute("succMsg", "Product saved Successfully");
		}
		else {
			session.setAttribute("errorMsg", "Something Wrong on Server");
		}
		return "redirect:/admin/addProduct";
	}
	
	@GetMapping("/products")
	public String loadViewProduct(Model m) {
		m.addAttribute("products",productService.getAllProducts());
		return "admin/products";
	}
	
	@GetMapping("/deleteproducts/{id}")
	public String deleteProduct(@PathVariable int id, HttpSession session) {
		Boolean deleteProduct = productService.deleteProduct(id);
		if(deleteProduct) {
			session.setAttribute("succMsg", "Product Deleted Successfully");
		}
		else {
			session.setAttribute("errorMsg", "Something Wrong on server");
		}
		return "redirect:/admin/products";
	}
	
	@GetMapping("/editProduct/{id}")
	public String editProduct(@PathVariable  int id, Model m) {
		m.addAttribute("product",productService.getProductById(id));
		m.addAttribute("categories",categoryService.getAllCategory());
		return "admin/edit_product";
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute  Product product,@RequestParam("file") MultipartFile image, HttpSession session, Model m) {
	
		if(product.getDiscount()<0 || product.getDiscount()>100) {
			session.setAttribute("errorMsg", "Invalid discount");
		}
		else {
		Product updateProduct = productService.updateProduct(product, image);
		if(!ObjectUtils.isEmpty(updateProduct)) {
			session.setAttribute("succMsg", "Product Update Success");
		}
		else {
			session.setAttribute("errorMsg", "Something Wrong on server");
		}
		}
		return "redirect:/admin/editProduct/"+product.getId();
	}
	
	
}
