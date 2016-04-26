package test;

import si.smart.ferme.dao.Dao;
import si.smart.ferme.entities.Ferme;

public class All {
	
	private InsideAll insideAll;
	private Dao dao;

	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public Dao getdDao(){
		return this.dao;
	}
	
	public All() {
		// TODO Auto-generated constructor stub
		System.out.println("je suis le All");
		
	}
}
