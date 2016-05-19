package test;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import si.smart.ferme.entities.Produit;

	


public class InsideAll {
	
	public static boolean exist(List<Produit> l, Produit P ){
		
		for(Produit p : l ){
			if(p.getId()==P.getId())
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
	//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
	//			new String[] { "applicationContext.xml" });
		
		AbstractApplicationContext context = null;
//	    try {
//	        context = new ClassPathXmlApplicationContext("applicationContext.xml");
//	        // context.registerShutdownHook();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        //print or log error
//	    } finally {
//	        if (context != null) {
//	            context.close();
//	        }
//	    }
	    
	    try {
	        context = new FileSystemXmlApplicationContext(
	                "src/main/webapp/WEB-INF/spring/appServlet/security-context.xml"
	        	    );
	        // context.registerShutdownHook();
	    } catch (Exception e) {
	        e.printStackTrace();
	        //print or log error
	    } finally {
	        if (context != null) {
	            context.close();
	        }
	    }
		
	}
}
