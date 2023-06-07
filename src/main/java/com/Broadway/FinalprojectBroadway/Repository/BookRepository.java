package com.Broadway.FinalprojectBroadway.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Broadway.FinalprojectBroadway.Model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book>  findByCategory(String category);
    
	
	List<Book> findByAnameContainingIgnoreCaseOrBnameContainingIgnoreCase(String key1,String key2);
}
