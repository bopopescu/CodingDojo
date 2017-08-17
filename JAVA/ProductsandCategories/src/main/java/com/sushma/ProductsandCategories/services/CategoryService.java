package com.sushma.ProductsandCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sushma.ProductsandCategories.models.Category;
import com.sushma.ProductsandCategories.models.Product;
import com.sushma.ProductsandCategories.repositories.CategoryRepository;
import com.sushma.ProductsandCategories.repositories.ProductRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	
	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}


	public void addCategory(Category category) {
		categoryRepository.save(category);
		
	}


	public Category findCatById(Long id) {
		return categoryRepository.findOne(id);
	}


	public List<Category> allCategories() {
		return (List<Category>) categoryRepository.findAll();
	}


	public void addProductToCategory(Long productid, Long catid) {
		Product product = productRepository.findOne(productid);
		Category cat = categoryRepository.findOne(catid);
		cat.getProducts().add(product);
		categoryRepository.save(cat);
	}




}
