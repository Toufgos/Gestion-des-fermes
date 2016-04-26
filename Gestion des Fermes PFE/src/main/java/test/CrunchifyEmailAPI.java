package test;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
 
/**
 * @author Crunchify.com
 * 
 */
 
@Service("crunchifyEmail")
public class CrunchifyEmailAPI {
 
	//@Autowired
	private  MailSender crunchifymail; // MailSender interface defines a strategy
										// for sending simple mails
 
	public MailSender getCrunchifymail() {
		return crunchifymail;
	}
	public void setCrunchifymail(MailSender crunchifymail) {
		this.crunchifymail = crunchifymail;
	}
	public  void crunchifyReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
 
		SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
		crunchifyMsg.setFrom(fromAddress);
		crunchifyMsg.setTo(toAddress);
		crunchifyMsg.setSubject(subject);
		crunchifyMsg.setText(msgBody);
		crunchifymail.send(crunchifyMsg);
	}
	public static void main(String args[]) {
		 
		// Spring Bean file you specified in /src/main/resources folder
		//String crunchifyConfFile = "crunchify-bean.xml";
		String crunchifyConfFile = "crunchify-bean.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
 
		// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
		MailSender crunchifymail = (MailSender) context.getBean("mailSender");
		
		String toAddr = "toufga.brahim@gmail.com";
		String fromAddr = "projet.gestion.fermes@gmail.com";
 
		// email subject
		String subject = "Gestion Des Fermes, Test Mailing";
 
		// email body
		String body = "Bonjour cet email est just pour tester l integration de Mail dependencies to the new Project";
		SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
		crunchifyMsg.setFrom(fromAddr);
		crunchifyMsg.setTo(toAddr);
		crunchifyMsg.setSubject(subject);
		crunchifyMsg.setText(body);
		crunchifymail.send(crunchifyMsg);
		//crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
		System.out.println("we are done bro ");
	}
}