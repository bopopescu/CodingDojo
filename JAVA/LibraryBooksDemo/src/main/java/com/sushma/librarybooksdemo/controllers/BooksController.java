package com.sushma.librarybooksdemo.controllers;

import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sushma.librarybooksdemo.models.Book;
import com.sushma.librarybooksdemo.services.BookService;

@Controller
public class BooksController {
	// private field. ->  tells us that we are going to be using a bookService and that it will not be changing
	//For final, it can be assigned different values at runtime when initialized. 
	private final BookService bookService;
	
	// constructor 
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/books")
	public String books(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	@RequestMapping("/books/{index}")
	public String findBookByIndex(Model model, @PathVariable("index") Long index) {
		Book book = bookService.findBookByIndex(index);
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "newBook.jsp";
    }
    
    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    		if(result.hasErrors()) {
    			return "newBook.jsp";
    		}else {
    			bookService.addBook(book);
    			return "redirect:/books";
    		}
    }
    
    @RequestMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, Model model) {	
		Book book = bookService.findBookById(id);
		if(book != null) {
			model.addAttribute("book", book);
		return "editBook.jsp";
	}
	else {
		return "redirect:/books";
	}
}

    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		else {
			bookService.updateBook(id, book);
			return "redirect:/books";
		}
    }
    
    @RequestMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") Long id) {
    		bookService.destroyBook(id);
    		return "redirect:/books";
    }
	
}
