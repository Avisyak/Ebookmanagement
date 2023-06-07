package com.Broadway.FinalprojectBroadway.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Broadway.FinalprojectBroadway.Model.SellBook;
import com.Broadway.FinalprojectBroadway.Service.SellBookService;


@Controller
public class SellbookController {
	
	@Autowired
	private SellBookService sellService;
	
	@GetMapping("/sellbook")
	public String getSell(HttpSession session) {
         if(session.getAttribute("activeuser") ==null) { 
			 
			 
			 return "UserLogin"; 
			 
		 }
		return "SellBooks";
	}
	@PostMapping("/sellbook")
	public String postSellbook(@ModelAttribute SellBook book ,Model model,@RequestParam MultipartFile image) {
		if(!image.isEmpty()) {
    		try {
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/sellimage/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		book.setPhoto(image.getOriginalFilename());
		sellService.sellBook(book);
		model.addAttribute("message","your books details are added for sell");
		
		return "SellBooks";
		
	}

}
