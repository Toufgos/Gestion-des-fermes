package si.smart.ferme.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.context.support.WebApplicationContextUtils;

import si.smart.ferme.entities.LigneMouvementProduit;
import si.smart.ferme.entities.Mouvement;
import si.smart.ferme.entities.Produit;
import si.smart.ferme.metier.Metier;

/**
 * Servlet implementation class AjoutLigneMouvementProduit
 */
public class AjoutLigneMouvementProduitAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutLigneMouvementProduitAjax() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void sendAlert(Produit p, Mouvement m){
    	String crunchifyConfFile = "crunchify-bean.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
 
		// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
		MailSender crunchifymail = (MailSender) context.getBean("mailSender");
		
		String toAddr = "toufga.brahim@gmail.com";
		String fromAddr = "projet.gestion.fermes@gmail.com";
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.FRANCE);
		String date = dateFormat.format(m.getDate());
		double qt=p.getQuantiteMinAuStock()-p.getQuantiteEnStock()+1;
		// email subject
		String subject = "Alert ! la quantité du produit "+p.getLibelle()+" est très bas ";
 
		// email body
		String body = "Suite au mouvement "+m.getReference()+" effectué le "+ date+"la quantité du produit "+p.getLibelle();
		body+=" est devenu "+p.getQuantiteEnStock()+". et je tiens à vous informer que cette quantité est plus bas que la quantité";
		body+="minimale dans le stock que vous avez défini pour ce produit  (   "+p.getQuantiteMinAuStock()+")";
		body+="je vous recommande de commander une quantité supérieur à "+qt+" le plutot possible afin d'éviter toute rupture de stock.";
		SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
		crunchifyMsg.setFrom(fromAddr);
		crunchifyMsg.setTo(toAddr);
		crunchifyMsg.setSubject(subject);
		crunchifyMsg.setText(body);
		crunchifymail.send(crunchifyMsg);
		//crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
		System.out.println("mail d'alert est envoyé avec succes ");
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		Metier metier = (Metier) context.getBean("metier");
		
		 response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		 response.setCharacterEncoding("UTF-8");
		//String prod= "1";
		String prod = request.getParameter("produit").trim();
		String mov = request.getParameter("mouvement").trim();
		double qte = Math.max(0.0, Double.parseDouble(request.getParameter("qantite").trim()));
		double rem = Math.max(0.0, Double.parseDouble(request.getParameter("remise").trim()));
		double pu = Math.max(0.0, Double.parseDouble(request.getParameter("prix").trim()));
		
		long prodId= Long.parseLong(prod);
		Produit p= metier.FindProduitById(prodId);
		long movId = Long.parseLong(mov);
		Mouvement m= metier.FindMouvementById(movId);
		LigneMouvementProduit l = new LigneMouvementProduit(qte, pu, rem);
		double montant = qte*pu-rem;
		l.setMontant(montant);
		String s="";
		if(m.getType().equals("sortie") || m.getType().equals("depreciation") ){
			if(qte > p.getQuantiteEnStock() )
			{
				s+="l'état du stock ne permet pas de faire sortir "+qte+" de produit "+p.getLibelle()+" \n";
				System.out.println("l'état du stock ne permet pas de faire sortir "+qte+" de produit "+p.getLibelle()+" \n");
				s+="dans le stock il n'existe que "+p.getQuantiteEnStock()+"\n";
				response.getWriter().println(s);
				return ;
			}
		}
		System.out.println(l.getMontant()+"  "+m.getReference()+"    "+p.getLibelle());
		System.out.println("before persisting .... ");
		l=metier.add(l,m,p);
		Produit np= l.getProduit();
		if(np.getQuantiteEnStock() <= np.getQuantiteMinAuStock()){
			s="<code> Attention </code>  la quantité de "+np.getLibelle() +" en stock est très bas ! on vous invite à faire une commande le plutôt possible <br/>";
			sendAlert(np, m);
		}
		System.out.println("le produit <code>"+ p.getLibelle()+"</code> est ajouté avec succés au Mouvement <code>"+m.getReference()+"</code>");
		s +="le produit <code>"+ p.getLibelle()+"</code> est ajouté avec succés au Mouvement <code>"+m.getReference()+"</code>";
		response.getWriter().println(s);
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
