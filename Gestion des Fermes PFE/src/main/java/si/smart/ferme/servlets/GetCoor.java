package si.smart.ferme.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import si.smart.ferme.entities.CoordonnesGPS;
import si.smart.ferme.entities.Parcellaire;
import si.smart.ferme.metier.Metier;

/**
 * Servlet implementation class GetCoor
 */


public class GetCoor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCoor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		List<CoordonnesGPS> lis= new ArrayList<CoordonnesGPS>();
//		lis.add(new CoordonnesGPS(10.10, 19.0));
//		lis.add(new CoordonnesGPS(11.10, 12.0));
//		lis.add(new CoordonnesGPS(12.10, 13.0));
//		lis.add(new CoordonnesGPS(10.10, 19.0));
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		Metier metier = (Metier) ctx.getBean("metier");
		String id=  request.getParameter("data");
		long a=Long.parseLong(id);
		System.out.println("INFO : We are in GetCoorServlet ...");
		List<CoordonnesGPS> lis= metier.FindAllCoordonnesGPSByferme(a);
		List<Parcellaire> parces = metier.GetParcesOfAFarm(a);
		String res="";
		
		for (CoordonnesGPS c : lis) {
			res+= c.getLatitude()+":"+c.getLongitude()+"/";
		}
		res+="|";
		for (Parcellaire p : parces) {
			List<CoordonnesGPS> l=	metier.FindAllCoordonnesGPSByParcelle(p.getId_parce());
			System.out.println("voici la taille : a7miiiida loool  " + l.size());
			for (CoordonnesGPS c : l) {
				res+=c.getLatitude()+":"+c.getLongitude()+"/";
			}
			res+="|";
		}
		System.out.println(res);
		System.out.println("RESULT : "+res);
		System.out.println("INFO : Work in GetCoorServlet Is done ");
		response.getWriter().print(res);
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
