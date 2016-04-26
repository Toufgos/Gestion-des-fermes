package si.smart.ferme.entitiesListner;

import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import si.smart.ferme.entities.Activite;
import si.smart.ferme.entities.Climatologie;
import si.smart.ferme.entities.Famille;
import si.smart.ferme.entities.Ferme;
import si.smart.ferme.entities.Groupe;
import si.smart.ferme.entities.ModeIrreguation;
import si.smart.ferme.entities.Parcellaire;
import si.smart.ferme.entities.ParcellaireBour;
import si.smart.ferme.entities.ParcellaireIrregue;
import si.smart.ferme.entities.SousFamille;
import si.smart.ferme.entities.Variete;
import si.smart.ferme.entitiesHistory.ActiviteHistory;
import si.smart.ferme.entitiesHistory.ClimatologieHistory;
import si.smart.ferme.entitiesHistory.FamilleHistory;
import si.smart.ferme.entitiesHistory.FermeHistory;
import si.smart.ferme.entitiesHistory.GroupeHistory;
import si.smart.ferme.entitiesHistory.ModeIrreguationHistory;
import si.smart.ferme.entitiesHistory.ParcellaireHistory;
import si.smart.ferme.entitiesHistory.ParcellaireHistoryBour;
import si.smart.ferme.entitiesHistory.ParcellaireHistoryIrregue;
import si.smart.ferme.entitiesHistory.SousFamilleHistory;
import si.smart.ferme.entitiesHistory.VarieteHistory;
import si.smart.ferme.metier.Metier;

public class PreUpdateListner {
	
	
	
	@PreUpdate
	public void ActivitePreupdate(Object ac) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		
		Metier metier = (Metier) context.getBean("metier");
//		System.out.println("metier is not null ");
		if(metier == null)
			System.out.println("sorry metier bean ");
		if(ac.getClass().isAssignableFrom(Activite.class)){
		
			Activite a= metier.FindActiviteById(((Activite)ac).getId());
			
			ActiviteHistory ah= new ActiviteHistory(a.getLibelle(), a.getObservation());
			System.out.println("Listening Activite Pre Update : " + a.getLibelle());
			metier.Add(ah);
		}
		if(ac.getClass().isAssignableFrom(ModeIrreguation.class)){
			
			ModeIrreguation m= metier.findModeIrrigationById(((ModeIrreguation)ac).getId_mode());
			System.out.println("Listening Activite Pre Update : " + m.getNom_mode());
			metier.add(new ModeIrreguationHistory(m));
			System.out.println("updated");
		}
		
		if(ac.getClass().isAssignableFrom(Climatologie.class)){
			
			Climatologie m= metier.FindClimatologieById(((Climatologie)ac).getId());
			System.out.println("Listening Activite Pre Update : " + m.getDate()+m.getFerme().getNom_Ferme());
			metier.add(new ClimatologieHistory(m));
			System.out.println("updated");
		}
		if(ac.getClass().isAssignableFrom(Famille.class)){
			
			Famille m= metier.FindFamilleById(((Famille)ac).getId());
			System.out.println("Listening Activite Pre Update : " + m.getLibelle());
			metier.add(new FamilleHistory(m));
			System.out.println("updated");
		}
		if(ac.getClass().isAssignableFrom(Ferme.class)){
			
			Ferme m= metier.FindFermeById(((Ferme)ac).getId_Ferme());
			System.out.println("Listening Activite Pre Update : " + m.getNom_Ferme());
			metier.add(new FermeHistory(m));
			System.out.println("updated");
		}
		if(ac.getClass().isAssignableFrom(Groupe.class)){
			
			Groupe m= metier.FindGroupeById(((Groupe)ac).getId());
			System.out.println("Listening Activite Pre Update : " + m.getNom());
			metier.add(new GroupeHistory(m));
			System.out.println("updated");
		}
		if(ac.getClass().isAssignableFrom(SousFamille.class)){
			
			SousFamille m= metier.findSousFamillebyId(((SousFamille)ac).getId());
			System.out.println("Listening Activite Pre Update : " + m.getLibelle());
			metier.add(new SousFamilleHistory(m));
			System.out.println("updated");
		}
		if(ac.getClass().isAssignableFrom(Variete.class)){
			
			Variete m= metier.FindVarieteById(((Variete)ac).getId());
			System.out.println("Listening Activite Pre Update : " + m.getNom());
			metier.add(new VarieteHistory(m));
			System.out.println("updated");
		}
		if(ac.getClass().isAssignableFrom(Parcellaire.class) || ac.getClass().isAssignableFrom(ParcellaireBour.class) || ac.getClass().isAssignableFrom(ParcellaireIrregue.class) ){
			
			System.out.println("I am in the parcellaire block");
			Parcellaire m= metier.findParcellaireById(((Parcellaire)ac).getId_parce());
			System.out.println("Listening Activite Pre Update : " + m.getLibelle());
			if(ac.getClass().isAssignableFrom(ParcellaireBour.class))
				metier.add(new ParcellaireHistoryBour(new ParcellaireHistory(m)));
			if(ac.getClass().isAssignableFrom(ParcellaireIrregue.class))
				metier.add(new ParcellaireHistoryIrregue(new ParcellaireHistory(m),((ParcellaireIrregue) ac).getDescription(), ((ParcellaireIrregue) ac).getMode().getId_mode()));
			else
			metier.add(new ParcellaireHistory(m));
				
			System.out.println("updated");
		}
	}
	
	
	
	
	@PostUpdate
	public void userPostUpdate(Object a) {
		System.out.println("Listening Post Update : " + a.getClass());
	}
}
