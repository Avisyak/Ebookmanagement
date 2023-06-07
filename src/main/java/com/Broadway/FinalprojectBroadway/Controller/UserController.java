package com.Broadway.FinalprojectBroadway.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Broadway.FinalprojectBroadway.Model.User;
import com.Broadway.FinalprojectBroadway.Service.UserService;
import com.Broadway.FinalprojectBroadway.utils.VerifyRecaptcha;

import lombok.extern.java.Log;

@Log
@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String getindex() {
		return "Index";
		
	}
	
	@GetMapping("/home")
	public String getHome(HttpSession session) {
		
		 if(session.getAttribute("activeuser") ==null) { 
			 
			 
			 return "UserLogin"; 
			 
		 }
		 
		 return "Home";
	}
	@GetMapping({"/login"})
	public String getLogin() {
		return "UserLogin";
	}
	@PostMapping("/login")
	public String getuserLogin(@ModelAttribute User user,Model model,HttpSession session,HttpServletRequest request) throws IOException {
		String recaptchaCode = request.getParameter("g-recaptcha-response");
		if(VerifyRecaptcha.verify(recaptchaCode)) {
			
			User usr = service.userLogin(user.getUsername(), user.getPassword());
			if(usr!=null) {
				 session.setAttribute("activeuser", usr); 
				 session.setMaxInactiveInterval(2000); 
				if("admin@gmail.com".equals(user.getUsername())&& "admin".equals(user.getPassword())) {
					model.addAttribute("message",usr.getFname());
					return"Admin";
				}
				log.info("=====Login Success====");
				
				return "Home";
			}
			log.info("=====Login Failed======");
			model.addAttribute("error","User not Found");
			return "UserLogin";
		}
		log.info("=====login failed =====");
		model.addAttribute("error","You are Robot");
		return "UserLogin";
	}
	@GetMapping("/signup")
	public String getSignup() {
		return "UserSignup";
		
	}
	@PostMapping("/signup")
	public String GetuserSignup(@ModelAttribute User user) {
		service.userSignup(user);
		return "UserSignup";
		
	}
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "UserLogin";
		
	}
	

}
