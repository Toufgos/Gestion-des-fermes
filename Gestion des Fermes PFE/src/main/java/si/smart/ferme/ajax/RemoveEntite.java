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
import si.smart.ferme.entities.Famille;
import si.smart.ferme.entities.Ferme;
import si.smart.ferme.entities.Groupe;
import si.smart.ferme.metier.Metier;

/**
 * Servlet implementation class RemoveEntite
 */
public class RemoveEntite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveEntite() {
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
		System.out.println("we are in deleting servlet");
		String idS=request.getParameter("id");
		long id= Long.parseLong(idS);
		
		String entite= request.getParameter("entite");
		System.out.println("l' entité est : "+entite);
		
		if(entite.equals("Activite")){
			//response.getWriter().print("l'id est : "+ id );
			
				Activite a= metier.FindActiviteById(id);
				String res= metier.Remove(a);
				System.out.println(res);
				response.getWriter().println(res);
		
		}
		if(entite.equals("Groupe")){
			System.out.println(entite);
			Groupe g= metier.FindGroupeById(id);
			System.out.println(g.getNom());
			String s= metier.Remove(g);
			response.getWriter().println(s);
		
	}
	if(entite.equals("Mode")){
		System.out.println(entite);
		response.getWriter().println(entite);
	
}
	if(entite.equals("Parcelle")){
		System.out.println(entite);
		response.getWriter().println(entite);
	
}
	if(entite.equals("SousFamille")){
		System.out.println(entite);
		response.getWriter().println(entite);
	
}
	if(entite.equals("Famille")){
		Famille f = metier.FindFamilleById(id);
		String res= metier.Remove(f);
		System.out.println(res);
		response.getWriter().println(res);
	
}
	
	if(entite.equals("Climat")){
		
		System.out.println("we are going to delete climat that id is "+id);
		Climatologie c= metier.FindClimatologieById(id);
		c.setFerme(null);
		metier.remove(c);
		response.getWriter().println("climat removed ");
		
	}
	
	if(entite.equals("Variete")){
		System.out.println(entite);
		response.getWriter().println(entite);
	
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
