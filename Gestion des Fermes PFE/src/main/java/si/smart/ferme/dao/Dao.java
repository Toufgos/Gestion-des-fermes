package si.smart.ferme.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

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

public interface Dao {
	
	public Groupe add(Groupe g);
	public Personnel add(Personnel g);
	public Ferme add(Ferme g);
	public Famille add(Famille g);
	public Activite add(Activite g);
	public CoordonnesGPS add(CoordonnesGPS c);
	public SousFamille add(SousFamille s);
	public SousFamille add(SousFamille s, Famille f);
	public List<Famille> FindALLFamilles();
	public List<SousFamille> FindALLSousFamilles(long a);
	public Variete add(Variete v);
	public Variete add(Variete v, SousFamille s);
	public List<Variete> FindVarietesBySousFamille(SousFamille s);
	public List<Variete> FindVarietesBySousFamille(long a);
	public Variete FindVarieteById(long a);
	public List<Activite> FindAllActivities();
	public List<SousFamille> FindAllSousFamilles();
	public SousFamille findSousFamillebyId(long a);
	public Famille add(Famille f, Activite a);
	public List<Variete> findAllVarietes();
	public List<Parcellaire> findAllParcelles();
 	public ModeIrreguation add(ModeIrreguation mode);
 	public Occupation findOccupationByParcelle(long id);
 	public Climatologie add(Climatologie c);
 	public Climatologie add(Climatologie c, Ferme f);
 	public Climatologie update(Climatologie c);
 	public Climatologie remove(Climatologie c);
 	public List<Climatologie> findAllClimatologies();
 	public List<Climatologie> FindClimatologiesByFerme(Ferme f);
 	public Climatologie FindClimatologieById(long a);
 	
 	
 	public CategorieProduit add(CategorieProduit c);
 	public List<CategorieProduit> FindAllCategorieProduit();
 	public CategorieProduit FindCategorieProduitById(long id);
 	public CategorieProduit update(CategorieProduit c);
 	public String Remove(CategorieProduit c);
 	
 	
 	public Produit add(Produit p);
 	public Produit add(Produit p, CategorieProduit c);
 	public List<Produit> FindAllProduit();
 	public Produit FindProduitById(long id);
 	public Produit update(Produit p, CategorieProduit c);
 	public String Remove(Produit p);
 	
 	
 	
 	public Fournisseur add(Fournisseur f);
 	public List<Fournisseur> FindAllFournisseur();
 	public List<Fournisseur> FindAllFournisseurSeulement();
 	public List<Fournisseur> FindAllFournisseurClientSeulement();
 	public Fournisseur FindFournisseurById(long id);
 	public Fournisseur update(Fournisseur f);
 	public String Remove(Fournisseur f);
 	
 	
 	public Traitement add(Traitement t,Produit p, Parcellaire pr);
 	public List<Traitement> FindAllTraitement();
 	public Traitement FindTraitementById(long id);
 	public Traitement update(Traitement t,Produit p, Parcellaire pr);
 	public String Remove(Traitement t);
 	
 	
 	
 	public Mouvement add(Mouvement m, Ferme f);
 	public List<Mouvement> FindAllMouvement();
 	public List<Mouvement> FindAllMouvementEntrees();
 	public List<Mouvement> FindAllMouvementSorties();
 	public List<Mouvement> FindAllMouvementDepreciation();
 	public Mouvement FindMouvementById(long id);
 	public Mouvement update(Mouvement m, Ferme f);
 	public String Remove(Mouvement f);
 	
 	
 	public LigneMouvementProduit add(LigneMouvementProduit l, Mouvement m, Produit p);
 	public List<LigneMouvementProduit> FindAllLigneMouvementProduit();
 	public List<LigneMouvementProduit> FindAllLigneMouvementProduitByProduit(Produit p);
 	public List<LigneMouvementProduit> FindAllLigneMouvementProduitByProduit(long  p);
 	public List<LigneMouvementProduit> FindAllLigneMouvementProduitByMouvement(Mouvement m);
 	public List<LigneMouvementProduit> FindAllLigneMouvementProduitByMouvement(long  m);
 	public List<LigneMouvementProduit> FindAllLigneMouvementProduitEntrees();
 	public List<LigneMouvementProduit> FindAllLigneMouvementProduitSorties();
 	public List<LigneMouvementProduit> FindAllLigneMouvementProduitDepreciation();
 	public LigneMouvementProduit FindLigneMouvementProduitById(long id);
 	public LigneMouvementProduit update(LigneMouvementProduit l, Mouvement m, Produit p);
 	public String Remove(LigneMouvementProduit f);
 	
