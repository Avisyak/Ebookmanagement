package com.Broadway.FinalprojectBroadway.Service;

import java.util.List;

import com.Broadway.FinalprojectBroadway.Model.Book;

public interface BookService {
	
	void addBook(Book book);
	void deleteBook(int id);
	void updateBook(Book book);
    Book getBookById(int id);
    List<Book> getAllBook();
    List<Book> getBookByCategory(String category);
    List<Book> search(String keyword);

}
