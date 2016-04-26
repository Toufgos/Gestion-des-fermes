package si.smart.ferme.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import si.smart.ferme.entities.SousFamille;
import si.smart.ferme.entities.Variete;
import si.smart.ferme.metier.Metier;

/**
 * Servlet implementation class AjaxSousFamille
 */
public class AjaxSousFamille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxSousFamille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static String displayCharValues(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append((int) c).append(",");
        }
        return sb.toString();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		Metier metier = (Metier) ctx.getBean("metier");
		
		System.out.println("hnaaaya fin khasni nkooooooooooooooooooooon ");
		
		String id= request.getParameter("data").trim();
		
		
		long i= 0L;
		 try {
			 i = Long.parseLong(id);
	         System.out.println("long i = " + i);
	      } catch (NumberFormatException nfe) {
	         System.out.println("NumberFormatException: " + nfe.getMessage());
	      }

	
		String res="";
			

			System.out.println("sous familles hhhh  ...........");
			List<Variete> ssFamilles = metier.FindVarietesBySousFamille(Long.parseLong(id));
			System.out.println(ssFamilles.size());
			for (Variete s : ssFamilles) {
				res+="<option value=\" "+s.getId()+ "\">"+s.getNom() +" </option> ";
			}
			System.out.println(res);
			response.getWriter().println(res);
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
