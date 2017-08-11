package com.sushma.librarybooksdemo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sushma.librarybooksdemo.models.Book;
import com.sushma.librarybooksdemo.repositories.BookReposity;

@Service
public class BookService {
	//initialize the books variable with values
	private BookReposity bookReposity;
	public BookService(BookReposity bookRepository){
        this.bookReposity = bookRepository;
    }
	private List<Book> books = new ArrayList(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)		
    ));
	
	//returns all the books
	public List<Book> allBooks(){
		return (List<Book>) bookReposity.findAll();
	}

	public Book findBookByIndex(Long index) {
		if(index < books.size()) {
			return bookReposity.findOne(index);
			//return books.get(index);
		}
		else {
			return null;
		}
	}
	
	public void addBook(Book book) {
		bookReposity.save(book);
	}
	
	

	public void updateBook(int id, Book book) {
		bookReposity.save(book);
//		if(id< books.size()) {
//			books.set(id, book);
//		}
//		
	}

	public void destroyBook(Long id) {
		if(bookReposity.exists(id)) {
			bookReposity.delete(id);
		}
//		if(id< books.size()) {
//			books.remove(id);
//		}
	}
	
    public Book findBookById(Long id) {
        return bookReposity.findOne(id);
    }
	
	
}
