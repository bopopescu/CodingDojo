package com.sushma.librarybooksdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sushma.librarybooksdemo.models.Book;

public interface BookReposity extends CrudRepository<Book, Long>{

}
