package si.smart.ferme.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.MXBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import si.smart.ferme.entities.Activite;
import si.smart.ferme.entities.Climatologie;
import si.smart.ferme.entities.CoordonnesGPS;
import si.smart.ferme.entities.Culture;
import si.smart.ferme.entities.Famille;
import si.smart.ferme.entities.Ferme;
import si.smart.ferme.entities.Groupe;
import si.smart.ferme.entities.ModeIrreguation;
import si.smart.ferme.entities.Occupation;
import si.smart.ferme.entities.Parcellaire;
import si.smart.ferme.entities.ParcellaireBour;
import si.smart.ferme.entities.ParcellaireIrregue;
import si.smart.ferme.entities.Personnel;
import si.smart.ferme.entities.Plantation;
import si.smart.ferme.entities.SousFamille;
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
public class DaoImp implements Dao{
	
	public DaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	@PersistenceContext
	private EntityManager em;
	/*----------EMPLOYE--------------*/
//	@Override
//	public Employe addEmplye(Employe e) {
//		Entreprise entr = em.find(Entreprise.class, 1L);
//		if (e.getSalBase()< entr.getSmig()) e.setSalBase(entr.getSmig());
//		Departement d = em.find(Departement.class, e.getDepartement().getCodeDept());
//		e.setDateEntre(new Date());
//		e.setActive(true);
//		e.setDepartement(d);
//		em.persist(e);
//		
//		return e;
//	}
//
//	@Override
//	public Employe update(Employe e) {
//		
//		Employe emp = em.find(Employe.class, e.getCodeEmp());
//		emp.affect(e);
//		em.persist(emp);
//		System.out.println("test");
//		return null;
//	}
//
//	@Override
//	public Employe findEmloye(Employe e) {
//		Employe emp = em.find(Employe.class, e.getCodeEmp());
//		return emp;
//	}
//
//	@Override
//	public List<Employe> findEmployes(String id) {
//		Query req = em.createQuery("select e from Employe e where e.cin like :x or e.numCnss like :x or e.nom like :x");
//		req.setParameter("x", "%"+id+"%");
//		return req.getResultList();
//		
//	}
//	
//	@Override
//	public List<Employe> getEmployesByDepartement(boolean conge, Departement d) {
//		Query req;
//		if (conge){
//			req = em.createQuery("select e from Employe e where e.active=true and e.departement.codeDept=?");
//			req.setParameter(1, d.getCodeDept());
//		}
//		else  {
//			req = em.createQuery("select e from Employe e where e.conge=false and e.active=true and e.departement.codeDept=?");
//			req.setParameter(1, d.getCodeDept());
//		}
//		return req.getResultList();
//	}
//	
//	@Override
//	public List<Employe> getAllEmployes(boolean conge) {
//		Query req;
//		if (conge){
//			req = em.createQuery("select e from Employe e where e.active=true");
//		}
//		else  req = em.createQuery("select e from Employe e where e.conge=false and e.active=true");
//		return req.getResultList();
//	}
//	
//	@Override
//	public List<Employe> getAllEmployes() {
//		Query req = em.createQuery("select e from Employe e where e.active=true");
//		return req.getResultList();
//	}
//	
//	@Override
//	public void bloquerEmploye(Employe e) {
//		e=em.find(Employe.class, e.getCodeEmp());
//		e.setActive(false);
//	}
//	
//	@Override
//	public void debloquerEmploye(Employe e) {
//		Entreprise ent = em.find(Entreprise.class, 1L);
//		e=em.find(Employe.class, e.getCodeEmp());
//		e.setActive(true);
//		e.setDateEntre(new Date());
//		e.setSalBase(ent.getSmig());
//	}
//	
//	/*-----------GESTION_PRESENCE----------------*/
//	
//	@Override
//	public gestion_presence addGestionPresence(gestion_presence gp, Employe e) {
//		Employe emp = em.find(Employe.class, e.getCodeEmp());
//		gp.setEmploye(emp);
//		em.persist(gp);
//		return gp;
//	}
//
//	@Override
//	public List<gestion_presence> getGestionPresence(Employe e, Date date, String type) {
//		
//		String s = date.getYear()+1900+"-"+(date.getMonth()+1)+"%";
//		Query req = em.createNativeQuery("select * from gestion_presence  where TYPE = ? and dateGestion like ? and codeEmploye = ? ORDER BY dateGestion DESC",gestion_presence.class);
//		req.setParameter(1, type);
//		req.setParameter(2, s);
//		req.setParameter(3, e.getCodeEmp());
//		return req.getResultList();
//		
//	}
//	
//	/*----------ADMIN--------------*/
//	
//	@Override
//	public Admin addAdmin(Admin a) {
//		em.persist(a);
//		return a;
//	}
//
//	@Override
//	public Admin updateAdmin(Admin a) {
//		Admin admin = em.find(Admin.class, a.getCodeAdmin());
//		admin.affect(a);;
//		return null;
//	}
//	
//	@Override
//	public Admin logIn(Admin a) {
//		Query req = em.createQuery("select a from Admin a where a.login = :x");
//		req.setParameter("x", a.getLogin());
//		Admin admin = new Admin();
//		try {
//			admin = (Admin)req.getSingleResult();
//		} catch (Exception e) {
//			throw new RuntimeException("employe introuvable");
//		}
//		
//		
//		if (!a.getMotpass().equals(admin.getMotpass())){
//			throw new RuntimeException("mp invalide");
//		}
//		else return admin;
//	}
//	
//	/*----------DEPARTEMENT--------------*/
//	
//	@Override
//	public Departement addDepartement(Departement d) {
//		Employe e = em.find(Employe.class, d.getChefDept().getCodeEmp());
//		d.setChefDept(e);
//		em.persist(d);
//		return null;
//	}
//
//	@Override
//	public Departement updateDepartement(Departement d) {
//		Departement dept = em.find(Departement.class, d.getCodeDept());
//		dept.affect(d);
//		em.persist(dept);
//		return null;
//	}
//	
//	@Override
//	public Departement findDepartement(Departement d) {
//		Departement dept = em.find(Departement.class, d.getCodeDept());
//		
//		return dept;
//	}
//
//	@Override
//	public List<Departement> findDepartements(String id) {
//		Query req = em.createQuery("select d from Departement d where d.nom like :x");
//		req.setParameter("x", "%"+id+"%");
//		return req.getResultList();
//	}
//
//	@Override
//	public List<Departement> getAllDepartements() {
//		Query req = em.createQuery("select d from Departement d");
//		List<Departement> d = req.getResultList();
//		return d;
//	}
//	
//	
//	/*----------ENTREPRISE--------------*/
//	
//	@Override
//	public Entreprise addEntreprise(Entreprise e) {
//		em.persist(e);
//		return e;
//	}
//
//	@Override
//	public Entreprise updateEntreprise(Entreprise e) {
//		Entreprise entp = em.find(Entreprise.class, e.getCodeEntrp());
//		entp.affect(e);
//		return e;
//	}
//	
//	@Override
//	public Entreprise findEntreprise(Entreprise e){
//		Entreprise entr = em.find(Entreprise.class, 1L);
//		return entr;
//	}
//
//	/*----------BULLETIN_PAIE--------------*/
//
//	@Override
//	public BulletinPaie getInfoSalaire(Employe e, Date date, boolean normal) {
//		Query req;	String d;	int y,m;
//		
//		Entreprise entrp = em.find(Entreprise.class, 1L);
//		e = em.find(Employe.class, e.getCodeEmp());
//		
//		e.setSalBase(Math.max(e.getSalBase(), entrp.getSmig()));
//		
//		if (!normal) e.setActive(false);
//		BulletinPaie bp = new BulletinPaie();
//		
//		bp.setEmploye(e);
//		bp.setEntreprise(entrp);
//		
//		if ( date.getMonth() == 0 ){	y = (date.getYear()-1)+1900; m = 12;	}
//		else {	y = date.getYear()+1900; m = date.getMonth();	}
//		d = y+"-"+m;
//		String sd =d;
//		d = y+"-"+m+"%";
//		
//		//jours et heures 
//		if (normal){
//			bp.setMois(sd);
//			req = em.createNativeQuery("select count(*) from gestion_presence  where TYPE = ? and codeEmploye = ? and dateGestion like ?");
//			req.setParameter(1, "A");
//			req.setParameter(2, e.getCodeEmp());
//			req.setParameter(3, d);
//			bp.setNbJours(bp.getNbJoursTravail(date, true)-Integer.parseInt(""+req.getSingleResult()));
//			System.out.println(bp.getNbJours());
//			bp.setHeureNormale(bp.getNbJours()*8);
//			e.setNbJoursTravail(e.getNbJoursTravail()+bp.getNbJours());
//			
//		}else {
//			bp.setMois(date.getYear()+1900+"-"+date.getMonth()+1);
//			req = em.createNativeQuery("select count(*) from gestion_presence  where TYPE = ? and codeEmploye = ? and dateGestion <= ? and dateGestion >= ?");
//			req.setParameter(1, "A");
//			req.setParameter(2, e.getCodeEmp());
//			req.setParameter(3, date);
//			req.setParameter(4, new Date(date.getYear(),date.getMonth(),1));
//			bp.setNbJours(bp.getNbJoursTravail(date, false)-Integer.parseInt(""+req.getSingleResult()));
//			bp.setHeureNormale(bp.getNbJours()*8);
//			e.setNbJoursTravail(e.getNbJoursTravail()+bp.getNbJours());
//		}
//		
//		
//		
//		//heureSup1
//		if (normal){
//			req = em.createNativeQuery("select sum(heureSup1) from gestion_presence  where codeEmploye = ? and dateGestion like ?");
//			req.setParameter(1, e.getCodeEmp());
//			req.setParameter(2, d);
//		}else{
//			req = em.createNativeQuery("select sum(heureSup1) from gestion_presence  where codeEmploye = ? and dateGestion <= ? and dateGestion >= ? ");
//			req.setParameter(1, e.getCodeEmp());
//			req.setParameter(2, date);
//			req.setParameter(3, new Date(date.getYear(),date.getMonth(),1));
//		}
//		try {
//			bp.setHeureSup1(Integer.parseInt(""+req.getSingleResult()));
//		} catch (Exception e2) {
//			bp.setHeureSup1(0);
//		}
//		
//		//heureSup2
//		if (normal){
//			req = em.createNativeQuery("select sum(heureSup2) from gestion_presence  where codeEmploye = ? and dateGestion like ?");
//			req.setParameter(1, e.getCodeEmp());
//			req.setParameter(2, d);
//		}else{
//			req = em.createNativeQuery("select sum(heureSup2) from gestion_presence  where codeEmploye = ? and dateGestion <= ? and dateGestion >= ? ");
//			req.setParameter(1, e.getCodeEmp());
//			req.setParameter(2, date);
//			req.setParameter(3, new Date(date.getYear(),date.getMonth(),1));
//		}
//		try {
//			bp.setHeureSup2(Integer.parseInt(""+req.getSingleResult()));
//		} catch (Exception e2) {
//			bp.setHeureSup2(0);
//		}
//		
//		//heureSup3
//		if (normal){
//			req = em.createNativeQuery("select sum(heureSup3) from gestion_presence  where codeEmploye = ? and dateGestion like ?");
//			req.setParameter(1, e.getCodeEmp());
//			req.setParameter(2, d);
//		}else{
//			req = em.createNativeQuery("select sum(heureSup3) from gestion_presence  where codeEmploye = ? and dateGestion <= ? and dateGestion >= ? ");
//			req.setParameter(1, e.getCodeEmp());
//			req.setParameter(2, date);
//			req.setParameter(3, new Date(date.getYear(),date.getMonth(),1));
//		}
//		try {
//			bp.setHeureSup3(Integer.parseInt(""+req.getSingleResult()));
//		} catch (Exception e2) {
//			bp.setHeureSup3(0);
//		}
//		
//		//anciennete
//		Date entr = e.getDateEntre();
//		int a = (entr.getMonth()+1) >= m ? y-(entr.getYear()+1900):y-(entr.getYear()+1900)-1;
//		if (a<2) bp.setAnciennete(0);
//		else if (a>=2 && a<5) bp.setAnciennete(5);
//		else if (a>=5 && a<12) bp.setAnciennete(10);
//		else if (a>=12 && a<20) bp.setAnciennete(15);
//		else if (a>=20 && a<25) bp.setAnciennete(20);
//		else if (a>=25) bp.setAnciennete(25);
//		
//		bp.setDatePaie(date);
//		em.persist(e);
//		
//		return bp;
//	}
//
//

