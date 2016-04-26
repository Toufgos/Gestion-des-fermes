package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import si.smart.ferme.dao.Dao;
import si.smart.ferme.entities.Activite;
import si.smart.ferme.entities.Climatologie;
import si.smart.ferme.entities.Famille;
import si.smart.ferme.entities.Ferme;
import si.smart.ferme.entities.Groupe;
import si.smart.ferme.entities.ModeIrreguation;
import si.smart.ferme.entities.Occupation;
import si.smart.ferme.entities.Parcellaire;
import si.smart.ferme.entities.ParcellaireBour;
import si.smart.ferme.entities.ParcellaireIrregue;
import si.smart.ferme.entities.Personnel;
import si.smart.ferme.entities.SousFamille;
import si.smart.ferme.entities.Variete;
import si.smart.ferme.entitiesHistory.ClimatologieHistory;
import si.smart.ferme.entitiesHistory.FamilleHistory;
import si.smart.ferme.entitiesHistory.FermeHistory;
import si.smart.ferme.entitiesHistory.GroupeHistory;
import si.smart.ferme.entitiesHistory.ModeIrreguationHistory;
import si.smart.ferme.entitiesHistory.PersonnelHistory;
import si.smart.ferme.entitiesHistory.SousFamilleHistory;
import si.smart.ferme.entitiesHistory.VarieteHistory;
import si.smart.ferme.metier.Metier;

public class test {

	private static final Logger logger = LoggerFactory.getLogger(test.class);

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
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
		
		
		 
		 
/*		try {
			SousFamille s = m.findSousFamillebyId(7L);
			System.out.println(m.Remove(s));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Variete v = m.FindVarieteById(7L);
			System.out.println(m.Remove(v));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Ferme frm = m.FindFermeById(8L);
			System.out.println(m.Remove(frm));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Parcellaire p = m.findParcellaireById(9L);
			System.out.println(m.Remove(p));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		return;
		/*
		 * List<Parcellaire> parcelaires=m.GetParcesOfAFarm(f.getId_Ferme());
		 * 
		 * System.out.println(parcelaires.size());
		 * 
		 * for (Parcellaire p : parcelaires) { System.out.println(p); }
		 * 
		 * Parcellaire p= new Parcellaire("ChampsTest", 3325.0, 3300.0, 3300.0);
		 * if(a){ ModeIrreguation mode=new ModeIrreguation("Gout",
		 * "gout-à-gout"); ParcellaireIrregue pi= new
		 * ParcellaireIrregue(p,"parceUrregue",mode); pi.setFerme(f);
		 * parcelaires.add(pi);
		 * 
		 * }else{ ParcellaireBour pb= new ParcellaireBour(p); pb.setDescription(
		 * "Parcellaire Bour"); pb.setFerme(f); parcelaires.add(pb); }
		 */
		// p.setFerme(f);
		// f.setParces(p);

		// System.out.println(f.getId_Ferme());
		// m.UpdateParecellaireOfAFarm(parcelaires, f.getId_Ferme());

		// Gson gson= new Gson();
		// String s= gson.toJson(f);
		// System.out.println(s);

		// System.out.println("Ajout est terminé avec succées ! ");

		// Groupe grp2=new Groupe("groupe2");
		/*
		 * System.out.println("hhhhhhhhhhhhhhhhhhhh");
		 * 
		 * m.add(new Groupe("hello1")); m.add(new Groupe("hello2")); Personnel
		 * p= new Personnel("nom", "cin", "responsabilite"); Personnel p2=new
		 * Personnel("mohamed", "BB189182", "Gerant"); Personnel p3=new
		 * Personnel("mohamed", "BB189182", "Gerant"); Personnel p4=new
		 * Personnel("hmiida", "BB1182", "techni"); Personnel p5=new
		 * Personnel("Morad", "BB189182", "ingénieur"); Personnel p6=new
		 * Personnel("Anwar", "BB189182", "jardinier"); Ferme f= new
		 * Ferme("nom_Ferme1", "adresse1", "proprietaire_ferme", "ville_ferme",
		 * 5000.09); Ferme f2= new Ferme("nom_Ferme2", "adresse3",
		 * "proprietaire_ferme", "ville_ferme", 5000.09);
		 * 
		 * 
		 * f.setGerant(p); grp.setFerme(f); grp.setFerme(f2);
		 * f.setpersonnels(p); f.setGroupe(grp); f.setPolygoneMaps_ferme(new
		 * CoordonnesGPS(19.10289303, 1.129382928)); f.setPolygoneMaps_ferme(new
		 * CoordonnesGPS(29.10289303, 12.1921928)); f.setPolygoneMaps_ferme(new
		 * CoordonnesGPS(39.10289303, 1.1921928)); f2.setGerant(p2);
		 * 
		 * f2.setpersonnels(p2); f2.setpersonnels(p4); f2.setpersonnels(p5);
		 * f2.setpersonnels(p6); f2.setGroupe(grp); f2.setPolygoneMaps_ferme(new
		 * CoordonnesGPS(19.10289303, 1.129382928));
		 * f2.setPolygoneMaps_ferme(new CoordonnesGPS(29.10289303, 12.1921928));
		 * f2.setPolygoneMaps_ferme(new CoordonnesGPS(39.10289303, 1.1921928));
		 * 
		 * m.add(p);
		 * 
		 * Parcellaire p1=new Parcellaire("libelle_p1", 100.01, 0.1, 99);
		 * p1.setFerme(f); p1.setPolygoneMaps_parce(new
		 * CoordonnesGPS(19.10289303, 1.129382928));
		 * p1.setPolygoneMaps_parce(new CoordonnesGPS(29.10289303, 12.1921928));
		 * p1.setPolygoneMaps_parce(new CoordonnesGPS(39.10289303, 1.1921928));
		 * Parcellaire pr2=new Parcellaire("libelle_p2", 100.01, 0.1, 99);
		 * pr2.setFerme(f2); pr2.setPolygoneMaps_parce(new
		 * CoordonnesGPS(19.10289303, 1.129382928));
		 * pr2.setPolygoneMaps_parce(new CoordonnesGPS(29.10289303,
		 * 12.1921928)); pr2.setPolygoneMaps_parce(new
		 * CoordonnesGPS(39.10289303, 1.1921928)); f.setParces(p1);
		 * f2.setParces(pr2); m.add(f); m.add(f2); //m.update(grp);
		 */
	}

}
