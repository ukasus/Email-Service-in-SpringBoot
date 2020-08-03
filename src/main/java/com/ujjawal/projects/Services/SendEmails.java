package com.ujjawal.projects.Services;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ujjawal.projects.Controller.Dto.Details;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;

@Service
public class SendEmails {
	 @Autowired 
	    it.ozimov.springboot.mail.service.EmailService emailService; 

	    @Value("${spring.mail.username}") String fromEmail; 
	  
	    public void SendEmail(Details details) throws UnsupportedEncodingException { 
	    	String message="Cake Orderd by: "+details.getName()+"\nMobileNumber: "+details.getPhone()+"\nCake Type: "+details.getType()+"\nCake Size: "+
	    details.getSize();
	        
	        final Email email = DefaultEmail.builder() 
	            .from(new InternetAddress(fromEmail, "HareKrishnaConfectionary"))
	            .to(Lists.newArrayList(new InternetAddress(
	                    "goyalarjun139@gmail.com", "Arjun Goel"))) 
	            .subject("Order of Cake")
	            .body(message)
	            .encoding("UTF-8").build();
	        emailService.send(email); 
	    }
	}


