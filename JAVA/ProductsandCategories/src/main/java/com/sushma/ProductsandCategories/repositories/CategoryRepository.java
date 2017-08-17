package com.sushma.ProductsandCategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sushma.ProductsandCategories.models.Category;
import com.sushma.ProductsandCategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
