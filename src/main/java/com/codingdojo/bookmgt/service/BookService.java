package com.codingdojo.bookmgt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookmgt.entity.Book;
import com.codingdojo.bookmgt.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book findOneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
