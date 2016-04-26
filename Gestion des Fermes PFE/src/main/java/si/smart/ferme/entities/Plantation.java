package si.smart.ferme.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import si.smart.ferme.models.OccupationForm;

@Entity
@DiscriminatorValue(value="Plantation")
public class Plantation extends Occupation {
	
	private double ecartX;
	private double ecartY;
	private int annePlantation;
	private int NbrArbres;
	@Column(length=255)
	private String remarque;
	public double getEcartX() {
		return ecartX;
	}
	public void setEcartX(double ecartX) {
		this.ecartX = ecartX;
	}
	public double getEcartY() {
		return ecartY;
	}
	public void setEcartY(double ecartY) {
		this.ecartY = ecartY;
	}
	public int getAnnePlantation() {
		return annePlantation;
	}
	public void setAnnePlantation(int annePlantation) {
		this.annePlantation = annePlantation;
	}
	public int getNbrArbres() {
		return NbrArbres;
	}
	public void setNbrArbres(int nbrArbres) {
		NbrArbres = nbrArbres;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public Plantation(int ordrevariete, double ecartX, double ecartY, int annePlantation, int nbrArbres,
			String remarque) {
		super(ordrevariete);
		this.ecartX = ecartX;
		this.ecartY = ecartY;
		this.annePlantation = annePlantation;
		NbrArbres = nbrArbres;
		this.remarque = remarque;
	}
	public Plantation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plantation(int ordrevariete) {
		super(ordrevariete);
		// TODO Auto-generated constructor stub
	}
	
	public Plantation(Occupation o) {
		super(o);
		// TODO Auto-generated constructor stub
	}
	
	public Plantation affect(OccupationForm o){
	
		this.annePlantation=o.getAnneeplantation();
		this.ecartX=o.getX();
		this.ecartY=o.getY();
		this.NbrArbres=o.getArbrenbr();
		this.setOrdrevariete(o.getOrdrevar());
		
		return this;
	}
	
}
