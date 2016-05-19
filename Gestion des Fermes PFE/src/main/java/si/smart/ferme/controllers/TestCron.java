package si.smart.ferme.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import si.smart.ferme.dao.Dao;
import si.smart.ferme.entities.Ferme;
import si.smart.ferme.metier.Metier;
import si.smart.ferme.metier.MetierImp;

@Component
public class TestCron {
	
	@Autowired
	private Metier metier;
	

	

	
	//-------------> s  m   hr      jr/semaine
	//@Scheduled(cron="40 30 10 * * MON-FRI")
	@Scheduled(cron="20 13 11 * * *")
	public synchronized void excute() {
		
		
		System.out.println("Msessge De L' Apart du Cron ");
		
		try {
			String crunchifyConfFile = "crunchify-bean.xml";
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
	 
			// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
			MailSender crunchifymail = (MailSender) context.getBean("mailSender");
			
			String toAddr = "toufga.brahim@gmail.com";
			String fromAddr = "projet.gestion.fermes@gmail.com";
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.FRANCE);
			String formatteDate = dateFormat.format(new Date());
			// email subject
			String subject = "Fermes n'ont pas encore de climatolgie pour la date de "+formatteDate;
	 
			// email body
			String body = "Voici la liste des fermes qui n'ont pas de  climatolgie pour la date de "+formatteDate+" -- Admin";
			
			//crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
			System.out.println("we are done bro ");
			List<Ferme> fermes= metier.FindFermeDoesNotRegistreClimat(new Date());
			for (Ferme f : fermes) {
				System.out.println("Msessge De L' Apart du Cron : "+f.getId_Ferme()+" "+ f.getNom_Ferme()+"  Not Yet ");
				body+="\n La ferme :  "+f.getId_Ferme()+" "+ f.getNom_Ferme()+"  Not Yet ";
			}
			SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
			crunchifyMsg.setFrom(fromAddr);
			crunchifyMsg.setTo(toAddr);
			crunchifyMsg.setSubject(subject);
			crunchifyMsg.setText(body);
			crunchifymail.send(crunchifyMsg);
			System.out.println("Cron à fini son travail pour ajourd'hui");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
