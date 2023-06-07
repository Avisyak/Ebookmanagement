package com.Broadway.FinalprojectBroadway.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Broadway.FinalprojectBroadway.Model.Book;
import com.Broadway.FinalprojectBroadway.Service.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BooksRestController {
    @Autowired
	private BookService bookService;
    
    @GetMapping("/book/api/list")
    public List<Book> getAllBook(){
    	
    	return bookService.getAllBook();
    }
    @PostMapping("/book/api/add")
    public String addBook(@RequestBody Book book) {
    	
    	bookService.addBook(book);
    	return "Addsuccess";
    }
    @PutMapping("/book/api/update")
    public String updateBook(@RequestBody Book book) {
    	bookService.updateBook(book);
    	return "UpdateSuccess";
    }
	@DeleteMapping("/book/api/delete/{id}")
    public String deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
		return "Delete Success";
    	
    }
	@GetMapping("/book/api/{id}")
	public Book getOneBook(@PathVariable int id) {
		return bookService.getBookById(id);
	}
	
	  @GetMapping("/book/api/category/{category}") 
	  public List<Book> getCatBook(@PathVariable String category) { 
		  return bookService.getBookByCategory(category);
	  
	  }
	 
}