	@Override
	public Groupe add(Groupe g) {
		
		System.out.println("helle");
		em.persist(g);
		return g;
	}

	@Override
	public Personnel add(Personnel g) {
		
		em.persist(g);
		return g;
	}

	@Override
	public Ferme add(Ferme g) {
		
		em.persist(g);
		return g;
	}
	public Ferme add(Ferme f, Groupe g) {
		
		f.setGroupe(g);
		em.persist(f);
		return f;
	}

	@Override
	public CoordonnesGPS add(CoordonnesGPS c) {
		
		em.persist(c);
		return c;
	}

	@Override
	public Groupe update(Groupe g) {
		
		Groupe gr=em.find(Groupe.class, g.getId());
		gr.setDescription(g.getDescription());
		gr.setNom(g.getNom());
		em.persist(gr);
		System.out.println("here");
		return gr;
	}

	@Override
	public Personnel update(Personnel g) {
		
		Personnel gr=em.find(Personnel.class, g.getId());
		gr= new Personnel(g);
		return gr;
	}

	@Override
	public Ferme update(Ferme g) {
		
		Ferme f= em.find(Ferme.class, g.getId_Ferme());
		Personnel p=em.find(Personnel.class, g.getGerant().getId());
		f.setGerant(p);
		f=f.affect(g);
		return f;
	}

