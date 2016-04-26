package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import si.smart.ferme.dao.Dao;
import si.smart.ferme.entities.Ferme;
import si.smart.ferme.metier.Metier;

public class All {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "DaoAndMetierBeans.xml" });
		System.out.println("hhhhhhhhhhhhhhhhhhhh");
		Metier m = (Metier) context.getBean("metier");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.FRANCE);
		String formatteDate = dateFormat.format(new Date());
		System.out.println(formatteDate);
		
		try {
			List<Ferme> fermes= m.FindFermeDoesNotRegistreClimat(new Date());
			for (Ferme f : fermes) {
				System.out.println(f.getId_Ferme()+" "+ f.getNom_Ferme()+"  pas encore ");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