	public Groupe update(Groupe g);
	public Personnel update(Personnel g);
	public Ferme update(Ferme g);
	public CoordonnesGPS update(CoordonnesGPS c);
	public Famille update( Famille f);
	public Activite update( Activite a);
	public void update(ModeIrreguation m);
	public void update(SousFamille s);
	public void update(Variete v);
	public void update( Occupation o);
	public void update( Parcellaire p);
	
	public Groupe FindGroupeById(long a);
	public Personnel FindPersonnelById(long a );
	public Ferme FindFermeById(long a);
	public CoordonnesGPS FindCoordonnesGPSById(long a);
	public Famille FindFamilleById(long a);
	public Activite FindActiviteById(long a);
	
	
	
	public List<Groupe> FindAllGroupe ();
	public List<Personnel> FindAllPersonnel ( );
	public List<Ferme> FindAllFerme();
	public List<CoordonnesGPS> FindAllCoordonnesGPS();
	public List<CoordonnesGPS> FindAllCoordonnesGPSByferme(long a);
	
	public List<Parcellaire> GetParcesOfAFarm(long id);
	public void UpdateParecellaireOfAFarm(List<Parcellaire> parcellaires, long id_ferme);
	public List<ModeIrreguation> findAllModeIrrigation();
	public Parcellaire findParcellaireById(long a);
	public ModeIrreguation findModeIrrigationById(long a);
	public List<Ferme> FermesByGroupe(long id);
	public Ferme add(Ferme f, Groupe g);
	public boolean add(long f, List<CoordonnesGPS> l); // associer une liste de coorodonnées à une ferme
	public boolean add(Parcellaire p, List<CoordonnesGPS> l);
	public List<CoordonnesGPS> FindAllCoordonnesGPSByParcelle(long a);
	public Occupation add( Occupation o);
	public Occupation add( Parcellaire p, Occupation o);
	public Occupation addSecondOccupation( Parcellaire p, Occupation o);
	public List<Occupation> findAllOccupations();
	public Occupation findOccupationById(long a);
	
	public String Remove(Activite a);
	public String Remove(Groupe g);
	public String Remove(Famille f);
	public String Remove(SousFamille s);
	public String Remove(Variete v);
	public String Remove(Ferme f);
	public String Remove(Parcellaire p);
	public void setParcellaireActivation(Parcellaire p,boolean a);
	
	public void add(ActiviteHistory a);
	public void add(ClimatologieHistory a);
	public void add(FamilleHistory a);
	public void add(FermeHistory a);
	public void add(GroupeHistory a);
	public void add(ModeIrreguationHistory a);
	public void add(OccupationHistory a);
	public void add(ParcellaireHistory a);
	public void add(PersonnelHistory a);
	public void add(SousFamilleHistory a);
	public void add(VarieteHistory a);
	
	public void convertParcelleToBour(Parcellaire p);
	public void convertParcelleToIrregue(Parcellaire p);
	
	public List<Ferme> FindFermeDoesNotRegistreClimat(Date date) throws ParseException; 
	
	
	
	
//	public Employe addEmplye(Employe e);
//	public Employe update(Employe e);
//	public Employe findEmloye(Employe e);
//	public List<Employe> findEmployes(String id);
//	public List<Employe> getAllEmployes(boolean conge);
//	public List<Employe> getEmployesByDepartement(boolean conge, Departement departement);
//	public void bloquerEmploye(Employe e);
//	public void debloquerEmploye(Employe e);
//	
//	public gestion_presence addGestionPresence(gestion_presence gp, Employe e);
//	public List<gestion_presence> getGestionPresence(Employe e,Date date, String type);
//	
//	public Admin logIn(Admin a);
//	public Admin addAdmin(Admin a);
//	public Admin updateAdmin(Admin a);
//	
//	public Entreprise addEntreprise(Entreprise e);
//	public Entreprise updateEntreprise(Entreprise e);
//	public Entreprise findEntreprise(Entreprise e);
//	
//	public Departement addDepartement(Departement d);
//	public Departement updateDepartement(Departement d);
//	public Departement findDepartement(Departement d);
//	public List<Departement> findDepartements(String id);
//	public List<Departement> getAllDepartements();
//	
//	public BulletinPaie getInfoSalaire(Employe e, Date date, boolean normal);
//	public List<Employe> getAllEmployes();
	

}
