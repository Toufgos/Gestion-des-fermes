package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import si.smart.ferme.metier.Metier;

public class mian {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		System.out.println("hhhhhhhhhhhhhhhhhhhh");
		JavaMailSender mailSender = (JavaMailSender) context.getBean("mailSender");
		
		String recipientAddress = "recipient";
        String subject = "subject";
        String message = "message";
         
        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
         
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
         
        // sends the e-mail
        //mailSender.send(email);
	}
	
	
	


}
