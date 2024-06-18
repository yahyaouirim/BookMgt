package com.codingdojo.bookmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookmgt.entity.Library;
import com.codingdojo.bookmgt.repository.LibRepository;

@Service
public class LibraryService {

	@Autowired
	LibRepository libRepo;
	
	public Library createLib(Library lib) {
		return libRepo.save(lib);
	}
	
	public List<Library> getAll(){
		return libRepo.findAll();
	}
}
