package test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class CrunchifyEmailTest {
 
	@SuppressWarnings("resource")
	public static void main(String args[]) {
 
		// Spring Bean file you specified in /src/main/resources folder
		//String crunchifyConfFile = "crunchify-bean.xml";
		String crunchifyConfFile = "crunchify-bean.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
 
		// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
		CrunchifyEmailAPI crunchifyEmailAPI = (CrunchifyEmailAPI) context.getBean("crunchifyEmail");
		
		String toAddr = "toufga.brahim@gmail.com";
		String fromAddr = "projet.gestion.fermes@gmail.com";
 
		// email subject
		String subject = "Hey.. This email sent by Crunchify's Spring MVC Tutorial";
 
		// email body
		String body = "There you go.. You got an email.. Let's understand details on how Spring MVC works -- By Crunchify Admin";
		crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
		System.out.println("we are done bro ");
	}
}