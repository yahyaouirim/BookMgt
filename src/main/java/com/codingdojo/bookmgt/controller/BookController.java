package com.codingdojo.bookmgt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookmgt.entity.Book;
import com.codingdojo.bookmgt.entity.Library;
import com.codingdojo.bookmgt.entity.User;
import com.codingdojo.bookmgt.service.BookService;
import com.codingdojo.bookmgt.service.LibraryService;
import com.codingdojo.bookmgt.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	
	BookService bookService;
	LibraryService libService;
	UserService userService;

	public BookController(BookService bookService, LibraryService libService,UserService userService) {
		this.bookService = bookService;
		this.libService = libService;
		this.userService = userService;
	}
	
	@GetMapping("/book/new")
	public String newBook(@ModelAttribute("book") Book book, Model model) {
		List<Library> libraries = libService.getAll();
		model.addAttribute("libraries", libraries);
		return "newBook.jsp";
	}
	
	   @PostMapping("/books")
	    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		 
	        if (result.hasErrors()) {
	            return "newBook.jsp";
	        } else {
	            bookService.createBook(book);
	            return "redirect:/dashboard";
	        }
	    }
	   
	   @GetMapping("/dashboard")
	   public String dashboard(Model model,HttpSession session) {
		  Long id =  (Long)session.getAttribute("user_id");
		  if(id==null) {
			  return "redirect:/";
		  }
		  User user = userService.findUserById(id);
		  List<Book> bookList = bookService.getAll();
		  model.addAttribute("books", bookList);
		  model.addAttribute("user", user);
		   return "dashboard.jsp";
	   }
	    @RequestMapping("edit/book/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Book book = bookService.findOneBook(id);
	        model.addAttribute("book", book);
	        return "bookUpdate.jsp";
	    }
	    
	    @PutMapping(value="/edit/book/{id}")
	    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            model.addAttribute("book", book);
	            return "bookUpdate.jsp";
	        } else {
	            bookService.updateBook(book);
	            return "redirect:/dashboard";
	        }
	    }
	    @DeleteMapping(value="/delete/book/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	        bookService.deleteBook(id);
	        return "redirect:/dashboard";
	    }
}
