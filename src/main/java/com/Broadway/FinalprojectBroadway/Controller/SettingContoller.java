package com.Broadway.FinalprojectBroadway.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Broadway.FinalprojectBroadway.Model.User;
import com.Broadway.FinalprojectBroadway.Service.UserService;

@Controller
public class SettingContoller {
	
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/setting")
	public String getSetting(HttpSession session) {
 if(session.getAttribute("activeuser") ==null) { 
			 
			 
			 return "UserLogin"; 
			 
		 }
		return "Setting";
		
	}
	@GetMapping("/edituser")
	public String editprofile(Model model,HttpSession session) {
           if(session.getAttribute("activeuser") ==null) { 
			 
			 
			 return "UserLogin"; 
			 
		 }
		User  u =  (User) session.getAttribute("activeuser");
		model.addAttribute("usermodel",u);
		return "EditProfile";
	}
	@PostMapping("/updateuser")
	public String updateprofile(@ModelAttribute User usr,Model model) {
		
		userservice.userSignup(usr);
		model.addAttribute("updatemsg","your details  updated");
		return "redirect:/edituser";
		
	}
	@GetMapping("/help")
	public String gethelp(HttpSession session) {
          if(session.getAttribute("activeuser") ==null) { 
			 
			 
			 return "UserLogin"; 
			 
		 }
		return"Help";
	}

}
