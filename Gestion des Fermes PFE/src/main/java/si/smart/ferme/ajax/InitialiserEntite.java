package si.smart.ferme.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import si.smart.ferme.entities.Activite;
import si.smart.ferme.entities.Climatologie;
import si.smart.ferme.entities.Culture;
import si.smart.ferme.entities.Famille;
import si.smart.ferme.entities.Ferme;
import si.smart.ferme.entities.Groupe;
import si.smart.ferme.entities.ModeIrreguation;
import si.smart.ferme.entities.Occupation;
import si.smart.ferme.entities.Parcellaire;
import si.smart.ferme.entities.ParcellaireBour;
import si.smart.ferme.entities.ParcellaireIrregue;
import si.smart.ferme.entities.Plantation;
import si.smart.ferme.entities.SousFamille;
import si.smart.ferme.entities.Variete;
import si.smart.ferme.metier.Metier;

/**
 * Servlet implementation class InitialiserEntite
 */
public class InitialiserEntite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitialiserEntite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		Metier metier = (Metier) ctx.getBean("metier");
		System.out.println("initalisation ioazugdoiazudgioziaudg ..........");
		String idS=request.getParameter("id");
		String entite= request.getParameter("entite");
		System.out.println("I get From client : "+ entite+ " : "+ idS );
		long id= Long.parseLong(idS);
		
		//System.out.println(entite);
		
		if(entite.equals("Activite")){
			Activite a = metier.FindActiviteById(id);
			//Activite a= new Activite("testAjax", "testAjaw kdezpodjzpidj ");
			String res = a.getLibelle()+":"+a.getObservation();
			System.out.println(res);
			response.getWriter().println(res);
		}
		
		if(entite.equals("Groupe")){
			Groupe g= metier.FindGroupeById(id);
			//Activite a= new Activite("testAjax", "testAjaw kdezpodjzpidj ");
			String res = g.getNom()+":"+g.getDescription();
			System.out.println(res);
			response.getWriter().println(res);
		}
		
		
		
		if(entite.equals("Famille")){
			System.out.println(entite);
		
			Famille f= metier.FindFamilleById(id);
			 long a=-1 ;
			 System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeere");
			 if(f.getActivite()!=null)
			 a= f.getActivite().getId() ;
			 System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeere2");
			String res= a + ":"+ f.getLibelle()+":"+f.getDescription();
			System.out.println(res);
			response.getWriter().println(res);
		
	}

		if(entite.equals("Mode")){
			
			ModeIrreguation mode= metier.findModeIrrigationById(id);
			String res= mode.getNom_mode()+":"+mode.getDescription();
			response.getWriter().println(res);
			
		}
		
		if(entite.equals("Sous")){
			
			SousFamille s= metier.findSousFamillebyId(id);
			String res= s.getFamille().getId()+":"+s.getLibelle();
			
			System.out.println(res);
			response.getWriter().println(res);
		
	}
		
	if(entite.equals("Parcelle")){
			
			Parcellaire p = metier.findParcellaireById(id);
			String res= p.getLibelle()+":";
			System.out.println(res);
		    res+="bour/irrigé";
			res+=":";
			System.out.println(res);
			res+=p.getS_brute()+":";System.out.println(res);
			res+=p.getS_inculte()+":";System.out.println(res);
			res+=p.getS_net()+":";System.out.println(res);
			res+=p.getFerme().getNom_Ferme()+":";System.out.println(res);
			//res+=p.getOccupation().getVariete();System.out.println(res);
			System.out.println(res);System.out.println(res);
			response.getWriter().println(res);
		
	}
	
	
	
	
	if(entite.equals("Occupation")){
		Occupation o=  metier.findOccupationByParcelle(id);
		System.out.println(o.getClass().getSimpleName());
		response.getWriter().println(o.getClass().getSimpleName());
	/*	System.out.println("heeere 100");
		//Plantation o= (Plantation) metier.findOccupationByParcelle(id);
		Culture c= (Culture) metier.findOccupationByParcelle(id);
		System.out.println("heeere 0");
		String res="";
		if(c != null){
			Plantation p= new Plantation(o);
			res+=c.getOrdrevariete()+":";
			res+=c.getVariete().getNom()+":";
			System.out.println("heeere 1");
			try {
				System.out.println("heeere 4");
				res+=o.getAnnePlantation()+":";
				res+=o.getNbrArbres()+":";
				res+=o.getEcartX()+":";
				res+=o.getEcartY()+":"; 
				System.out.println("heeere 3");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			System.out.println("heeere 5");
			res+=c.getRemarque()+":";
			System.out.println(res);
			response.getWriter().println(res);*/
		}
	
	

	
	if(entite.equals("Variete")){
			System.out.println(entite);
			Variete v = metier.FindVarieteById(id);
			String res= v.getSousfamille().getId()+":"+v.getNom()+":"+v.getAgeAdulte()+":";
			System.out.println(res);
			response.getWriter().println(res);
		
	}
		
	if(entite.equals("Climat")){
		
		Climatologie c= metier.FindClimatologieById(id);
		String res="";
		res+= c.getFerme().getId_Ferme()+":";
		res+= c.getTemperature()+":";
		res+= c.getPluie()+":";
		res+= c.getDate()+":";
		System.out.println("Climat : "+res);
		response.getWriter().println(res);
		
	}
	
	if(entite.equals("ParcelleChecking")){
		
		Parcellaire p=metier.findParcellaireById(id);
		String val= request.getParameter("val");
		if(val.equals("true")){
			
			metier.setParcellaireActivation(p, true);
		}
		if(val.equals("false")){
			
			metier.setParcellaireActivation(p, false);
		}
		
		System.out.println("modification enregistré ");
		response.getWriter().println("<h1>modification enregistre </h1>");
		
	}
		
	
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
