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
 * Servlet implementation class ParceCoor
 */
public class ParceCoor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParceCoor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = request.getParameter("data").trim();
		if(data == null || "".equals(data)){
			data = "test";
		}
		
		String res = "voici le message reçu : " + data;
		Gson googleJson = new Gson();
    	
    	TestPoly polyList = googleJson.fromJson(data, TestPoly.class);
    	
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		Metier m = (Metier) context.getBean("metier");
		Parcellaire pr= m.findParcellaireById(polyList.polygone);
		if(polyList.coor.size()>1)
			m.add(pr, polyList.coor);
		response.setContentType("text/plain");
		res="ajouté à la base avec succés !";
		response.getWriter().write(res);
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
