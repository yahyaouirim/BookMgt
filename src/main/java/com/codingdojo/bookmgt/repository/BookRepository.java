package com.codingdojo.bookmgt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookmgt.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();
}
