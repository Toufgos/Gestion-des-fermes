package si.smart.ferme.metier;

import java.text.ParseException;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import si.smart.ferme.dao.Dao;
import si.smart.ferme.dao.DaoImp;
import si.smart.ferme.entities.Activite;
import si.smart.ferme.entities.CategorieProduit;
import si.smart.ferme.entities.Climatologie;
import si.smart.ferme.entities.CoordonnesGPS;
import si.smart.ferme.entities.Famille;
import si.smart.ferme.entities.Ferme;
import si.smart.ferme.entities.Fournisseur;
import si.smart.ferme.entities.Groupe;
import si.smart.ferme.entities.LigneMouvementProduit;
import si.smart.ferme.entities.ModeIrreguation;
import si.smart.ferme.entities.Mouvement;
import si.smart.ferme.entities.Occupation;
import si.smart.ferme.entities.Parcellaire;
import si.smart.ferme.entities.Personnel;
import si.smart.ferme.entities.Produit;
import si.smart.ferme.entities.SousFamille;
import si.smart.ferme.entities.Traitement;
import si.smart.ferme.entities.Variete;
import si.smart.ferme.entitiesHistory.ActiviteHistory;
import si.smart.ferme.entitiesHistory.ClimatologieHistory;
import si.smart.ferme.entitiesHistory.FamilleHistory;
import si.smart.ferme.entitiesHistory.FermeHistory;
import si.smart.ferme.entitiesHistory.GroupeHistory;
import si.smart.ferme.entitiesHistory.ModeIrreguationHistory;
import si.smart.ferme.entitiesHistory.OccupationHistory;
import si.smart.ferme.entitiesHistory.ParcellaireHistory;
import si.smart.ferme.entitiesHistory.PersonnelHistory;
import si.smart.ferme.entitiesHistory.SousFamilleHistory;
import si.smart.ferme.entitiesHistory.VarieteHistory;


@Repository
@Transactional
public class MetierImp implements Metier{
	
	
	private Dao dao;
	
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public MetierImp() {
		// TODO Auto-generated constructor stub
	}
	
	public MetierImp(Dao dao) {
		//System.out.println("metier is just created");
		this.dao= dao;
	
	}
	
	@Override
	public Groupe add(Groupe g) {
	
		return dao.add(g);
	}

	@Override
	public Personnel add(Personnel g) {
	
		return dao.add(g);
	}

	@Override
	public Ferme add(Ferme g) {
	
		return dao.add(g);
	}

	@Override
	public CoordonnesGPS add(CoordonnesGPS c) {
	
		return dao.add(c);
	}

	@Override
	public Groupe update(Groupe g) {
	
		return dao.update(g);
	}

	@Override
	public Personnel update(Personnel g) {
	
		return dao.update(g);
	}

	@Override
	public Ferme update(Ferme g) {
	
		return dao.update(g);
	}

	@Override
	public CoordonnesGPS update(CoordonnesGPS c) {
	
		return dao.update(c);
	}

	@Override
	public Groupe FindGroupeById(long a) {
	
		return dao.FindGroupeById(a);
	}

	@Override
	public Personnel FindPersonnelById(long a) {
	
		return dao.FindPersonnelById(a);
	}

	@Override
	public Ferme FindFermeById(long a) {
	
		return dao.FindFermeById(a);
	}

	@Override
	public CoordonnesGPS FindCoordonnesGPSById(long a) {
	
		return dao.FindCoordonnesGPSById(a);
	}

	@Override
	public List<Groupe> FindAllGroupe() {
	
		return dao.FindAllGroupe();
	}

	@Override
	public List<Personnel> FindAllPersonnel() {
	
		return dao.FindAllPersonnel();
	}

	@Override
	public List<Ferme> FindAllFerme() {
	
		return dao.FindAllFerme();
	}

	@Override
	public List<CoordonnesGPS> FindAllCoordonnesGPS() {
	
		return dao.FindAllCoordonnesGPS();
	}


	@Override
	public List<Parcellaire> GetParcesOfAFarm(long id) {
	
		return dao.GetParcesOfAFarm(id);
	}


	@Override
	public void UpdateParecellaireOfAFarm(List<Parcellaire> parcellaires, long id_ferme) {
	
		dao.UpdateParecellaireOfAFarm(parcellaires, id_ferme);
	}


