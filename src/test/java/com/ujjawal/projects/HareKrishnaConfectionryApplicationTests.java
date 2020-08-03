package com.ujjawal.projects;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;


@RunWith(SpringRunner.class)
@SpringBootTest
class HareKrishnaConfectionryApplicationTests {
    @Autowired 
    it.ozimov.springboot.mail.service.EmailService emailService; 

    @Value("${spring.mail.username}") String fromEmail; 
    @Test 
    public void testSendEmail() throws UnsupportedEncodingException { 
        
        final Email email = DefaultEmail.builder() 
            .from(new InternetAddress(fromEmail, "HareKrishnaConfectionary"))
            .to(Lists.newArrayList(new InternetAddress(
                    "ujjawal98kaushik@gmail.com", "Ujjawal Sharma"))) 
            .subject("Testing email")
            .body("Testing body ...")
            .encoding("UTF-8").build();
        emailService.send(email); 
    }
}
