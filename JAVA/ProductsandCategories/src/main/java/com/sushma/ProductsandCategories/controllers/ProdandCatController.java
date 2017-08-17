package com.sushma.ProductsandCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.sushma.ProductsandCategories.models.Category;
import com.sushma.ProductsandCategories.models.Product;
import com.sushma.ProductsandCategories.services.CategoryService;
import com.sushma.ProductsandCategories.services.ProductService;

@Controller
public class ProdandCatController {
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public ProdandCatController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}

    @RequestMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
    		System.out.println("qwqwqw");
        return "newCategory.jsp";
    }
    
    @PostMapping("/categories/new")
    public String createPerson(@Valid @ModelAttribute("category") Category category, BindingResult result) {
    		if(result.hasErrors()) {
    			return "newCategory.jsp";
    		}else {
    			categoryService.addCategory(category);
    			return "redirect:/categories/new";
    		}
    }
    @RequestMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
    		System.out.println("qwqwqw");
        return "newProduct.jsp";
    }
    
    @PostMapping("/products/new")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
    		if(result.hasErrors()) {
    			return "newProduct.jsp";
    		}else {
    			productService.addProduct(product);
    			return "redirect:/products/new";
    		}
    }
    
    @RequestMapping("/categories/{id}")
    public String addingProducttoCategoryView(Model model, @PathVariable("id") Long id, @ModelAttribute("product") Product product) {
    		System.out.println("prodcat");
    		Category cat = categoryService.findCatById(id);
    		List<Product> products = productService.allProducts();
    		model.addAttribute("category", cat);
    		model.addAttribute("allproduct", products);
        return "showCategory.jsp";
    }
    
    @PostMapping("/categories/{id}/new")
    public String createProducttoCategory(@PathVariable("id") Long id, @RequestParam(value="product1") Long productId, @Valid @ModelAttribute("product") Product product, BindingResult result) {
    		if(result.hasErrors()) {
    			System.out.println(result.getAllErrors());
    			return "showCategory.jsp";
    		}else {
    			System.out.println(product.getName());
    			System.out.println(product.getId());
    			System.out.println("dsds");
    			productService.addCategoryToProduct(productId, id);
    			return "redirect:/categories/new";
    		}
    }

    @RequestMapping("/products/{id}")
    public String addingCategorytoProductView(Model model, @PathVariable("id") Long id, @ModelAttribute("category") Category category) {
    		System.out.println("category");
    		Product prod = productService.findProdById(id);
    		List<Category> allcategories = categoryService.allCategories();
    		model.addAttribute("allcategories", allcategories);
    		model.addAttribute("product", prod);
        return "showProduct.jsp";
    }
    
    @PostMapping("/products/{id}/new")
    public String createCategorytoProduct(@PathVariable("id") Long prodid, @RequestParam(value="category1") Long categoryId, @Valid @ModelAttribute("category") Category category, BindingResult result) {
    		if(result.hasErrors()) {
    			System.out.println(category);
    			return "showProduct.jsp";
    		}else {
    			System.out.println(category.getName());
    			System.out.println(category.getId());
    			System.out.println("products");
    			categoryService.addProductToCategory(prodid, categoryId);
    			return "redirect:/products/new";
    		}
    }
    
}