	@Override
	public List<ModeIrreguation> findAllModeIrrigation() {
	
		return dao.findAllModeIrrigation();
	}


	@Override
	public ModeIrreguation findModeIrrigationById(long a) {
	
		return dao.findModeIrrigationById(a);
	}


	@Override
	public List<Ferme> FermesByGroupe(long id) {
	
		return dao.FermesByGroupe(id);
	}


	@Override
	public Ferme add(Ferme f, Groupe g) {
	
		return dao.add(f, g);
	}


	@Override
	public List<CoordonnesGPS> FindAllCoordonnesGPSByferme(long a) {
	
		return dao.FindAllCoordonnesGPSByferme(a);
	}


	@Override
	public boolean add(long f, List<CoordonnesGPS> l) {
	
		return dao.add(f, l);
	}


	@Override
	public Famille add(Famille g) {
	
		return dao.add(g);
	}


	@Override
	public Activite add(Activite g) {
	
		return dao.add(g);
	}


	@Override
	public Famille update(Famille f) {
	
		return dao.update(f);
	}


	@Override
	public Activite update(Activite a) {
	
		return dao.update(a);
	}


	@Override
	public Famille FindFamilleById(long a) {
	
		return dao.FindFamilleById(a);
	}


	@Override
	public Activite FindActiviteById(long a) {
	
		return dao.FindActiviteById(a);
	}


	@Override
	public SousFamille add(SousFamille s) {
	
		return dao.add(s);
	}


	@Override
	public SousFamille add(SousFamille s, Famille f) {
	
		return dao.add(s, f);
	}


	@Override
	public List<Famille> FindALLFamilles() {
	
		return dao.FindALLFamilles();
	}


	@Override
	public List<SousFamille> FindALLSousFamilles(long a) {
	
		return dao.FindALLSousFamilles(a);
	}


	@Override
	public Variete add(Variete v) {
	
		return dao.add(v);
	}


	@Override
	public Variete add(Variete v, SousFamille s) {
	
		return dao.add(v, s);
	}


	@Override
	public List<Variete> FindVarietesBySousFamille(SousFamille s) {
	
		return dao.FindVarietesBySousFamille(s);
	}


	@Override
	public List<Variete> FindVarietesBySousFamille(long a) {
	
		return dao.FindVarietesBySousFamille(a);
	}


	@Override
	public Variete FindVarieteById(long a) {
	
		return dao.FindVarieteById(a);
	}


	@Override
	public boolean add(Parcellaire p, List<CoordonnesGPS> l) {
	
		return dao.add(p, l);
	}


	@Override
	public List<CoordonnesGPS> FindAllCoordonnesGPSByParcelle(long a) {
	
		return dao.FindAllCoordonnesGPSByParcelle(a);
	}


	@Override
	public Parcellaire findParcellaireById(long a) {
	
		return dao.findParcellaireById(a);
	}


	@Override
	public Occupation add(Occupation o) {
	
		return dao.add(o);
	}


	@Override
	public Occupation add(Parcellaire p, Occupation o) {
	
		return dao.add(p, o);
	}


	@Override
	public List<Occupation> findAllOccupations() {
	
		return dao.findAllOccupations();
	}


	@Override
	public Occupation findOccupationById(long a) {
	
		return dao.findOccupationById(a);
	}


	@Override
	public List<Activite> FindAllActivities() {
	
		return dao.FindAllActivities();
	}


	@Override
	public SousFamille findSousFamillebyId(long a) {
	
		return dao.findSousFamillebyId(a);
	}


	@Override
	public List<SousFamille> FindAllSousFamilles() {
	
		return dao.FindAllSousFamilles();
	}


	@Override
	public Famille add(Famille f, Activite a) {
	
		return dao.add(f , a);
	}


	@Override
	public List<Variete> findAllVarietes() {
	
		return dao.findAllVarietes();
	}


	@Override
	public List<Parcellaire> findAllParcelles() {
	
		return dao.findAllParcelles();
	}


	@Override
	public void update(ModeIrreguation m) {
	
		dao.update(m);
	}


	@Override
	public void update(SousFamille s) {
	
		dao.update(s);
	}


	@Override
	public void update(Variete v) {
	
		dao.update(v);
	}


