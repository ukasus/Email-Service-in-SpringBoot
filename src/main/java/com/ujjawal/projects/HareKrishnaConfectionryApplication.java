package com.ujjawal.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;

@SpringBootApplication
@EnableEmailTools
public class HareKrishnaConfectionryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HareKrishnaConfectionryApplication.class, args);
	}

}

