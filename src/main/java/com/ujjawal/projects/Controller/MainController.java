package com.ujjawal.projects.Controller;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ujjawal.projects.Controller.Dto.Details;
import com.ujjawal.projects.Services.SendEmails;

@Controller
@CrossOrigin
public class MainController {
	@Autowired
	SendEmails sendEmails;
	


	
	 @PostMapping("/postDetails")
	public ResponseEntity<Object> getDetailsAndSendEmail(@RequestBody Details details) throws UnsupportedEncodingException
	{
		sendEmails.SendEmail(details);
		HashMap<String,String> map=new HashMap<>();
		map.put("Email Status", "Successfully Send");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	   


	
	
}


