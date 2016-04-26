package si.smart.ferme.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import si.smart.ferme.entities.Ferme;
import si.smart.ferme.entities.Parcellaire;
import si.smart.ferme.entities.TestPoly;
import si.smart.ferme.metier.Metier;

/**
 * Servlet implementation class TestAja
 */
public class TestAja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAja() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String data = request.getParameter("data").trim();
		String entite = request.getParameter("entite").trim();
		if(data == null || "".equals(data)){
			data = "test";
		}
		
		String res = "voici le message reçu : " + data;
		Gson googleJson = new Gson();
    	
    	TestPoly polyList = googleJson.fromJson(data, TestPoly.class);
    	
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		Metier m = (Metier) context.getBean("metier");
		
		if(entite.equals("parce")){
			Parcellaire p = m.findParcellaireById(polyList.polygone);
			if(polyList.coor.size()>1)
				m.add(p, polyList.coor);
		}
		if(entite.equals("ferme")){
			Ferme ferme_de_test= m.FindFermeById(polyList.polygone);
			if(polyList.coor.size()>1)
				m.add(polyList.polygone, polyList.coor);
		}
		
		res="Ajouté à la base avec succes";
		response.setContentType("text/plain");
		response.getWriter().write(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
