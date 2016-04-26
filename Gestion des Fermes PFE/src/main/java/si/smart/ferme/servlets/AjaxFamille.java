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
 * Servlet implementation class AjaxFamille
 */
public class AjaxFamille extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxFamille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		Metier metier = (Metier) ctx.getBean("metier");
		
		String res="";
		//String type="";
		//type= request.getParameter("work");
		String id=  request.getParameter("data");
		long i=Long.parseLong(id);
		System.out.println("Ajaax is starting ...........");
		//System.out.println("type : "+type+" id : "+i);
		
			

			System.out.println("sous familles  ...........");
			List<SousFamille> ssFamilles = metier.FindALLSousFamilles(i);
			for (SousFamille s : ssFamilles) {
				res+="<option value=\" "+s.getId()+ "\">"+s.getLibelle() +" </option> ";
			}
		//	System.out.println(type + "  " +  id);
		//	response.getWriter().println(res);
		
		
		
		response.getWriter().println(res);
		
		
		
		
		
		
		System.out.println("Ajaax ends here  ...........");
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
