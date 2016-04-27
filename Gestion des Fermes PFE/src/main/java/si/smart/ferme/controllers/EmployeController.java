package si.smart.ferme.controllers;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import si.smart.ferme.dao.Dao;
import si.smart.ferme.entities.Activite;
import si.smart.ferme.entities.CategorieProduit;
import si.smart.ferme.entities.Climatologie;
import si.smart.ferme.entities.Culture;
import si.smart.ferme.entities.Famille;
import si.smart.ferme.entities.Ferme;
import si.smart.ferme.entities.Groupe;
import si.smart.ferme.entities.ModeIrreguation;
import si.smart.ferme.entities.Occupation;
import si.smart.ferme.entities.Parcellaire;
import si.smart.ferme.entities.ParcellaireIrregue;
import si.smart.ferme.entities.Personnel;
import si.smart.ferme.entities.Plantation;
import si.smart.ferme.entities.Produit;
import si.smart.ferme.entities.SousFamille;
import si.smart.ferme.entities.Variete;
import si.smart.ferme.metier.Metier;
import si.smart.ferme.metier.MetierImp;
import si.smart.ferme.models.ClimatologieForm;
import si.smart.ferme.models.FamilleForm;
import si.smart.ferme.models.FermeForm;
import si.smart.ferme.models.OccupationForm;
import si.smart.ferme.models.ParcellaireFomr;

@Controller
public class EmployeController {
	
	@Autowired
	private Metier metier;
	
	
	
	

	
	@RequestMapping(value={"listerActivites" , "/admin/listerActivites" })
	public String listerActivites(Model model, HttpServletRequest request, HttpSession session){
		
		List<Activite> Activites= metier.FindAllActivities();
		model.addAttribute("Activites", Activites);
		
		return "listerActivites";
	}
	
	@RequestMapping(value="listerGroupes")
	public String listerGroupe(Model model, HttpServletRequest request, HttpSession session){
		
		List<Groupe> Groupes= metier.FindAllGroupe();
		model.addAttribute("Groupes", Groupes);
		
		return "listerGroupes";
	}
	
	@RequestMapping(value="ajouterClimat")
	public String ajouterClimat(Model model, ClimatologieForm cf , HttpServletRequest request, HttpSession session){
		
		List<Ferme> fermes=metier.FindAllFerme();
		model.addAttribute("fermes", fermes);
		model.addAttribute("cf", new ClimatologieForm());
		try {
			if(cf.getSubmit().equals("ajouterClimat")){
				System.out.println("Controlleur de l'ajout de climatologie a commencé son travail");
				cf.setSubmit(null);
				System.out.println(cf.getDate()+" "+cf.getPluie()+" "+cf.getFerme()+" "+cf.getTemperature());
				System.out.println("voici les données saisi dans le formulaire :");
				System.out.println("Date : "+cf.getDate());
				System.out.println("Pluie : "+cf.getPluie());
				System.out.println("Ferme : "+cf.getFerme());
				System.out.println("Temperature : "+cf.getTemperature());
				System.out.println("on est pret pour ajouter une climat");
				Climatologie c = new Climatologie();
				Ferme f= metier.FindFermeById(cf.getFerme());
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date d= df.parse(cf.getDate());
				d=df.parse(df.format(d));
				c.setDate(d);
				c.setPluie(cf.getPluie());
				c.setTemperature(cf.getTemperature());
				System.out.println("objet climatologie est crée !");
				System.out.println(" voici l'objet : "+c.getPluie()+" "+c.getTemperature()+" "+c.getDate());
				metier.add(c,f);
				System.out.println(c.getDate()+" "+c.getPluie()+" "+c.getFerme()+" "+c.getTemperature());
				System.out.println("climat doit etre ajouté à la base");
				return listerClimat(model, request, session);
			}
			
		} catch (Exception e) {
			
			System.out.println("ERROR : "+e.getMessage());
		}
		
		return "ajouterClimat";
	}
	
	@RequestMapping("listerClimat")
	public String listerClimat(Model model, HttpServletRequest request, HttpSession session){
		
		List<Ferme> fermes= metier.FindAllFerme();
		List<Climatologie> climatologies= metier.findAllClimatologies();
		
		model.addAttribute("fermes", fermes);
		model.addAttribute("climatologies", climatologies);
		
		return "listerClimat";
	}
	
//	@RequestMapping(value="Synthese")
//	public String  synthese(Model model) {
//		
//		//Parcelles
//		long id_parce=1L;
//		List<Parcellaire> parcellaires= metier.GetParcesOfAFarm(id_parce);
//		model.addAttribute("Parcelles", parcellaires);
//		
//		return "synthese";
//	}
	
