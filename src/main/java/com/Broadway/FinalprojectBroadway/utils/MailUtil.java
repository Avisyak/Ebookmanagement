package com.Broadway.FinalprojectBroadway.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String name, String email, String subject, String message) {
		SimpleMailMessage msg= new SimpleMailMessage();
		msg.setTo(name);
		msg.setTo(email);
		msg.setSubject(subject);
		msg.setText(message);
		
		javaMailSender.send(msg);
		
	}
   
	
}
