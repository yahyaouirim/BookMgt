package com.codingdojo.bookmgt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookmgt.entity.Library;

@Repository
public interface LibRepository extends CrudRepository<Library, Long> {
List<Library> findAll();
}
