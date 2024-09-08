package com.ecom.Ecommerce_Website.service;

import java.util.List;

import com.ecom.Ecommerce_Website.dto.Category;

public interface CategoryService {
 public Category saveCategory(Category category);
 
 public Boolean existCategory(String name);
 
 public List<Category> getAllCategory();
 
 public boolean deleteCategory(int id);
 
 public Category getCategoryById(int id);
 
 public List<Category> getAllActiveCategory();
}
