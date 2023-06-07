	package com.Broadway.FinalprojectBroadway.Controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Broadway.FinalprojectBroadway.Model.Book;

import com.Broadway.FinalprojectBroadway.Service.BookService;
import com.Broadway.FinalprojectBroadway.utils.BookExcelView;
import com.Broadway.FinalprojectBroadway.utils.OrderExcelView;



@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/addbook")
	public String getBook(HttpSession session) {
 if(session.getAttribute("activeuser") ==null) { 
			 
			 
			 return "UserLogin"; 
			 
		 }
		return "AddBook";
	}
	@PostMapping("/addbook")
	public String postBook(@ModelAttribute Book book,@RequestParam MultipartFile image,Model model)  {
		
		if(!image.isEmpty()) {
    		try {
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/image/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		book.setPhoto(image.getOriginalFilename());
		bookService.addBook(book);
		model.addAttribute("message","New Book Added");
		return "redirect:/addbook";
	}
	@GetMapping("/getAllbook")
	public String getAllBook(Model model,HttpSession session) {
         if(session.getAttribute("activeuser") ==null) { 
			 
			 
			 return "UserLogin"; 
			 
		 }
		model.addAttribute("blist",bookService.getAllBook());
		return "listBook";
		
	}
	@GetMapping("/deletebook")
	public String deleteBook(@RequestParam int id) {
		bookService.deleteBook(id);
		return "redirect:/getAllbook";
		
	}
	@GetMapping("/editbook")
	public String editBook(@RequestParam int id,Model model) {
		model.addAttribute("bookmodel",bookService.getBookById(id));
		return "Editbook";
		
	}
    @PostMapping("/updatebook")
	public String updateBook(@ModelAttribute Book book) {
		 bookService.addBook(book);
		 return"redirect:/getAllbook";
		
	}
    @GetMapping("/viewbook")
	public String viewBookById(@RequestParam int id,Model model) {
		model.addAttribute("viewBook",bookService.getBookById(id));
		return"View_books";
	}
    
    @GetMapping("/excelbook")
  	public ModelAndView exportToExcel() {
  		ModelAndView m =  new ModelAndView();
  		m.setView(new BookExcelView());

  		//read data from DB
  		List<Book> list = bookService.getAllBook();
  		//send to Excel Impl class
  		m.addObject("list", list);

  		return m;
  	}
    
    @GetMapping("/search")
    public String search(@Param("keyword") String keyword,Model model) {
    	List<Book> searchResult = bookService.search(keyword);
    	model.addAttribute("searchResult",searchResult);
    	
    	model.addAttribute("keyword",keyword);
    	return "search_book";
    }
}
