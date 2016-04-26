package si.smart.ferme.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import si.smart.ferme.entities.Parcellaire;
import si.smart.ferme.entities.ParcellaireIrregue;
import si.smart.ferme.entities.Plantation;
import si.smart.ferme.metier.Metier;

/**
 * Servlet implementation class etatSynthese
 */
public class etatSynthese extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public etatSynthese() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static String serialize(Object o){
    	if(o==null)
    	return "";
    	System.out.println(o.toString());
    	return o.toString();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("je suis dans la servlet de l'etat de synthèse");
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		Metier metier = (Metier) ctx.getBean("metier");
		long id = Long.parseLong(request.getParameter("id"));
	    List<Parcellaire> parces = metier.GetParcesOfAFarm(id);
	    
	    String res="";

	    for (Parcellaire p : parces) {
	    	
			res+=serialize(p.getId_parce()+":");
			res+=p.getLibelle()+":";
			
			
			if(p.getClass().getSimpleName().equals("ParcellaireIrregue")){
				
				ParcellaireIrregue pi=(ParcellaireIrregue) p;
				if(pi != null)
				res+=serialize( "irrigue"+":");
				res+=pi.getMode().getNom_mode()+":";
			}
			
			else {
				res+=serialize("Bour"+":");
				res+=""+":";
			}
			
			
			res+=serialize( p.getS_brute()+":");
			res+=serialize( p.getS_inculte()+":");
			res+=serialize( p.getS_net()+":");
			if(p.getOccupation()!=null){
				res+=serialize( p.getOccupation().getVariete().getSousfamille().getFamille().getLibelle()+":");
				res+=serialize(p.getOccupation().getVariete().getSousfamille().getLibelle()+":");
				res+=serialize(p.getOccupation().getVariete().getNom()+":");
				res+=serialize(p.getOccupation().getOrdrevariete()+":");
			}
			else{
				res+="::::";
			}
			System.out.println("heeere");
			Plantation pl=null;
			if( Plantation.class.isAssignableFrom(p.getClass()) )
			pl= (Plantation) p.getOccupation();
			System.out.println("heeere");
			if(pl!=null){
				
				res+=serialize(pl.getNbrArbres()+":");
				res+=serialize(pl.getAnnePlantation()+":");
				res+=serialize(pl.getEcartX()+":");
				res+=serialize(pl.getEcartY()+":");
				
			}
			else{
				res+="::::";
			}
			res+=serialize("|");
		}
		request.setAttribute("Parcelles", parces);
		response.getWriter().println(res);
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
