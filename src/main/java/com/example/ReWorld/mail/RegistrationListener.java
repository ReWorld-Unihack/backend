package com.example.ReWorld.mail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.ReWorld.constants.URLs;
import com.example.ReWorld.entities.User;
import com.example.ReWorld.security.services.IUserService;
import com.example.ReWorld.services.util.FileService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class RegistrationListener implements 
  ApplicationListener<OnRegistrationCompleteEvent> {
 
    @Autowired
    private IUserService service;
 
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private FileService fileService;
    
    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        try {
			this.confirmRegistration(event);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event)throws MessagingException, UnsupportedEncodingException {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user, token);

        String recipientAddress = user.getUsername();
        String subject = "Registration Confirmation";
        String confirmationUrl 
          = URLs.baseURL + "/registration-confirm?token=" + token+"&role="+event.getParams()[0];
        String message = "";
		try {
			message = fileService.readFile("/mail-confirm.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		MimeMessage messageMail = mailSender.createMimeMessage();
        MimeMessageHelper email = new MimeMessageHelper(messageMail);
        email.setFrom("contact@HiringGlobal.com", "App Hiring");
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message.replace("%1$s", confirmationUrl).replace("%2$s", token),true);
        mailSender.send(messageMail);
    }
}
