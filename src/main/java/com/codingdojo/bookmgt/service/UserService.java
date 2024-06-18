package com.codingdojo.bookmgt.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookmgt.entity.User;
import com.codingdojo.bookmgt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	
    // This method will be called from the controller
    // whenever a user submits a registration form.
    
    public User register(User newUser, BindingResult result) {
    
    	// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email", "Unique", "email is already taken !");
    	}
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("password", "Unique", "password no match !");
        }
        // Return null if result has errors
        if(result.hasErrors()) {
        	return null;
        }
        String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPassword);
        // Hash and set password, save user to database
        
    	return userRepo.save(newUser);
    }
    
    public User findUserById(Long id) {
    	Optional<User> user = userRepo.findById(id);
    	if(user.isPresent()) {
    		return user.get();
    	}
    	else {
    		return null;
    	}
    }

}
