package si.smart.ferme.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
 * Servlet implementation class UpadateEntite
 */
public class UpdateEntite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEntite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		// TODO Auto-generated method stub
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		Metier metier = (Metier) ctx.getBean("metier");
		System.out.println("we are in updating  servlet");
		String idS=request.getParameter("id");
		long id= Long.parseLong(idS);
		String entite= request.getParameter("entite");
//			    System.out.println("I get From client : "+ libelle+ " : "+ observation );
		System.out.println("l' entité est : "+entite);
		if(entite.equals("Activite")){
			//response.getWriter().print("l'id est : "+ id );
			
				Activite a= metier.FindActiviteById(id);
				String libelle= request.getParameter("libelle");
				String observation = request.getParameter("observation");

				a.setLibelle(libelle);
				a.setObservation(observation);
				metier.update(a);
				String res= a.getLibelle()+":"+a.getObservation();
				System.out.println(res);
				response.getWriter().println(res +" updated ");
			
		}
		if(entite.equals("Groupe")){
				Groupe g= metier.FindGroupeById(id);
				String libelle= request.getParameter("libelle");
				String observation = request.getParameter("observation");
				System.out.println("request parameters are getten");
				g.setNom(libelle);
				g.setDescription(observation);
				metier.update(g);
				System.out.println("updated ...");
				response.getWriter().println("Le gourpe "+ g.getNom()+"est mis a jour !" );
			
		}
		if(entite.equals("Mode")){
			String libelle= request.getParameter("libelle");
			String observation = request.getParameter("observation");
		
			ModeIrreguation mode= metier.findModeIrrigationById(id);
			
			mode.setNom_mode(libelle);
			mode.setDescription(observation);
			metier.update(mode);
			System.out.println("Modification est terminée ;) ");
			response.getWriter().println("Modification est terminée ;) ");
			
		
	}