	@Override
	public String Remove(Activite a) {
	
		return dao.Remove(a);
	}


	@Override
	public String Remove(Groupe g) {
	
		return dao.Remove(g);
	}


	@Override
	public String Remove(Famille f) {
	
		return dao.Remove(f);
	}


	@Override
	public String Remove(SousFamille s) {
	
		return dao.Remove(s);
	}


	@Override
	public String Remove(Variete v) {
	
		return dao.Remove(v);
	}


	@Override
	public String Remove(Ferme f) {
	
		return dao.Remove(f);
	}


	@Override
	public String Remove(Parcellaire p) {
	
		return dao.Remove(p);
	}


	@Override
	public ModeIrreguation add(ModeIrreguation mode) {
	
		return dao.add(mode);
	}


	@Override
	public Occupation findOccupationByParcelle(long id) {
	
		return dao.findOccupationByParcelle(id);
	}


	@Override
	public Climatologie add(Climatologie c) {
	
		return dao.add(c);
	}


	@Override
	public Climatologie add(Climatologie c, Ferme f) {
	
		return dao.add(c, f);
	}


	@Override
	public Climatologie update(Climatologie c) {
	
		return dao.update(c);
	}


	@Override
	public Climatologie remove(Climatologie c) {
	
		return dao.remove(c);
	}


	@Override
	public List<Climatologie> findAllClimatologies() {
	
		return dao.findAllClimatologies();
	}


	@Override
	public List<Climatologie> FindClimatologiesByFerme(Ferme f) {
	
		return dao.FindClimatologiesByFerme(f);
	}


	@Override
	public Climatologie FindClimatologieById(long a) {
	
		return dao.FindClimatologieById(a);
	}


	@Override
	public void update(Occupation o) {
		
		 dao.update(o);
		
	}


	@Override
	public void update(Parcellaire p) {
		
		dao.update(p);
	}


	@Override
	public void Add(ActiviteHistory a) {
		
		dao.add(a);
		
	}


	@Override
	public void add(ActiviteHistory a) {
		dao.add(a);
		
	}


	@Override
	public void add(ClimatologieHistory a) {
		dao.add(a);
		
	}


	@Override
	public void add(FamilleHistory a) {
		dao.add(a);
		
	}


	@Override
	public void add(FermeHistory a) {
		dao.add(a);
		
	}


	@Override
	public void add(GroupeHistory a) {
		dao.add(a);
		
	}


	@Override
	public void add(ModeIrreguationHistory a) {
		dao.add(a);
		
	}


	@Override
	public void add(OccupationHistory a) {
		dao.add(a);
		
	}


	@Override
	public void add(ParcellaireHistory a) {
		dao.add(a);
		
	}


	@Override
	public void add(PersonnelHistory a) {
		dao.add(a);
		
	}


	@Override
	public void add(SousFamilleHistory a) {
		dao.add(a);
		
	}


	@Override
	public void add(VarieteHistory a) {
		dao.add(a);
		
	}


	@Override
	public void setParcellaireActivation(Parcellaire p, boolean a) {
		
		dao.setParcellaireActivation(p, a);
		
	}


	@Override
	public void convertParcelleToBour(Parcellaire p) {
		dao.convertParcelleToBour(p);
		
	}


	@Override
	public void convertParcelleToIrregue(Parcellaire p) {
		
		dao.convertParcelleToIrregue(p);
	}


	@Override
	public Occupation addSecondOccupation(Parcellaire p, Occupation o) {
		
		return dao.addSecondOccupation(p, o);
	}


	@Override
	public List<Ferme> FindFermeDoesNotRegistreClimat(Date date) throws ParseException {
	
		return dao.FindFermeDoesNotRegistreClimat(date);
	}

	@Override
	public CategorieProduit add(CategorieProduit c) {
		
		return dao.add(c);
	}

	@Override
	public List<CategorieProduit> FindAllCategorieProduit() {
		
		return dao.FindAllCategorieProduit();
	}

	@Override
	public CategorieProduit FindCategorieProduitById(long id) {
		
		return dao.FindCategorieProduitById(id);
	}

	@Override
	public CategorieProduit update(CategorieProduit c) {
		
		return dao.update(c);
	}

