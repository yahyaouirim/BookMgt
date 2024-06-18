package com.codingdojo.bookmgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.codingdojo.bookmgt.entity.Library;
import com.codingdojo.bookmgt.service.LibraryService;

import jakarta.validation.Valid;

@Controller
public class LibraryController {

	
	@Autowired
	LibraryService libService;
	
	@GetMapping("/lib/new")
	public String newLib(@ModelAttribute("lib") Library lib) {
		return "libForm.jsp";
	}
	
	   @PostMapping("/lib")
	    public String create(@Valid @ModelAttribute("lib") Library lib, BindingResult result) {
	        if (result.hasErrors()) {
	            return "libForm.jsp";
	        } else {
	            libService.createLib(lib);
	            return "redirect:/dashboard";
	        }
	    }
}