	@RequestMapping(value="EtatSynthese")
	public String etatSynthese(Model model, HttpServletRequest request, HttpSession session){
		
		List<Ferme> fermes= metier.FindAllFerme();
		
		Map<Long, List<Parcellaire>> result = new HashMap<Long, List<Parcellaire>>();
		
		for (Ferme f : fermes) {
			
			result.put(f.getId_Ferme(), metier.GetParcesOfAFarm(f.getId_Ferme()));
			
		}
		
		model.addAttribute("fermes", fermes);
		model.addAttribute("result", result);
		
		try {
			
			long id= Long.parseLong(request.getParameter("id"));
			System.out.println(id);
			//synthese(model, 1L);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "EtatSynthese";
	}
	
	@RequestMapping(value="listerFamilles")
	public String listerFamilles(Model model, HttpServletRequest request, HttpSession session){
		
		List<Famille> Familles= metier.FindALLFamilles();
		model.addAttribute("Familles", Familles);
		List<Activite> activites= metier.FindAllActivities();
		model.addAttribute("activites", activites);
		return "listerFamilles";
	}
	
	@RequestMapping(value="listerSousFamilles")
	public String listerSousFamilles(Model model, HttpServletRequest request, HttpSession session){
		
		List<Famille> Familles= metier.FindALLFamilles();
		model.addAttribute("Familles", Familles);
		
		List<SousFamille> SousFamilles= metier.FindAllSousFamilles();
		
		model.addAttribute("SousFamilles", SousFamilles);
		
		return "listerSousFamilles";
	}
	
	@RequestMapping(value="listerVareites")
	public String listerVareites(Model model, HttpServletRequest request, HttpSession session){
		
		List<Variete> Varietes= metier.findAllVarietes();
		model.addAttribute("Varietes", Varietes);
		List<SousFamille> sous= metier.FindAllSousFamilles();
		model.addAttribute("ss", sous);
		
		return "listerVarietes";
	}
	
	@RequestMapping(value="listerModes")
	public String listerModes(Model model, HttpServletRequest request, HttpSession session){
		
		List<ModeIrreguation> Modes= metier.findAllModeIrrigation();
		model.addAttribute("Modes", Modes);
		
		return "listerModes";
	}
	@RequestMapping(value="listerParcelles")
	public String listerParcelles(Model model, HttpServletRequest request, HttpSession session){
		
		List<Parcellaire> Parcelles=metier.findAllParcelles();
		
		for (Parcellaire p : Parcelles) {
			p.setS_net(p.getS_brute()-p.getS_inculte());
		}
		
		model.addAttribute("Parcelles", Parcelles);
		/*
		List<Occupation> occupations= metier.findAllOccupations();
		model.addAttribute("occupations", occupations);
		
		List<Ferme> fermes= metier.FindAllFerme();
		model.addAttribute("fermes", fermes);
		*/
		
		return "listerParcelles";
	}
	
	@RequestMapping(value="/menu")
	public String Menu(Model model, HttpServletRequest request, HttpSession session){
		
		return "menu";
	}
	@RequestMapping(value="/error404")
	public String Menu404(Model model, HttpServletRequest request, HttpSession session){
		
		return "error404";
	}
	@RequestMapping(value="/includeTest")
	public String includeTest(Model model, HttpServletRequest request, HttpSession session){
		
		return "includeTest";
	}
	
	@RequestMapping(value="/ajouterGroupe")
	public String ajouterGroupe(Model model, FamilleForm ff , HttpServletRequest request, HttpSession session){
		
		model.addAttribute("ff", new FamilleForm());
		
		try {
			if(ff.getSubmit().equals("AjouterGroupe")){
				ff.setSubmit(null);
				Groupe p= new Groupe();
				p.setDescription(ff.getDescription());
				p.setNom(ff.getLibelle());
				metier.add(p);
			 return	this.listerGroupe(model, request, session);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return "ajouterGroupe";
	}
	
	@RequestMapping(value="/ajoutModeIr")
	public String ajoutModeIr(Model model, FamilleForm ff , HttpServletRequest request, HttpSession session){
		
		model.addAttribute("ff", new FamilleForm());
		
		try {
			
			if(ff.getSubmit().equals("AjouterMode")){
				ff.setSubmit(null);
				ModeIrreguation mode= new ModeIrreguation();
				mode.setNom_mode(ff.getLibelle());
				mode.setDescription(ff.getDescription());
				metier.add(mode);
				return this.listerModes(model, request, session);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "ajoutModeIr";
	}
	@RequestMapping(value="/")
	public String Hello(Model model, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			return "home";
//		}
		//model.addAttribute("AdminForm",new AdminForm());
		return "home"; 
		
	}
	
	@RequestMapping(value="/index")
	public String index(Model model, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			return "home";
//		}
		//model.addAttribute("AdminForm",new AdminForm());
		return "test"; 
		
	}
	
	@RequestMapping(value="/ajoutFerme")
	public String ajoutFerme(Model model , FermeForm fff , HttpServletRequest request, HttpSession session){
		
		model.addAttribute("fff", new FermeForm());
		List<Ferme> lis=metier.FindAllFerme();
		List<Groupe> groupes=metier.FindAllGroupe();
		model.addAttribute("lis", lis);
		model.addAttribute("groupes", groupes);
		
		for (Ferme ferme : lis) {
			System.out.println("la ferme dont l id est  :"+ferme.getId_Ferme()+" est sectionné ");
		}
		
		try {
			System.out.println("submit : "+fff.getSubmit());
			if(fff.getSubmit().equals("AjouterFerme")){
				fff.setSubmit(null);
				Ferme f = new Ferme();
				f.affect(fff);
				Groupe g= metier.FindGroupeById(fff.getGroupe());
				try {
					metier.add(f, g); //might throw exception
				} catch(JDBCException e) {
				    SQLException cause = (SQLException) e.getCause();
				   System.out.println(e.getMessage());
				   System.out.println(cause.getMessage());
				}
				
				System.out.println("ajouté à base !");
				return	this.afficherFerme(model, new FermeForm(), request, session);
			}
				
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return "ajoutFerme";
	}
	
	@RequestMapping(value="/afficherFerme")
	public String afficherFerme(Model model, FermeForm ff ,HttpServletRequest request, HttpSession session){
		
	
		
		List<Ferme> lis=metier.FindAllFerme();
		model.addAttribute("lis", lis);
		System.out.println(lis.size());
		
		return "afficherFerme";
	}
	
	@RequestMapping(value="/coorMaps")
	public String coormaps(Model model, HttpServletRequest request, FermeForm ff, HttpSession session ){
		model.addAttribute("ff", new FermeForm());
		System.out.println("dans le controlleur de coorMaps1 ");
		try {
				
				System.out.println("INFO / dans le premier bloc");
				System.out.println("le prob est là : "+ff.getId_Ferme());
				Ferme f= metier.FindFermeById(ff.getId_Ferme());
				List<Personnel> persos= metier.FindAllPersonnel();
				System.out.println("nombre de personnel importés : "+persos.size());
				
				model.addAttribute("persos", persos);
//				String j="";
				if(f==null) {
					System.out.println("ERROR : la ferme est nulle ");
				}
				else{
					System.out.println(f.toString());
//					List<CoordonnesGPS> path=f.getPolygoneMaps_ferme();
//					if(! path.isEmpty() )
//					j= new Gson().toJson(path);
					session.setAttribute("la_ferme", f);
					model.addAttribute("la_ferme", f);
//					model.addAttribute("pathJSON",j);
					return "coorMaps";
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("dans le controlleur de coorMaps ");
//		Ferme f= (Ferme) session.getAttribute("la_ferme");
//		model.addAttribute("la_ferme", f);
		
//		String jsn = "[{ \"polygone\" : 1, \"coor\" : [ { \"latitude\" : 32.373814500410674, \"longitude\" : 50.9326171875 }, { \"latitude\" : 32.40454514250404, \"longitude\" : 51.036643981933594 }, { \"latitude\" : 32.366275199118654, \"longitude\" : 51.17431640625 }, { \"latitude\" : 32.31087105996962, \"longitude\" : 51.17500305175781 }, { \"latitude\" : 32.28330140023841, \"longitude\" : 51.05792999267578 }, { \"latitude\" : 32.34655405378273, \"longitude\" : 50.923004150390625 } ], \"polygone\" : 2, \"coor\" : [ { \"latitude\" : 32.348004284474804, \"longitude\" : 50.99510192871094 }, { \"latitude\" : 32.37990347696167, \"longitude\" : 51.00505828857422 }, { \"latitude\" : 32.37120481343642, \"longitude\" : 51.091575622558594 }, { \"latitude\" : 32.31580369339529, \"longitude\" : 51.080589294433594 }, { \"latitude\" : 32.315223397521486, \"longitude\" : 50.99098205566406 } ], \"polygone\" : 3, \"coor\" : [ { \"latitude\" : 32.38976094999714, \"longitude\" : 50.98411560058594 }, { \"latitude\" : 32.37352453891251, \"longitude\" : 50.99647521972656 }, { \"latitude\" : 32.329149472333356, \"longitude\" : 50.987205505371094 }, { \"latitude\" : 32.32595826935125, \"longitude\" : 50.96626281738281 }, { \"latitude\" : 32.34655405378273, \"longitude\" : 50.92266082763672 }, { \"latitude\" : 32.374104460978494, \"longitude\" : 50.932960510253906 } ] } ]";
//				
////		JsonParser jsonParser = new JsonParser();
////        JsonObject jo = (JsonObject)jsonParser.parse(jsn);
////        
////        JsonArray jsonArr = jo.getAsJsonArray("coor");
//        //jsonArr.
//        try {
//        	Gson googleJson = new Gson();
//        	TypeToken<List<TestPoly>> token = new TypeToken<List<TestPoly>>(){};
//        	
//        	TestPoly polyList = googleJson.fromJson(jsn, token.getType());
//        	
//        	System.out.println(polyList);
//        	//Ferme f= metier.FindFermeById(1L);
//        	//f.setPolygoneMaps_ferme(polyList.coor);
//        	//metier.update(f);
//        	
//        	
//            //TestPoly jsonObjList = googleJson.fromJson(jsn, TestPoly.class);
//           // System.out.println(jsonObjList.toString());
////            System.out.println("List size is : "+jsonObjList.size());
////                    System.out.println("List Elements are  : "+jsonObjList.toString());
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
		return"coorMaps";
	}
	@RequestMapping(value="ModifierFerme")
	public String ModifierFerme(Model model, HttpServletRequest request, FermeForm ff, HttpSession session){
		model.addAttribute("ff", new FermeForm());
		if(ff.getSubmit().equals("Modifier")){
			ff.setSubmit(null);
			System.out.println(ff);
			Ferme f= metier.FindFermeById(ff.getId_Ferme());
			f=f.affect1(ff);
			Personnel p= metier.FindPersonnelById(ff.getGerant());
			Groupe g= metier.FindGroupeById(ff.getGroupe());
			f.setGerant(p);
			f.setGroupe(g);
			metier.update(f);
			System.out.println("nomralment la ferme est mise à jour");
		}
		return coormaps(model, request, ff, session);
	}
	
	@RequestMapping(value="/ajouterParce")
	public String ajoutParce(Model model, HttpServletRequest request, FermeForm ff, ParcellaireFomr pf , HttpSession session ){
		
		model.addAttribute("pf", new ParcellaireFomr());
		System.out.println("dans l'ajout de Parcelaire ....");
		try {
			if (pf.getSubmit().equals("Ajouter") ){
			
				System.out.println("heeeere ");
				
				System.out.println("ParcellaireForm contient :"+pf.toString());
				pf.setSubmit(null);
				Parcellaire p= new Parcellaire();
				p= pf.affect(pf);
				Ferme f= metier.FindFermeById(pf.getId_ferme());
				List<Parcellaire> parcelaires=metier.GetParcesOfAFarm(pf.getId_ferme());
				if(pf.getTypeParcelaire()==1){
					ModeIrreguation mode=metier.findModeIrrigationById(pf.getModeIr());
					ParcellaireIrregue pi=new ParcellaireIrregue(p);
					pi.setMode(mode);
					pi.setFerme(f);
					parcelaires.add(pi);
					metier.UpdateParecellaireOfAFarm(parcelaires, f.getId_Ferme());
				}
				else{
				p.setFerme(f);
				parcelaires.add(p);
				metier.UpdateParecellaireOfAFarm(parcelaires, f.getId_Ferme());
				}
				System.out.println("Normalement Ajout terminé avec succés");
				
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		try {
				
				System.out.println("la ferme est  : "+pf.getId_ferme());
				
				List<ModeIrreguation> modes= metier.findAllModeIrrigation();
				
				if(modes==null) {
					System.out.println("ERROR : la ferme est nulle ");
				}
				else{
					
					
					
					List<Ferme > fermes= metier.FindAllFerme();
					
					model.addAttribute("fermes", fermes);
					
					model.addAttribute("modes", modes);
					
					//return "ajouterParce";
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("dans le controlleur de ajouterParce ");

		return"ajouterParce";
	}
	
	@RequestMapping(value="/Plantation_Reculte")
	public String Plantation_Reculte(Model model, HttpServletRequest request, OccupationForm of ,HttpSession session, ParcellaireFomr pf){
		model.addAttribute("of", new OccupationForm());
		model.addAttribute("pf", new ParcellaireFomr());
		List<Famille> familles= metier.FindALLFamilles();
		model.addAttribute("fam", familles);
		try {
			//Plantation_Reculte
			if (session.getAttribute("page").equals("Plantation_Reculte") && of.getSubmit().equals("ajouter") ){
				of.setSubmit(null);
			//	Famille f= metier.FindFamilleById(of.getFamille());
			//	SousFamille s= metier.findSousFamillebyId(of.getSousfamille());
				Variete v = metier.FindVarieteById(of.getVariete());
			if(of.getMode().equals("p")){
				Plantation p= new Plantation();
				p=p.affect(of);
				//p.setFamille(f); p.setSousFamille(s); 
				p.setVariete(v);
				metier.add(metier.findParcellaireById(5L),p);
			}
			if(of.getMode().equals("c")){
				Culture p= new Culture();
				p=p.affect(of);
				//p.setFamille(f); p.setSousFamille(s); 
				p.setVariete(v);
				metier.add(metier.findParcellaireById(of.getId_parce()),p);
			}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "Plantation_Reculte";
	}
	@RequestMapping(value="/CoorMapParce")
	public String CoorMapParce(Model model, HttpServletRequest request, HttpSession session, ParcellaireFomr pf){
		model.addAttribute("pf", new ParcellaireFomr());
		List<Ferme> fermes= metier.FindAllFerme();
		List<ModeIrreguation> modes=metier.findAllModeIrrigation();
		List<Famille> familles = metier.FindALLFamilles();
		
		model.addAttribute("fermes", fermes);
		model.addAttribute("modes", modes);
		model.addAttribute("familles", familles);
		
		try {
				
				System.out.println("INFO / dans le premier bloc");
				System.out.println("le prob est là : "+pf.getParcelle_id());
				System.out.println("l id de la parcelle est : "+ pf.getParcelle_id());
				Parcellaire p= metier.findParcellaireById( pf.getParcelle_id());
				if(p!=null);
				 Occupation o = null;
				if(p.getOccupation()!=null)
				o= metier.findOccupationByParcelle(p.getId_parce());
				
				model.addAttribute("occupation", o);
				Ferme f= p.getFerme();
				model.addAttribute("ferme", f);
				
				//System.out.println(f.toString());
				
				model.addAttribute("parce", p);

				return "CoorParcelle";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	

		
		return "CoorParcelle";
	}
	
	@RequestMapping("/admin/ajouterActivite")
	public String ajouterActivite(Model model, FamilleForm ff , HttpServletRequest request, HttpSession session ){
		model.addAttribute("ff", new FamilleForm());
		
		try {
			if (session.getAttribute("page").equals("ajouterActivite") && ff.getSubmit().equals("ajouter") ){
				ff.setSubmit(null);
			Activite v = new Activite().affect(ff);
			metier.add(v);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("here ");
		}
		
		return "ajouterActivite";
	}
	
	
	@RequestMapping("/ajouterFamille")
	public String ajouterFamille(Model model, HttpServletRequest request, FamilleForm ff , HttpSession session ){
		model.addAttribute("ff", new FamilleForm());
		List<Activite> activites= metier.FindAllActivities();
		System.out.println("je suis dans le controlleur de ajouterFamille");
		System.out.println(ff.getSubmit()+"  "+ff.getLibelle()+" "+session.getAttribute("page"));
		model.addAttribute("activites", activites);
		try {
			
			if ( ff.getSubmit().equals("ajouter") ){
				System.out.println(ff.getSubmit());
				ff.setSubmit(null);
				System.out.println("voici l id de l activité : "+ ff.getEntite());
				Famille f= new Famille().affect(ff);
				Activite a= metier.FindActiviteById(ff.getEntite());
				
				//metier.add(f);
				metier.add(f, a);
				System.out.println("here");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "ajouterFamille";
	}
	
	@RequestMapping("/ajouterSousFamille")
	public String ajouterSousFamille(Model model, HttpServletRequest request, FamilleForm ff , HttpSession session ){
		model.addAttribute("ff", new FamilleForm());
		List<Famille> familles= metier.FindALLFamilles();
		model.addAttribute("familles", familles);
		try {
			if (session.getAttribute("page").equals("ajouterSousFamille") && ff.getSubmit().equals("ajouter") ){
				ff.setSubmit(null);
				System.out.println("here 3 ");
				SousFamille s= new SousFamille().affect(ff);
				Famille f =metier.FindFamilleById(ff.getEntite());
				metier.add(s,f);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "ajouterSousFamille";
	}
	
	@RequestMapping("/ajouterProduit")
	public String ajouterProduit(Model model, ParcellaireFomr pf , HttpServletRequest request, HttpSession session){
		List<CategorieProduit> categories= metier.FindAllCategorieProduit();
		model.addAttribute("categories", categories);
		try {
			
			if ( pf.getSubmit().equals("Ajouter") ){
				System.out.println(pf.getSubmit());
				pf.setSubmit(null);
				System.out.println("voici l id de l activité : "+ pf.getId_ferme()); //id_Ferme === id_Categorie
				CategorieProduit c= metier.FindCategorieProduitById(pf.getId_ferme());
				Produit p= new Produit();
				p.setPu(pf.getS_inculte()); //s_inculte === prix unitaire
				p.setCMUPunitare(0.0);
				p.setLibelle(pf.getLibelle());
				p.setDescreption(pf.getMode());  // mode === description
				p.setQuantiteEnStock(0.0);  
				p.setQuantiteMinAuStock(pf.getS_brute()); // s_incule === quantité Minimal au stock 
				//metier.add(f);
				metier.add(p,c);
				System.out.println("here");
				return "listerProduits";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ajouterProduit";
	}
	
	@RequestMapping("/listerProduits")
	public String listerProduits(Model model, HttpServletRequest request, HttpSession session){
		List<Produit> produits= metier.FindAllProduit();
		model.addAttribute("produits", produits);
		return "listerProduits";
	}
	
	@RequestMapping("/ajouterVariete")
	public String ajouterVariete(Model model, HttpServletRequest request, FamilleForm ff , HttpSession session ){
		model.addAttribute("ff", new FamilleForm());
		List<SousFamille> sous= metier.FindAllSousFamilles();
		model.addAttribute("ss", sous);
		try {
			if (session.getAttribute("page").equals("ajouterVariete") && ff.getSubmit().equals("ajouter") ){
				ff.setSubmit(null);
				System.out.println("here 3 ");
				Variete v= new Variete().affect(ff);
				SousFamille s= metier.findSousFamillebyId(ff.getEntite());
				metier.add(v, s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "ajouterVariete";
	}
	
	@RequestMapping(value="/login")
	public String login(Model model, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			return "home";
//		}
//		Admin a = new Admin();
//		a.setLogin(af.getLogin());
//		a.setMotpass(af.getMotpass());
//		try {
//			a=metier.logIn(a);
//			af.setAdmin(a);
//			model.addAttribute("AdminForm",af);
//			session.setAttribute("Admin", a);
//			return "home";
//		} catch (Exception e) {
//			af.setException(e.getMessage());
//			model.addAttribute("AdminForm",af);
//			return "connexion"; 
//		}
		return "connexion";
	}
//	
////	ajout -----------------------------------------------------------------
//	
//	@RequestMapping(value="/ajoutEmp")
//	public String ajoutEmp(Model model,EmployeForm ef, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			model.addAttribute("EmpForm",new EmployeForm());
//			try {
//				if (session.getAttribute("page").equals("ajoutEmp") && ef.getSubmit().equals("Ajouter") ){
//					
//					ef.setSubmit(null);
//					ef.setEmployeSup(1L);
//					Employe e = new Employe();		
//					e.affect(ef);
//					
//					e=metier.addEmplye(e);
//					
//					session.setAttribute("page", "home");
//					model.addAttribute("msg","oktest");
//					return "home";
//				}
//			} catch (Exception e) {
//				List<Departement> listDept = metier.getAllDepartements();
//				model.addAttribute("listDept", listDept);
//				return "ajoutEmploye";
//			}
//			List<Departement> listDept = metier.getAllDepartements();
//			model.addAttribute("listDept", listDept);
//			return "ajoutEmploye";
//		}else {
//			model.addAttribute("AdminForm",new AdminForm());
//			return "connexion"; 
//		}
//	}
//	
//	@RequestMapping(value="/ajoutDept")
//	public String ajoutDept(Model model,DepartementForm df, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			model.addAttribute("DeptForm",new DepartementForm());
//			try {
//				if (session.getAttribute("page").equals("ajoutDept") && df.getSubmit().equals("Ajouter") ){
//					df.setSubmit(null);
//					Departement d = new Departement();		
//					d.affect(df);
//					d=metier.addDepartement(d);
//					session.setAttribute("page", "home");
//					model.addAttribute("msg","ok");
//					return "home";
//				}
//			} catch (Exception e) {
//				List<Employe> listEmp = metier.getAllAmployes();
//				model.addAttribute("listEmp", listEmp);
//				return "ajoutDepartement";
//			}
//			List<Employe> listEmp = metier.getAllAmployes();
//			model.addAttribute("listEmp", listEmp);
//			return "ajoutDepartement";
//		}else {
//			model.addAttribute("AdminForm",new AdminForm());
//			return "connexion"; 
//		}
//	}
//	
//	@RequestMapping(value="/ajoutAdmin")
//	public String ajoutAdmin(Model model,AdminForm af, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			model.addAttribute("AdminForm",new AdminForm());
//			
//			try {
//				if (session.getAttribute("page").equals("ajoutAdmin") && af.getSubmit().equals("Ajouter") ){
//					af.setSubmit(null);
//					Admin a = new Admin();	
//					
//					a.affect(af);
//					a=metier.addAdmin(a);
//					
//					session.setAttribute("page", "home");
//					model.addAttribute("msg","ok");
//					return "home";
//				}
//			} catch (Exception e) {
//				model.addAttribute("AdminForm",new AdminForm());
//				return "ajoutAdmin";
//			}
//			model.addAttribute("AdminForm",new AdminForm());
//			return "ajoutAdmin";
//		}else {
//			model.addAttribute("AdminForm",new AdminForm());
//			return "connexion"; 
//		}
//	}
//
////	List ----------------------------------------------------------------------------------------
//	
//	@RequestMapping(value="/listEmp")
//	public String listEmp(Model model,EmployeForm ef, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			
//			List<Employe> listEmp = metier.getAllEmployes(true);
//			model.addAttribute("EmpForm", new EmployeForm());
//			model.addAttribute("listEmp", listEmp);
//			return "listEmploye";
//		}
//		model.addAttribute("AdminForm",new AdminForm());
//		return "connexion"; 
//		
//	}
//	
//	@RequestMapping(value="/listDept")
//	public String listDept(Model model,DepartementForm df, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			model.addAttribute("DeptForm",new EmployeForm());
//			
//			List<Departement> depts=metier.getAllDepartements();
//			model.addAttribute("depts", depts);
//			return "listDepartement";
//		}
//		model.addAttribute("AdminForm",new AdminForm());
//		return "connexion"; 
//		
//	}
//	
////	affiche-----------------------------------------------------------------------
//	
//	@RequestMapping(value="/AfficheDept")
//	public String AfficheDept(Model model,DepartementForm df, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			Departement d = new Departement();
//			d.setCodeDept(df.getCodeDept());
//			d = metier.findDepartement(d);
//			
//			List<Employe> listEmp = metier.getEmployesByDepartement(true, d);
//			model.addAttribute("EmpForm", new EmployeForm());
//			model.addAttribute("listEmp", listEmp);
//			model.addAttribute("dept",d);
//			return "afficheDepartement";
//		}
//		model.addAttribute("AdminForm",new AdminForm());
//		return "connexion"; 
//		
//	}
//	
//	////////////////
//	@RequestMapping(value="/AfficheEmp")
//	public String AfficheEmp(Model model,EmployeForm ef, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			
//			
//			//List<Employe> listEmp = metier.getEmployesByDepartement(true, d);
//			//model.addAttribute("listEmp", listEmp);
//			
//			model.addAttribute("EmpForm", new EmployeForm());
//			return "afficheDepartement";
//		}
//		model.addAttribute("AdminForm",new AdminForm());
//		return "connexion"; 
//		
//	}
//	
////	gestion absence--------------------------------------------------------------------------------------
//	
//	@RequestMapping(value="/validationAbsence")
//	public String validationAbsence(Model model, HttpServletRequest request, HttpSession session){
//		String jf = request.getParameter("jf");
//		String req = request.getParameter("req");
//		//req.substring(0, req.length()-1);
//		StringTokenizer st = new StringTokenizer(req, "/");
//		String gestion;
//		Absence a = new Absence();
//		Retard r = new Retard();
//		HeursSuplementaire h = new HeursSuplementaire();
//		Employe e = new Employe();
//		Long codeEmp;
//		int hs1=0,hs2=0,hs3=0,hd,hf;
//		while (st.hasMoreTokens()){
//			gestion=st.nextToken();
//			String[] attrs = gestion.split("-");
//			codeEmp=Long.parseLong(attrs[0]);
//			hd=Integer.parseInt(attrs[2]);
//			hf=Integer.parseInt(attrs[3]);
//			if (attrs[1].equals("A")){
//				a = new Absence();
//				e.setCodeEmp(codeEmp);
//				a.setEmploye(e);
//				a.setDateGestion(new Date());
//				a.setEtat(attrs[5]);
//				a.setRaison(attrs[4]);
//				metier.addAbsence(e, a);
//				
//			}
//			else if (attrs[1].equals("R")){
//				r = new Retard();
//				e.setCodeEmp(codeEmp);
//				r.setEmploye(e);
//				r.setDateGestion(new Date());
//				r.setHeureDebut(new Time(hd, 0, 0));
//				r.setHeureFin(new Time(hf, 0, 0));
//				r.setHeureRetard(Integer.parseInt(attrs[3])-Integer.parseInt(attrs[2]));
//				r.setEtat(attrs[5]);
//				r.setRaison(attrs[4]);
//				metier.addRetard(e, r);
//				
//				
//			}else if (attrs[1].equals("S")){
//				h = new HeursSuplementaire();
//				e.setCodeEmp(codeEmp);
//				h.setEmploye(e);
//				h.setDateGestion(new Date());
//				h.setHeureDebut(new Time(hd, 0, 0));
//				h.setHeureFin(new Time(hf, 0, 0));
//				
//				if (hd>=9 && hd<21 && hf>=9 && hf<21){
//					hs1= hf-hd;
//				}else if (hd>=9 && hd<21 && hf>=21){
//					hs1=21-hd;
//					hs2=hf-21;
//				}else if (hf>=9 && hf<21 && hd<9){
//					hs1=hf-9;
//					hs2=9-hd;
//				}else if ((hd>=21 && hf>=21) || (hd<9 && hf<9)){
//					hs2=hf-hd;
//				}else if (hd<9 && hf>=21){
//					hs1=12;
//					hs2=(hf-21)+(9-hd);
//				}
//				if (jf.equals("t")){
//					hs3=hs2;
//					hs2=hs1;
//					hs1=0;
//				}
//				h.setHeureSup1(hs1);
//				h.setHeureSup2(hs2);
//				h.setHeureSup3(hs3);
//				h.setEtat(attrs[5]);
//				h.setRaison(attrs[4]);
//				metier.addHeursSuplementaire(e, h);
//			}
//			
//			
//			//System.out.println("code :"+attrs[0]+" ars :"+attrs[1]+" hd :"+attrs[2]+" hf :"+attrs[3]+" raison :"+attrs[4]+" etat :"+attrs[5]);
//		}
//		
//		return ""; 
//	}
//	
//	@RequestMapping(value="/gestionAbsence")
//	public String gestionAbsence(Model model, DepartementForm df, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			model.addAttribute("DeptForm",new DepartementForm());
//			try {
//				if (session.getAttribute("page").equals("gestionAbsence") && df.getSubmit().equals("valider") ){
//					df.setSubmit(null);
//					session.setAttribute("page", "home");
//					model.addAttribute("msg","ok");
//					return "home";
//				}
//			} catch (Exception e) {
//				List<Employe> listEmp = metier.getAllAmployes();
//				List<Departement> listDept = metier.getAllDepartements();
//				model.addAttribute("listDept", listDept);
//				model.addAttribute("listEmp", listEmp);
//				return "gestionAbsence";
//			}
//			List<Employe> listEmp = metier.getAllAmployes();
//			List<Departement> listDept = metier.getAllDepartements();
//			model.addAttribute("listDept", listDept);
//			model.addAttribute("listEmp", listEmp);
//			return "gestionAbsence";
//		}else {
//			model.addAttribute("AdminForm",new AdminForm());
//			return "connexion"; 
//		}
//	}
//	
////	update-------------------------------------------------------------------------------
//	
//	@RequestMapping(value="/updateEmp")
//	public String updateEmp(Model model,EmployeForm ef, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			model.addAttribute("EmpForm",new EmployeForm());
//			try {
//				if (session.getAttribute("page").equals("updateEmp") && ef.getSubmit().equals("Modifier") ){
//					
//					ef.setSubmit(null);
//					Employe e = new Employe();
//					
//					e.affect(ef);
//					e.setCodeEmp(ef.getCodeEmp());
//					
//					metier.update(e);
//					
//					session.setAttribute("page", "home");
//					model.addAttribute("msg","ok");
//					return "home";
//				}
//			} catch (Exception e) {
//				List<Departement> listDept = metier.getAllDepartements();
//				model.addAttribute("listDept", listDept);
//				Employe emp = new Employe();
//				emp.setCodeEmp(ef.getCodeEmp());
//				emp = metier.findEmloye(emp);
//				model.addAttribute("emp", emp);
//				return "updateEmploye";
//			}
//			List<Departement> listDept = metier.getAllDepartements();
//			model.addAttribute("listDept", listDept);
//			Employe emp = new Employe();
//			emp.setCodeEmp(ef.getCodeEmp());
//			emp = metier.findEmloye(emp);
//			model.addAttribute("emp", emp);
//			return "updateEmploye";
////			List<Employe> listEmp = metier.getAllAmployes();
////			List<Departement> listDept = metier.getAllDepartements();
////			model.addAttribute("listDept", listDept);
////			model.addAttribute("listEmp", listEmp);
////			return "updateEmploye";
//		}else {
//			model.addAttribute("AdminForm",new AdminForm());
//			return "connexion"; 
//		}
//	}
//
//	@RequestMapping(value="/updateDept")
//	public String updateDept(Model model,DepartementForm df, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			model.addAttribute("DeptForm",new EmployeForm());
//			try {
//				if (session.getAttribute("page").equals("updateDept") && df.getSubmit().equals("Modifier") ){
//					df.setSubmit(null);
//					Departement d = new Departement();
//					d.affect(df);
//					d.setCodeDept(df.getCodeDept());
//					metier.updateDepartement(d);
//					session.setAttribute("page", "home");
//					model.addAttribute("msg","ok");
//					return "home";
//				}
//			} catch (Exception e) {
//				try {
//					Departement d = new Departement();
//					d.setCodeDept(df.getCodeDept());
//					d = metier.findDepartement(d);
//					List<Employe> listEmp = metier.getAllAmployes();
//					model.addAttribute("listEmp", listEmp);
//					model.addAttribute("dept",d);
//					return "updateDepartement";
//				} catch (Exception e2) {
//					model.addAttribute("DeptForm",new EmployeForm());
//					List<Departement> depts=metier.getAllDepartements();
//					model.addAttribute("depts", depts);
//					return "listDepartement";				
//					}
//			}
//			try {
//				Departement d = new Departement();
//				d.setCodeDept(df.getCodeDept());
//				d = metier.findDepartement(d);
//				List<Employe> listEmp = metier.getAllAmployes();
//				model.addAttribute("listEmp", listEmp);
//				model.addAttribute("dept",d);
//				return "updateDepartement";
//			} catch (Exception e2) {
//				model.addAttribute("DeptForm",new EmployeForm());
//				List<Departement> depts=metier.getAllDepartements();
//				model.addAttribute("depts", depts);
//				return "listDepartement";				
//				}
//		}else {
//			model.addAttribute("AdminForm",new AdminForm());
//			return "connexion"; 
//		}
//	}
//		
//	@RequestMapping(value="/updateEntr")
//	public String updateEntr(Model model,EntrepriseForm ef, HttpServletRequest request, HttpSession session){
//		if (logedin(session)){
//			model.addAttribute("EntrForm",new EntrepriseForm());
//			try {
//				if (session.getAttribute("page").equals("updateEntr") && ef.getSubmit().equals("Modifier") ){
//					ef.setSubmit(null);
//					Entreprise entr = new Entreprise();
//					entr.affect(ef);
//
//					metier.updateEntreprise(entr);
//					session.setAttribute("page", "home");
//					model.addAttribute("msg","ok");
//					return "home";
//				}
//			} catch (Exception e) {
//				Entreprise entr = new Entreprise();
//				entr.setCodeEntrp(1L);
//				entr = metier.findEntreprise(entr);
//				model.addAttribute("EntrForm", new EntrepriseForm());
//				model.addAttribute("Entr",entr);
//				return "updateEntreprise";
//			}
//			Entreprise entr = new Entreprise();
//			entr.setCodeEntrp(1L);
//			entr = metier.findEntreprise(entr);
//			model.addAttribute("EntrForm", new EntrepriseForm());
//			model.addAttribute("Entr",entr);
//			return "updateEntreprise";
//		}else {
//			model.addAttribute("AdminForm",new AdminForm());
//			return "connexion"; 
//		}
//	}
//	
//	@RequestMapping(value="/updateAdmin")
//	public String updateAdmin(Model model){
//		model.addAttribute("AdminForm",new AdminForm());
//		List<Employe> listEmp = metier.getAllAmployes();
//		List<Departement> listDept = metier.getAllDepartements();
//		model.addAttribute("listDept", listDept);
//		model.addAttribute("listEmp", listEmp);
//		return "updateAdmin"; 
//	}
//
//	
//	
////	logout--------------------------------------------------------------------
//	
//	@RequestMapping(value="/logout")
//	public String logout(Model model,AdminForm af, HttpServletRequest request, HttpSession session){
//		model.addAttribute("AdminForm",af);
//		session.setAttribute("Admin", null);
//		return "connexion";	
//	}
//	
//	boolean logedin(HttpSession session){
//		try {
//			if (!session.getAttribute("Admin").equals(null)) return true;
//		} catch (Exception e) {
//			return false;
//		}
//		 return false;
//	}
////	@RequestMapping(value="/pdfs")
////	public String pdfs(Model model, HttpServletRequest request, HttpSession session){
////		if (logedin(session)){
////			System.out.println("kk");
////			/***********************************************************************************/
////				List<Employe> lis=metier.getAllAmployes();
////				List<BulletinDePaieGenPDF> pdfs= new ArrayList<BulletinDePaieGenPDF>();
////				
////				for (Employe emp : lis) {
////					
////					BulletinDePaieGenPDF pdf;
////					try {
////						pdf = new BulletinDePaieGenPDF(emp);
////						pdfs.add(pdf);
////					} catch (BadElementException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					} catch (MalformedURLException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					} catch (IOException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
////					
////					System.out.println(emp.getNom());
////				}
////			model.addAttribute("pdfs",pdfs);
////			//return "pdf";
////			System.out.println("fiche de paie est gÃ©nÃ©rÃ©e avec succes ...");
////			/***********************************************************************************/
////		/*	try {
////				String jpdf= new JournalDePaieGenPDF().JournalDePaieGenPDFMethode(metier.getAllAmployes());
////				
////				ArrayList<String> j=new ArrayList<String>();
////				j.add(jpdf);
////				model.addAttribute("jpdf", j);
////				return "pdf";
////			} catch (BadElementException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////				return "pdf";
////			} catch (MalformedURLException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////				return "pdf";
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				
////				e.printStackTrace();
////				return "pdf";
////			} */
////			
////			/******************************************************************************/
////			
////			
////			DeclarationMensCnssGenPdf pdf;
////			try {
////				pdf = new DeclarationMensCnssGenPdf();
////				try {
////					String s= pdf.creerLeFichier();
////					List<String> lisDec= new ArrayList<String>();
////					lisDec.add(s);
////					model.addAttribute("lisDec",lisDec);
////				} catch (DocumentException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////			} catch (BadElementException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			} catch (MalformedURLException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			
////			
////			return "pdf";
////			
////		}
////		model.addAttribute("AdminForm",new AdminForm());
////		return "connexion"; 
////		
////	}
////	
////	
////	
////	
////	
////	
////	
////	
////	@RequestMapping(value="/DeptSel")
////	public String DeptSel(Model model,EmployeForm ef, HttpServletRequest request, HttpSession session){
////		String req = request.getParameter("req");
////		Departement d = new Departement();
////		d.setDescription("eeeeeeeeee");
////		d.setNom("safi");
////		d.setVille("virrr");
////		model.addAttribute("dept",d);
////		return "updateDepartement";
////		
////	}
////	
////	
////	
////	
////	
////	
////
////
////
////

	
	
	
	
}
