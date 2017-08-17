package com.sushma.ProductsandCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sushma.ProductsandCategories.models.Category;
import com.sushma.ProductsandCategories.models.Product;
import com.sushma.ProductsandCategories.repositories.CategoryRepository;
import com.sushma.ProductsandCategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	
	public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}

	public void addProduct(Product product) {
		productRepository.save(product);
		
	}

	public List<Product> allProducts() {
		return (List<Product>) productRepository.findAll();
	}

	public Product findProdById(Long id) {
		return productRepository.findOne(id);
	}
	
	public void addCategoryToProduct(Long productId, Long catId) {
		Product product = productRepository.findOne(productId);
		Category cat = categoryRepository.findOne(catId);
		product.getCategories().add(cat);
		productRepository.save(product);
	}

}
