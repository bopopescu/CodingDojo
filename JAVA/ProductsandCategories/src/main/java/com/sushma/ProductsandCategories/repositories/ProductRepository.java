package com.sushma.ProductsandCategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sushma.ProductsandCategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