	@Override
	public String Remove(CategorieProduit c) {
		
		return dao.Remove(c);
	}

	@Override
	public Produit add(Produit p) {
		
		return dao.add(p);
	}

	@Override
	public Produit add(Produit p, CategorieProduit c) {
		
		return dao.add(p, c);
	}

	@Override
	public List<Produit> FindAllProduit() {
		
		return dao.FindAllProduit();
	}

	@Override
	public Produit FindProduitById(long id) {
		
		return dao.FindProduitById(id);
	}

	@Override
	public Produit update(Produit p, CategorieProduit c) {
		
		return dao.update(p, c);
	}

	@Override
	public String Remove(Produit p) {
		
		return dao.Remove(p);
	}

	@Override
	public Fournisseur add(Fournisseur f) {
		//
		return dao.add(f);
	}

	@Override
	public List<Fournisseur> FindAllFournisseur() {
		
		return dao.FindAllFournisseur();
	}

	@Override
	public Fournisseur FindFournisseurById(long id) {
		
		return dao.FindFournisseurById(id);
	}

	@Override
	public Fournisseur update(Fournisseur f) {
		
		return dao.update(f);
	}

	@Override
	public String Remove(Fournisseur f) {
		
		return dao.Remove(f);
	}

	@Override
	public Traitement add(Traitement t, Produit p, Parcellaire pr) {
		// 
		return dao.add(t, p, pr);
	}

	@Override
	public List<Traitement> FindAllTraitement() {
		// 
		return dao.FindAllTraitement();
	}

	@Override
	public Traitement FindTraitementById(long id) {
		// 
		return dao.FindTraitementById(id);
	}

	@Override
	public Traitement update(Traitement t, Produit p, Parcellaire pr) {
		// 
		return dao.update(t, p, pr);
	}

	@Override
	public String Remove(Traitement t) {
		// 
		return dao.Remove(t);
	}

	@Override
	public Mouvement add(Mouvement m, Ferme f) {
		// 
		return dao.add(m, f);
	}

	@Override
	public List<Mouvement> FindAllMouvement() {
		
		return dao.FindAllMouvement();
	}

	@Override
	public Mouvement FindMouvementById(long id) {
		// 
		return dao.FindMouvementById(id);
	}

	@Override
	public Mouvement update(Mouvement m, Ferme f) {
		// 
		return dao.update(m, f);
	}

	@Override
	public String Remove(Mouvement f) {
		// 
		return dao.Remove(f);
	}	
	
	@Override
	public List<Fournisseur> FindAllFournisseurSeulement() {
		
		return dao.FindAllFournisseurSeulement();
	}

	@Override
	public List<Fournisseur> FindAllFournisseurClientSeulement() {
		
		return dao.FindAllFournisseurClientSeulement();
	}

	@Override
	public List<Mouvement> FindAllMouvementEntrees() {
		// 
		return dao.FindAllMouvementEntrees();
	}

	@Override
	public List<Mouvement> FindAllMouvementSorties() {
		// 
		return dao.FindAllMouvementSorties();
	}

	@Override
	public List<Mouvement> FindAllMouvementDepreciation() {
		
		return dao.FindAllMouvementDepreciation();
	}

	@Override
	public LigneMouvementProduit add(LigneMouvementProduit l, Mouvement m, Produit p) {
		
		System.out.println("Metier : "+l.getMontant()+"  "+m.getReference()+"    "+p.getLibelle());
		return dao.add(l, m, p);
	}

	@Override
	public List<LigneMouvementProduit> FindAllLigneMouvementProduit() {
		// 
		return dao.FindAllLigneMouvementProduit();
	}

	@Override
	public List<LigneMouvementProduit> FindAllLigneMouvementProduitByProduit(Produit p) {
		// 
		return dao.FindAllLigneMouvementProduitByProduit(p);
	}

	@Override
	public List<LigneMouvementProduit> FindAllLigneMouvementProduitByProduit(long p) {
		// 
		return dao.FindAllLigneMouvementProduitByProduit(p);
	}

	@Override
	public List<LigneMouvementProduit> FindAllLigneMouvementProduitByMouvement(Mouvement m) {
		// 
		return dao.FindAllLigneMouvementProduitByMouvement(m);
	}