	@Override
	public CoordonnesGPS update(CoordonnesGPS c) {
		
//		Ferme f= em.find(CoordonnesGPS.class, c.get);
//		f=new Ferme(g);
//		return f;
		return null;
	}

	@Override
	public Groupe FindGroupeById(long a) {
		
		Groupe gr=em.find(Groupe.class, a);
		return gr;
	}

	@Override
	public Personnel FindPersonnelById(long a) {
		
		Personnel pl=em.find(Personnel.class, a);
		return pl;
	}

	@Override
	public Ferme FindFermeById(long a) {
		Ferme f=em.find(Ferme.class, a);
		return f;
	}

	@Override
	public CoordonnesGPS FindCoordonnesGPSById(long a) {
		
		CoordonnesGPS c=em.find(CoordonnesGPS.class, a);
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groupe> FindAllGroupe() {
		
		Query req = em.createQuery("select d from Groupe d");
		//req.setParameter("x", "%"+id+"%");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personnel> FindAllPersonnel() {
		
		Query req = em.createQuery("select d from Personnel d");
		//req.setParameter("x", "%"+id+"%");
		return req.getResultList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ferme> FindAllFerme() {
		
		Query req = em.createQuery("select d from Ferme d");
		//req.setParameter("x", "%"+id+"%");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CoordonnesGPS> FindAllCoordonnesGPS() {
		
		Query req = em.createQuery("select d from CoordonnesGPS d");
		//req.setParameter("x", "%"+id+"%");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parcellaire> GetParcesOfAFarm(long id) {
		
		
		Query req;
		
			req = em.createQuery("select p from Parcellaire p where p.ferme.id_Ferme=?");
			req.setParameter(1, id);
		
		return req.getResultList();
	}
	
	public List<Ferme> FermesByGroupe(long id) {
		
		
		Query req;
		
			req = em.createQuery("select f from Ferme f where f.groupe.id=?");
			req.setParameter(1, id);
		
		return req.getResultList();
	}
	
	@Override
	public void UpdateParecellaireOfAFarm(List<Parcellaire> parcellaires, long id_ferme) {
		
		Ferme f=em.find(Ferme.class, id_ferme);
		System.out.println("TEST: la ferme "+ f.getId_Ferme());
		f.setParces(parcellaires);
		em.merge(f);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModeIrreguation> findAllModeIrrigation() {
		
		Query req = em.createQuery("select d from ModeIrreguation d");
		//req.setParameter("x", "%"+id+"%");
		return req.getResultList();
	}

	@Override
	public ModeIrreguation findModeIrrigationById(long a) {
		
		ModeIrreguation mode=em.find(ModeIrreguation.class,(int)a);
		return mode;
	}

	@Override
	public List<CoordonnesGPS> FindAllCoordonnesGPSByferme(long a) {
		
		System.out.println("INFO : We are in the DAO Manager");
		Query req;
		req=em.createQuery("select c from CoordonnesGPS c where c.ferme.id_Ferme=?");
		req.setParameter(1, a);
		
//		List<CoordonnesGPS> l= req.getResultList();
//		for (CoordonnesGPS c : l) {
//			System.out.println(c.getId()+" : "+c.getLatitude()+" : "+c.getLongitude());
//		}
		System.out.println("size of the list is : "+req.getResultList().size());
	    System.out.println("INFO : DAO manager work is finished ...");
	return req.getResultList();
	}

	
	public void RemoveCoordonesOfFerm(long a ){
		
		
		
		
	}
	
	public List<CoordonnesGPS> FindAllCoordonnesGPSByParcelle(long a) {
		
		System.out.println("INFO : We are in the DAO Manager");
		Query req;
		req=em.createQuery("select c from CoordonnesGPS c where c.parcellaire.id_parce=?");
		req.setParameter(1, a);
		
//		List<CoordonnesGPS> l= req.getResultList();
//		for (CoordonnesGPS c : l) {
//			System.out.println(c.getId()+" : "+c.getLatitude()+" : "+c.getLongitude());
//		}
		System.out.println("size of the list is : "+req.getResultList().size());
	    System.out.println("INFO : DAO manager work is finished ...");
	return req.getResultList();
	}
	
	@Override
	public boolean add(long f, List<CoordonnesGPS> l) {
		
		boolean a=false;
		Ferme fr=em.find(Ferme.class, f);
		List<CoordonnesGPS> lis=this.FindAllCoordonnesGPSByferme(f);
		if(lis.size()>1)
		for (CoordonnesGPS c : lis) {
			c.setFerme(null);
			em.remove(c);
		}
		for (CoordonnesGPS c : l) {
			c.setFerme(fr);
			fr.setPolygoneMaps_ferme(c);
			em.persist(c);
			
		}
		em.merge(fr);
		System.out.println("fin d'ajout des Coordonnées ");
		a=true;
		return a;
	}

	@Override
	public Famille add(Famille g) {
		
		System.out.println("before");
		em.persist(g);
		System.out.println("after");
		return g;
	}
	public Famille add(Famille f, Activite a){
		if( em.find(Activite.class, a.getId()) == null )	em.persist(a);	
		if( em.find(Famille.class, f.getId()) == null )	em.persist(f);	
		if( em.find(Famille.class, f.getId()) != null  )    f= em.find(Famille.class, f.getId()); 
		f.setActivite(a);
		
		
		em.merge(f);
	
		em.merge(a);
		
		System.out.println("famille est a jouté à la base ;) ");
		
		
		return f;
		
		/*if( em.find(Famille.class, f.getId()) == null )	em.persist(f);	
		s.setFamille(f);
		em.persist(s);
		return s;*/
	}
	@Override
	public Activite add(Activite g) {
		
		em.persist(g);
		return g;
	}

	@Override
	public Famille update(Famille f) {
		
		//Famille newf = em.find(Famille.class, f.getId());
		Famille newf = em.getReference(Famille.class, f.getId());
		newf.affect(f);
		this.add(f, f.getActivite());
		em.persist(newf);
		return newf;
	}

	@Override
	public Activite update(Activite a) {
		
		Activite na=em.find(Activite.class, a.getId());
		na.setLibelle(a.getLibelle());
		na.setObservation(a.getObservation());
		return na;
	}

	@Override
	public Famille FindFamilleById(long a) {
		
		Query req=em.createQuery("select f From Famille f where f.id= ?");
		req.setParameter(1, a);
		return (Famille) req.getSingleResult();
	}
	
	public List<Famille> FindALLFamilles() {
		
		Query req=em.createQuery("select f From Famille f ");
		return req.getResultList();
	}
	
	public List<SousFamille> FindALLSousFamilles(long a) {
		
		Query req=em.createQuery("select s From SousFamille s where s.famille.id= ? ");
		req.setParameter(1, a);
		return req.getResultList();
	}
	

	@Override
	public Activite FindActiviteById(long a) {
		
		Query req=em.createQuery("select a From Activite a where a.id= ?");
		req.setParameter(1, a);
		return (Activite) req.getSingleResult();
	}

	@Override
	public SousFamille add(SousFamille s) {
		
		System.out.println("DAO starts ...");
		em.persist(s);
		System.out.println("DAO ends ....");
		return s;
	}

	@Override
	public SousFamille add(SousFamille s, Famille f) {
		
		// on test si f exist deja dans la base
		if( em.find(Famille.class, f.getId()) == null )	em.persist(f);	
		s.setFamille(f);
		em.persist(s);
		return s;
	}

	@Override
	public Variete add(Variete v) {
		
		em.persist(v);
		return v;
	}

	@Override
	public Variete add(Variete v, SousFamille s) {
		
		if( em.find(SousFamille.class, s.getId()) == null) em.persist(s);
		v.setSousfamille(s);
		em.persist(v);
		return v;
	}

	@Override
	public List<Variete> FindVarietesBySousFamille(SousFamille s) {
		
		Query req=em.createQuery("select v FROM Variete v where v.sousfamille.id = ? ");
		req.setParameter(1, s.getId());
		return req.getResultList();
	}

	@Override
	public List<Variete> FindVarietesBySousFamille(long a) {
		
		Query req=em.createQuery("select v FROM Variete v where v.sousfamille.id = ? ");
		req.setParameter(1, a);
		return req.getResultList();
		
	}

	@Override
	public Variete FindVarieteById(long a) {
		
		return em.find(Variete.class, a);
	}

	@Override
	public boolean add(Parcellaire p, List<CoordonnesGPS> l) {
		
		boolean a=false;
		Parcellaire fr=em.find(Parcellaire.class, p.getId_parce());
		List<CoordonnesGPS> lis=this.FindAllCoordonnesGPSByParcelle(p.getId_parce());
		if(lis.size()>1)
		for (CoordonnesGPS c : lis) {
			c.setParcellaire(null);
			em.remove(c);
		}
		for (CoordonnesGPS c : l) {
			c.setParcellaire(fr);
			fr.setPolygoneMaps_parce(c);;
			em.persist(c);
			
		}
		em.merge(fr);
		System.out.println("fin d'ajout des Coordonnées ");
		a=true;
		return a;
		
	}

	@Override
	public Parcellaire findParcellaireById(long a) {
		
		Parcellaire p = em.find(Parcellaire.class, a);
		return p;
	}

	@Override
	public Occupation add(Occupation o) {
		
		em.persist(o);
		return o;
	}

	@Override
	public List<Occupation> findAllOccupations() {
		
		Query req= em.createQuery("SELECT o From Occupation o");
		return req.getResultList();
	}

	@Override
	public Occupation findOccupationById(long a) {
		
		Occupation o = em.find(Occupation.class, a);
		return o;
	}

	@Override
	public Occupation add(Parcellaire p, Occupation o) {
		
		Parcellaire pr= em.find(Parcellaire.class, p.getId_parce());
		o.setParcelle(pr);
		pr.setOccupation(o);
		em.persist(o);
		em.merge(pr);
		return o;
	}
	@Override
	public Occupation addSecondOccupation( Parcellaire p, Occupation o){
		Parcellaire pr= em.find(Parcellaire.class, p.getId_parce());
		o.setParcelle(pr);
		pr.setOccupation2(o);
		em.persist(o);
		em.merge(pr);
		return o;
	}
	@Override
	public List<Activite> FindAllActivities() {
		
		Query req= em.createQuery("select a from Activite a");
		return req.getResultList();
	}

	@Override
	public SousFamille findSousFamillebyId(long a) {
		
		SousFamille s= em.find(SousFamille.class, a);
		return s;
	}

	@Override
	public List<SousFamille> FindAllSousFamilles() {
		
		Query req= em.createQuery("select s from SousFamille s");
		return req.getResultList();
	}

	@Override
	public List<Variete> findAllVarietes() {
		
		Query req= em.createQuery("select s from Variete s");
		return req.getResultList();
		
	}

	@Override
	public List<Parcellaire> findAllParcelles() {
		
		Query req= em.createQuery("select p from Parcellaire p ");
		return req.getResultList();
	}

	@Override
	public void update(ModeIrreguation m) {
		
		ModeIrreguation mode= em.find(ModeIrreguation.class, m.getId_mode());
		mode.affect(m);
		em.persist(mode);
	}

	@Override
	public void update(SousFamille s) {
		
		SousFamille ns = em.find(SousFamille.class, s.getId());
		ns.affect(s);
		Famille f= em.find(Famille.class, s.getFamille().getId());
		ns.setFamille(f);
		em.persist(ns);
	}

	@Override
	public void update(Variete v) {
		
		Variete nv = em.find(Variete.class, v.getId());
		nv.affect(v);
		SousFamille s=findSousFamillebyId(v.getSousfamille().getId());
		nv.setSousfamille(s);
		em.persist(nv);
	}

	@Override
	public String Remove(Activite a) {
		
		Query query = em.createQuery("Select f from Famille f where f.activite.id = ?");
		query.setParameter(1, a.getId());
		List<Famille> familles = query.getResultList();
		if( CollectionUtils.isEmpty(familles ) ) {
			em.remove(em.contains(a) ? a : em.merge(a));
			//em.remove(a);
			return "activité supprimée avec succés !";
		}
		
		return "impossible de supprimer cette Activité !";
	}

	@Override
	public String Remove(Groupe g) {
		
		Query query = em.createQuery("Select f from Ferme f where f.groupe.id = ?");
		query.setParameter(1, g.getId());
		List<Ferme> fermes = query.getResultList();
		if( CollectionUtils.isEmpty(fermes ) ) {
			em.remove(em.contains(g) ? g : em.merge(g));
			//em.remove(a);
			return "Groupe supprimé avec succés !";
		}
		
		return "impossible de supprimer ce Groupe !";
	}

	@Override
	public String Remove(Famille f) {
		
		Query query = em.createQuery("Select s from SousFamille s where s.famille.id = ?");
		query.setParameter(1, f.getId());
		List<SousFamille> Sousfamilles = query.getResultList();
		if( CollectionUtils.isEmpty(Sousfamilles ) ) {
//			Query req1 = em.createQuery("Select a from Activite a where a.famille.id = ?");
//			req1.setParameter(1, f.getId());
//			Activite a= (Activite) req1.getSingleResult();
//			a.setFamille(null);
//			this.update(a);
//		    System.out.println(" let s see if is updated "	+em.find(Activite.class, a.getId()).getFamille().getLibelle()  );
			System.out.println("passing ..... ");
			f= em.find(Famille.class, f.getId());
			f.setActivite(null);
			em.persist(f);
			System.out.println("passed ");
			System.out.println(f.getActivite());
			Query req = em.createQuery("DELETE FROM Famille f WHERE f.id = ?");
			req.setParameter(1, f.getId());
			int i=req.executeUpdate();
			//em.remove(em.contains(f) ? f : em.merge(f));
			//em.remove(a);
			if(i>0)
			return "Famille supprimée avec succés !";
		}
		
		return "impossible de supprimer cette Famille !";
	}

	@Override
	public String Remove(SousFamille s) {
		
		Query query = em.createQuery("Select v from Variete v  where v.sousfamille.id = ?");
		query.setParameter(1, s.getId());
		List<Variete> v = query.getResultList();
		if( CollectionUtils.isEmpty(v ) ) {
			em.remove(em.contains(s) ? s : em.merge(s));
			//em.remove(a);
			return "Sous Famille supprimée avec succés !";
		}
		
		return "impossible de supprimer cette Sous Famille !";
	}

	@Override
	public String Remove(Variete v) {
		
		Query query = em.createQuery("Select o from Occupation o where o.variete.id = ?");
		query.setParameter(1, v.getId());
		List<Occupation> occupations = query.getResultList();
		if( CollectionUtils.isEmpty(occupations ) ) {
			em.remove(em.contains(v) ? v : em.merge(v));
			//em.remove(a);
			return "Variété supprimée avec succés !";
		}
		
		return "impossible de supprimer cette Variété !";
	}

	@Override
	public String Remove(Ferme f) {
		
		Query query = em.createQuery("Select p from Parcellaire p where p.ferme.id_Ferme = ?");
		query.setParameter(1, f.getId_Ferme());
		List<Parcellaire> parcelles = query.getResultList();
		if( CollectionUtils.isEmpty(parcelles ) ) {
			em.remove(em.contains(f) ? f : em.merge(f));
			//em.remove(a);
			return "Ferme supprimée avec succés !";
		}
		
		return "impossible de supprimer cette Ferme !";
	}

	@Override
	public String Remove(Parcellaire p) {
		
		Query query = em.createQuery("Select o from Occupation o where o.parcelle.id_parce = ?");
		query.setParameter(1, p.getId_parce());
		List<Occupation> occupations = query.getResultList();
		if( CollectionUtils.isEmpty(occupations ) ) {
			em.remove(em.contains(p) ? p : em.merge(p));
			//em.remove(a);
			return "parcelles supprimée avec succés !";
		}
		
		return "impossible de supprimer cette Parcelle !";
	}

	@Override
	public ModeIrreguation add(ModeIrreguation mode) {
		
		em.persist(mode);
		return null;
	}

	@Override
	public Occupation findOccupationByParcelle(long id) {
		
		
		Parcellaire parcellaire = em.find(Parcellaire.class, id);
		
		return parcellaire.getOccupation();
	}

	@Override
	public Climatologie add(Climatologie c) {
		
		em.persist(c);
		return c;
	}

	@Override
	public Climatologie update(Climatologie c) {
		
		Climatologie cn= em.find(Climatologie.class, c.getId());
		cn.setDate(c.getDate());
		cn.setPluie(c.getPluie());
		cn.setTemperature(c.getTemperature());
		Ferme f=em.find(Ferme.class, c.getFerme().getId_Ferme());
		if(f== null) {
			em.persist(c.getFerme());
			f=em.find(Ferme.class, c.getFerme().getId_Ferme());
		}
			
		cn.setFerme(f);
		em.persist(cn);
		return cn;
	}

	@Override
	public Climatologie remove(Climatologie c) {
		c=em.find(Climatologie.class, c.getId());
		c.setFerme(null);
		em.remove(c);
		return null;
	}

	@Override
	public List<Climatologie> findAllClimatologies() {
		
		
		Query req=em.createQuery("select  c FROM Climatologie c");
		return req.getResultList();
	}

	@Override
	public List<Climatologie> FindClimatologiesByFerme(Ferme f) {
		
		Query req=em.createQuery("SELECT c FROM Climatologie c where c.ferme.id_Ferme = ?");
		req.setParameter(1, f.getId_Ferme());
		return req.getResultList();
	}

	@Override
	public Climatologie FindClimatologieById(long a) {
		
		return em.find(Climatologie.class, a);
	}

	@Override
	public Climatologie add(Climatologie c, Ferme f) {
		
		Ferme fe= em.find(Ferme.class, f.getId_Ferme());
		c.setFerme(fe);
		em.persist(c);
		return FindClimatologieById(c.getId());
	}

	@Override
	public void update(Occupation o) {
		Variete v=null;
		if(o.getVariete() != null)
			v= em.find(Variete.class, o.getVariete().getId());
		Occupation on= em.find(Occupation.class, o.getId());
		Parcellaire p=this.findParcellaireById(o.getParcelle().getId_parce());
		if( Plantation.class.isAssignableFrom(o.getClass()) ){
			Plantation on1 = (Plantation) em.find(Plantation.class, o.getId());
			Plantation o1 = (Plantation) o;
			on1.setAnnePlantation(o1.getAnnePlantation());
			on1.setEcartX(o1.getEcartX());
			on1.setEcartY(o1.getEcartY());
			on1.setNbrArbres(o1.getNbrArbres());
			on1.setOrdrevariete(o.getOrdrevariete());
			on1.setParcelle(p);
			on1.setVariete(v);
			
			em.persist(on1);
		}
		if( Culture.class.isAssignableFrom(o.getClass()) ){
			Culture on1 = (Culture) em.find(Culture.class, o.getId());
			on1.setOrdrevariete(o.getOrdrevariete());
			on1.setParcelle(p);
			on1.setVariete(v);
			em.persist(on1);
		}
		else{
			on.setOrdrevariete(o.getOrdrevariete());
			on.setParcelle(p);
			on.setVariete(v);
			em.persist(on);
		}
	}

	@Override
	public void update(Parcellaire p) {
		
		System.out.println(" p.getActivited()== "+p.getActivited());
		if( p.getActivited()== false){
			
			if(p.getClass().isAssignableFrom(ParcellaireIrregue.class)){
//				ParcellaireIrregue sp= (ParcellaireIrregue) p;
//				ParcellaireIrregue np= (ParcellaireIrregue) findParcellaireById(p.getId_parce());
//				np.setS_brute(p.getS_brute());
//				np.setS_inculte(p.getS_inculte());
//				np.setS_net(p.getS_brute()-p.getS_inculte());
//				np.setLibelle(p.getLibelle());
//				System.out.println("voici le mode :"+sp.getMode().getId_mode());
//				ModeIrreguation mode= em.find(ModeIrreguation.class, sp.getMode().getId_mode() );
//				np.setMode(mode);
//				System.out.println(np.getId_parce());
//				System.out.println(np.getLibelle());
//				System.out.println(np.getS_brute()+" "+np.getS_net()+" "+np.getS_brute());
//				System.out.println(np.getMode().getNom_mode());
//				em.persist(np);
//				Parcellaire pInbd= em.find(Parcellaire.class, p.getId_parce()); // Parcellaire in the database table 
//				if(! pInbd.getClass().isAssignableFrom(ParcellaireIrregue.class)) // if the persited parcellaire is not irregue
//					convertParcelleToIrregue(pInbd); // we convert it to be Irregue
//				ParcellaireIrregue np= (ParcellaireIrregue) em.find(Parcellaire.class, p.getId_parce()); // we return the persisted object to modify its attributs
//			
//				np.setS_brute(p.getS_brute());
//				np.setS_inculte(p.getS_inculte());
//				np.setS_net(p.getS_brute()-p.getS_inculte());
//				np.setLibelle(p.getLibelle());
//				ModeIrreguation mode= em.find(ModeIrreguation.class, sp.getMode().getId_mode() );
//				np.setMode(mode);
//				em.persist(np);
				System.out.println("updating a ParcellaireIrregue ");
				updateParcellaireIrregue((ParcellaireIrregue)p);
			}
			if(p.getClass().isAssignableFrom(ParcellaireBour.class)){
				
//				ParcellaireBour sp= (ParcellaireBour) p;
//				ParcellaireBour np= (ParcellaireBour) findParcellaireById(p.getId_parce());
//				np.setS_brute(p.getS_brute());
//				np.setS_inculte(p.getS_inculte());
//				np.setActivited(p.getActivited());
//				np.setS_net(p.getS_brute()-p.getS_inculte());
//				np.setLibelle(p.getLibelle());
//				
//				em.persist(np);
				System.out.println("updating a ParcellaireBour ");
				updateParcellaireBour((ParcellaireBour)p);
			}
		}
			else {
				System.out.println("You can not update this Parcellaire! Ask the administrator for that ");
			}
		
		
		
	}
	
	public void updateParcellaireIrregue(ParcellaireIrregue p){
		ParcellaireIrregue np= (ParcellaireIrregue) em.find(Parcellaire.class, p.getId_parce());
		ModeIrreguation mode= em.find(ModeIrreguation.class, p.getMode().getId_mode());
		np.setMode(mode);
		np.setS_brute(p.getS_brute());
		np.setS_inculte(p.getS_inculte());
		np.setS_net(p.getS_brute()-p.getS_inculte());
		np.setLibelle(p.getLibelle());
		em.persist(np);
	}
	public void updateParcellaireBour(ParcellaireBour p){
		ParcellaireBour np= (ParcellaireBour) em.find(Parcellaire.class, p.getId_parce());
		np.setS_brute(p.getS_brute());
		np.setS_inculte(p.getS_inculte());
		np.setS_net(p.getS_brute()-p.getS_inculte());
		np.setLibelle(p.getLibelle());
		em.persist(np);
	}

	@Override
	public void add(ActiviteHistory a) {
		
		em.persist(a);
		System.out.println("ActiviteHistory is persisted");
	}

	@Override
	public void add(ClimatologieHistory a) {
		em.persist(a);
		System.out.println("ClimatologieHistory is persisted");
	}

	@Override
	public void add(FamilleHistory a) {
		em.persist(a);
		System.out.println("FamilleHistory is persisted");
	}

	@Override
	public void add(FermeHistory a) {
		em.persist(a);
		System.out.println("FermeHistory is persisted");
	}

	@Override
	public void add(GroupeHistory a) {
		em.persist(a);
		System.out.println("GroupeHistory is persisted");
	}

	@Override
	public void add(ModeIrreguationHistory a) {
		em.persist(a);
		System.out.println("ModeIrreguationHistory is persisted");
	}

	@Override
	public void add(OccupationHistory a) {
		em.persist(a);
		System.out.println("OccupationHistory is persisted");
	}

	@Override
	public void add(ParcellaireHistory a) {
		System.out.println("tryiiing to persist parcellaire that id = "+a.getId_parce());
		em.persist(a);
		System.out.println("ActiviteHistory is persisted");
	}

	@Override
	public void add(PersonnelHistory a) {
		em.persist(a);
		System.out.println("PersonnelHistory is persisted");
	}

	@Override
	public void add(SousFamilleHistory a) {
		em.persist(a);
		System.out.println("SousFamilleHistory is persisted");
	}

	@Override
	public void add(VarieteHistory a) {
		em.persist(a);
		System.out.println("VarieteHistory is persisted");
	}

	@Override
	public void setParcellaireActivation(Parcellaire p, boolean a) {
		
		Parcellaire np=em.find(Parcellaire.class, p.getId_parce());
		np.setActivited(a);
		em.persist(np);
	}

	
	public void convertParcelleToBour(Parcellaire p){
		
		Query req= em.createNativeQuery("UPDATE Parcellaire p SET type_parcellaire =  'Bour'  WHERE  p.id_parce = ? ");
		req.setParameter(1, p.getId_parce());
		req.executeUpdate();
		
	}

	public void convertParcelleToIrregue(Parcellaire p){
		Query req= em.createNativeQuery("UPDATE Parcellaire p SET type_parcellaire =  'Irregue'  WHERE  p.id_parce = ? ");
		req.setParameter(1, p.getId_parce());
		req.executeUpdate();
	}
	
	
	
	@Override
	public List<Ferme> FindFermeDoesNotRegistreClimat(Date date) throws ParseException {
		List<Ferme> fermes= FindAllFerme();
		List<Ferme> fermesOK= new ArrayList<Ferme>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String d= df.format(date);
		System.out.println("voici la date "+d);
		try {
			date= df.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			d= df.format(new Date());
			date= df.parse(d);
			e.printStackTrace();
		}
		for(Ferme f : fermes){
			Query req=em.createQuery("SELECT c FROM  Climatologie c WHERE c.date LIKE  ?  and ferme.id_Ferme = ? ");
			req.setParameter(1, date);
			req.setParameter(2, f.getId_Ferme());
			List<Climatologie> climatologies = req.getResultList();
			if(  CollectionUtils.isEmpty(climatologies ) ) {
				fermesOK.add(f);
			}
		}
		return fermesOK;
	}






	

}
