package si.smart.ferme.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import si.smart.ferme.entities.CoordonnesGPS;
import si.smart.ferme.metier.Metier;

/**
 * Servlet implementation class MapPoint
 */
public class MapPoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapPoint() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		Metier metier = (Metier) ctx.getBean("metier");
		String id=  request.getParameter("data");
		long a=Long.parseLong(id);
		System.out.println("INFO : We are in MapPointServlet ...");
		List<CoordonnesGPS> lis= metier.FindAllCoordonnesGPSByParcelle(a);
		
		String res="";
		
		for (CoordonnesGPS c : lis) {
			res+= c.getLatitude()+":"+c.getLongitude()+"/";
		}
		res+="|";
		
		System.out.println(res);
		System.out.println("RESULT : "+res);
		System.out.println("INFO : Work in MapPointServlet Is done ");
		response.getWriter().print(res);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
