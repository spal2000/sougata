//
//package com.sougata.employee.model;
//
//import java.io.File;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//	@Autowired
//	private JavaMailSender mailSender;
//
//	public void sendWelcomeEmail(User user) throws MessagingException {
//		MimeMessage message = mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//		helper.setSubject("Welcome to My App!");
//		helper.setTo("sougatapal2000&gmail.com");
//
//		String text = "<html><body>" + "<h3>Hi " + user.getName() + ",</h3>"
//				+ "<p>Welcome to My App! We're excited to have you on board.</p>" + "</body></html>";
//		helper.setText(text, true);
//
//		FileSystemResource image = new FileSystemResource(new File("path/to/my/image.png"));
//		helper.addInline("myImage", image);
//
//		mailSender.send(message);
//	}
//
//}
