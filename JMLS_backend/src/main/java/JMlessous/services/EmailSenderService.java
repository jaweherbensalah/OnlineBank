package JMlessous.services;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
@Autowired
private JavaMailSender mailSender;
public void send(String toEmail, 
		String subject, 
		String body) {
	SimpleMailMessage msg=new SimpleMailMessage();
	msg.setFrom("appmailing.jaweher@gmail.com");
	msg.setTo(toEmail);
	msg.setText(body);
	msg.setSubject(subject);
	
	mailSender.send(msg);
	System.out.println("email sent");
	
	
	
   
    
}
//*********************************************

public EmailSenderService(JavaMailSender mailSender) {
	super();
	this.mailSender = mailSender;
}

}