//		if(entite.equals("Parcelle")){
//			System.out.println(entite);
//			response.getWriter().println(entite);
//		
//	}
		if(entite.equals("Sous")){
			System.out.println(entite);
			String nom= request.getParameter("libelle");
			String famille= request.getParameter("famille");
			Long idFamille= Long.parseLong(famille);
			Famille f =metier.FindFamilleById(idFamille);
			SousFamille s= metier.findSousFamillebyId(id);
			System.out.println(nom);
			s.setLibelle(nom);
			s.setFamille(f);
			metier.update(s);
			response.getWriter().println("Cette SousFamille est mise à jour");
		
	}
		if(entite.equals("Famille")){
			
			String libelle= request.getParameter("libelle");
			String observation = request.getParameter("observation");
			String activite = request.getParameter("activiteNew");
			System.out.println("libelle : "+libelle);
			System.out.println("observation : "+observation);
			System.out.println("activite : "+ activite);
			long act= Long.parseLong(activite);
			
			Famille f= metier.FindFamilleById(id);
			Activite a= metier.FindActiviteById(act);
			f.setDescription(observation);
			f.setLibelle(libelle);
			if(a!=null)
			f.setActivite(a);
			
			metier.update(f);
			System.out.println("Modification est terminée ;) ");
			response.getWriter().println("Modification est terminée ;) ");
		
	}
		if(entite.equals("Variete")){
			String sous=request.getParameter("sous");
			String ag= request.getParameter("age");
			long ss= Long.parseLong(sous);
			long age= Long.parseLong(ag);
			String libelle= request.getParameter("libelle");
			Variete v= metier.FindVarieteById(id);
			v.setAgeAdulte(age); v.setNom(libelle); v.setSousfamille(metier.findSousFamillebyId(ss));
			metier.update(v);
			response.getWriter().println("la varieté est mise à jour");
		
	}
		
		if(entite.equals("Climat")){
			long fermeid =Long.parseLong(request.getParameter("ferme")) ;
			double pluie= Double.parseDouble(request.getParameter("pluie"));
			double temperature  = Double.parseDouble(request.getParameter("temperature"));
			String date = request.getParameter("date");
			
			Climatologie c= metier.FindClimatologieById(id);
			Ferme ferme= metier.FindFermeById(fermeid);
			c.setDate(date);
			c.setPluie(pluie);
			c.setTemperature(temperature);
			c.setFerme(ferme);
			metier.update(c);
			response.getWriter().println("la Climat est mise à jour");
			
		}
		if( entite.equals("Occupation")){
			  
			  int ordrevar=Integer.parseInt( request.getParameter("ordrevar"));
			  long famille= Long.parseLong( request.getParameter("famille"));
			  long sousfamille= Long.parseLong(  request.getParameter("sousfamille"));
			  long variete=Long.parseLong(  request.getParameter("variete"));
			  String mode= request.getParameter("mode");
			  double x= Double.parseDouble( request.getParameter("x"));
			  double y= Double.parseDouble(  request.getParameter("y"));
			  int arbrenbr= Integer.parseInt(request.getParameter("arbrenbr"));
			  int anneeplantation= Integer.parseInt(request.getParameter("anneeplantation"));
			  Occupation o= metier.findOccupationById(id);
			  o.setOrdrevariete(ordrevar); 
			  Variete variet=metier.FindVarieteById(variete);
			  o.setVariete(variet); 
			  if(mode.equals("p")){
				  Plantation p= (Plantation) o;
				  p.setAnnePlantation(anneeplantation);
				  p.setEcartX(x); p.setEcartY(y);
				  p.setNbrArbres(arbrenbr);
				  p.setRemarque("cette partie de parcelle est didié pour la plantation");
				  metier.update(p);
			  }
			  if(mode.equals("c")){
				  Culture c=(Culture) o;
				  c.setRemarque("cette partie de parcelle est didié pour la culture");
				  metier.update(c);
			  }
				 
			  String res="";
			  res+= ""+ordrevar+":"+famille+":"+sousfamille+":"+variete+":"+mode+":"+x+":"+y+":"+arbrenbr+":"+anneeplantation;
			  res+="is updated";
			  response.getWriter().println(res);
			  
			 //Occupation o = metier.findOccupationById(a);
		}
		
		
		if(entite.equals("Parcelle")){
			
			long f= Long.parseLong(request.getParameter("id_ferme"));
			String libelle= request.getParameter("libelle");
			double s_brute= Double.parseDouble(request.getParameter("s_brute"));
			double s_inculte = Double.parseDouble(request.getParameter("s_inculte"));
			String type= request.getParameter("typeParcelaire");
			System.out.println(libelle+" "+s_brute+" "+s_inculte+" "+type+" ");
			
			Parcellaire p=metier.findParcellaireById(id);
			
			if(type.equals("1")){
				
				long modeIr= Long.parseLong(request.getParameter("modeIr"));
				if( ! p.getClass().isAssignableFrom(ParcellaireIrregue.class) )
					metier.convertParcelleToIrregue(p);
				ParcellaireIrregue pi= (ParcellaireIrregue) metier.findParcellaireById(id);
				
				ModeIrreguation mode=metier.findModeIrrigationById(modeIr);
				pi.setMode(mode);
				pi.setLibelle(libelle);
				pi.setS_brute(s_brute);
				pi.setS_inculte(s_inculte);
				System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				if(p.getActivited()== false)
				metier.update(pi);
			}
			if(type.equals("0")){
				
				if( ! p.getClass().isAssignableFrom(ParcellaireBour.class) )
					metier.convertParcelleToBour(p);
				
				ParcellaireBour pb= (ParcellaireBour) p;
				pb.setLibelle(libelle);
				pb.setS_brute(s_brute);
				pb.setS_inculte(s_inculte);
				if(p.getActivited()== false)
				metier.update(pb);
				
			}
			String res="mise a jour du parcelle:";
			if(p.getActivited()== false)
			 res+="la parcelle "+libelle+" est mise à jour !:0";
			else {
				res+="<h4>il est impossible de modifier les informations de cette parcelle</h4>";
				res+="NB! si vous avez besoin de mettre à jour cette entité, vous devez contacter l'administrateur pour cela.:1 ";
			}
			System.out.println(res);
			response.getWriter().println(res);
					
		}
		System.out.println(id+" "+entite);
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
