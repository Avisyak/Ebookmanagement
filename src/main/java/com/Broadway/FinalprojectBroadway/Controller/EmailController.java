package com.Broadway.FinalprojectBroadway.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Broadway.FinalprojectBroadway.utils.MailUtil;

@Controller
public class EmailController {
	
	@Autowired
	private MailUtil mailutil;
	
	@GetMapping("/contact")
	public String getContact(HttpSession session) {
          if(session.getAttribute("activeuser") ==null) { 
			 
			 
			 return "UserLogin"; 
			 
		 }
		return "Contact";
	}
	@PostMapping("/contact")
	public String postEmail(@RequestParam String name,@RequestParam String email,@RequestParam String subject,@RequestParam String message) {
	mailutil.sendEmail(name,email,subject,message);
	return "Contact";
		
	}

}
