package com.ecom.Ecommerce_Website.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecom.Ecommerce_Website.dto.Product;


public interface productService {
	public Product saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Boolean deleteProduct(int id);
	
	public Product getProductById(Integer id);
	
	public Product updateProduct(Product product, MultipartFile file);
	
	public List<Product> getAllActiveProducts(String Category);
	
	
}
