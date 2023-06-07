package com.Broadway.FinalprojectBroadway.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Broadway.FinalprojectBroadway.Model.Book;
import com.Broadway.FinalprojectBroadway.Repository.BookRepository;
import com.Broadway.FinalprojectBroadway.Service.BookService;
@Service
public class BookServiceImpl implements BookService{
    @Autowired
	private BookRepository bookRepo;
	@Override
	public void addBook(Book book) {
		
		bookRepo.save(book);
	}

	@Override
	public void deleteBook(int id) {
		
		bookRepo.deleteById(id);
		
	}

	@Override
	public Book getBookById(int id) {
		
		return bookRepo.findById(id).get();
	}

	@Override
	public List<Book> getAllBook() {
		
		return bookRepo.findAll();
	}

	@Override
	public void updateBook(Book book) {
		bookRepo.save(book);
		
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		
		return bookRepo.findByCategory(category);
	}

	@Override
	public List<Book> search(String keyword) {
		
		return bookRepo.findByAnameContainingIgnoreCaseOrBnameContainingIgnoreCase(keyword, keyword);
				
	}

}