	@Override
	public List<LigneMouvementProduit> FindAllLigneMouvementProduitByMouvement(long m) {
		// 
		return dao.FindAllLigneMouvementProduitByMouvement(m);
	}
	

//	public void setDao(Dao dao) {
//		this.dao = dao;
//	}
//
//	@Override
//	public Employe addEmplye(Employe e) {
//		dao.addEmplye(e);
//		return e;
//	}
//
//	@Override
//	public Employe update(Employe e) {
//		return dao.update(e);
//	}
//
//	@Override
//	public Employe findEmloye(Employe e) {
//		return dao.findEmloye(e);
//	}
//
//	@Override
//	public List<Employe> getAllEmployes(boolean conge) {
//		return dao.getAllEmployes(conge);
//	}
//
//	@Override
//	public List<Employe> findEmployes(String id) {
//		
//		return dao.findEmployes(id);
//	}
//	
//	@Override
//	public List<Employe> getEmployesByDepartement(boolean conge, Departement departement) {
//		return dao.getEmployesByDepartement(conge, departement);
//	}
//	
//	@Override
//	public Absence addAbsence(Employe e, Absence a) {
//		dao.addGestionPresence(a, e);
//		return a;
//	}
//
//	@Override
//	public Retard addRetard(Employe e, Retard r) {
//		dao.addGestionPresence(r, e);
//		return r;
//	}
//
//	@Override
//	public HeursSuplementaire addHeursSuplementaire(Employe e, HeursSuplementaire hs) {
//		dao.addGestionPresence(hs, e);
//		return hs;
//	}
//
//	@Override
//	public JoursFeries addJoursFeries(Employe e, JoursFeries jf) {
//		dao.addGestionPresence(jf, e);
//		return jf;
//	}
//	
//	@Override
//	public Admin addAdmin(Admin a) {
//		return dao.addAdmin(a);
//	}
//
//	@Override
//	public Admin updateAdmin(Admin a) {
//		return dao.updateAdmin(a);
//	}
//
//	@Override
//	public Departement addDepartement(Departement d) {
//		dao.addDepartement(d);
//		return null;
//	}
//
//	@Override
//	public Departement updateDepartement(Departement d) {
//		dao.updateDepartement(d);
//		return null;
//	}
//
//	@Override
//	public List<gestion_presence> getAbsence(Employe e, Date date) {
//		return dao.getGestionPresence(e, date, "A");
//	}
//
//	@Override
//	public List<gestion_presence> getRetard(Employe e, Date date) {
//		return dao.getGestionPresence(e, date, "R");
//	}
//
//	@Override
//	public List<gestion_presence> getHeureSuplementaire(Employe e, Date date) {
//		return dao.getGestionPresence(e, date, "HS");
//	}
//
//	@Override
//	public List<gestion_presence> getJoursFeries(Employe e, Date date) {
//		return dao.getGestionPresence(e, date, "JF");
//	}
//
//	@Override
//	public Admin logIn(Admin a) {
//		return dao.logIn(a);
//		
//	}
//
//	@Override
//	public BulletinPaie getInfoSalaire(Employe e, Date date, boolean normal) {
//		
//		return dao.getInfoSalaire(e, date, normal);
//	}
//
//	@Override
//	public void bloquerEmploye(Employe e) {
//		dao.bloquerEmploye(e);		
//	}
//
//	@Override
//	public void debloquerEmploye(Employe e) {
//		dao.debloquerEmploye(e);		
//	}
//
//	@Override
//	public List<Employe> getAllAmployes() {
//		return dao.getAllEmployes();
//	}
//
//	@Override
//	public Departement findDepartement(Departement d) {
//		return dao.findDepartement(d);
//	}
//
//	@Override
//	public List<Departement> findDepartements(String id) {
//		return dao.findDepartements(id);
//	}
//
//	@Override
//	public List<Departement> getAllDepartements() {
//		return dao.getAllDepartements();
//	}
//
//	@Override
//	public Entreprise addEntreprise(Entreprise e) {
//		return dao.addEntreprise(e);
//	}
//
//	@Override
//	public Entreprise updateEntreprise(Entreprise e) {
//		return dao.updateEntreprise(e);
//	}
//	
//	@Override
//	public Entreprise findEntreprise(Entreprise e){
//		return dao.findEntreprise(e);
//	}
//

	
}
