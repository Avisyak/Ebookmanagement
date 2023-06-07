package com.Broadway.FinalprojectBroadway.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.Broadway.FinalprojectBroadway.Service.BookService;

@Controller
public class BookByCategoryController {
	@Autowired
	private BookService bookService;
	@GetMapping("/bookByCategory")
	public String getnovelBook(@RequestParam String category, Model model) {
		
		
		/*
		 * String[] imgNames=new File("src/main/resources/static/image").list();
		 * model.addAttribute("ilist",imgNames);
		 */
		model.addAttribute("ilist",bookService.getBookByCategory(category));
		return "BookByCategory";
	}
	
	
	
	
	
}
