package com.codingdojo.bookmgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.bookmgt.entity.User;
import com.codingdojo.bookmgt.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String newUser(@ModelAttribute("user") User user) {
		return "registration.jsp";
	}
	
	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult results, HttpSession session) {
		
		User newUser = userService.register(user, results);
		
		if(results.hasErrors()) {
			return "redirect:/";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}
}
