package com.ecom.Ecommerce_Website.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ecom.Ecommerce_Website.dto.Category;
import com.ecom.Ecommerce_Website.repository.CategoryRepository;
import com.ecom.Ecommerce_Website.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;	
	

	@Override
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Boolean existCategory(String name) {
		
		return categoryRepository.existsByName(name);
	}

	@Override
	public boolean deleteCategory(int id) {
		
		 Category category = categoryRepository.findById(id).orElse(null);
		 if(!ObjectUtils.isEmpty(category)) {
			 categoryRepository.delete(category);
			 return true;
		 }
		 return false;
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		return category;
	}

	@Override
	public List<Category> getAllActiveCategory() {
		List<Category> categories = categoryRepository.findByIsActiveTrue();
		return categories;
	}

}
