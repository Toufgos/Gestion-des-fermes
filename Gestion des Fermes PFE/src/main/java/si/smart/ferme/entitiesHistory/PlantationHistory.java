package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import si.smart.ferme.entities.Plantation;

@Entity
@DiscriminatorValue(value="Plantation")
public class PlantationHistory extends OccupationHistory {
	
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
	public PlantationHistory(int ordrevariete, double ecartX, double ecartY, int annePlantation, int nbrArbres,
			String remarque) {
		
		this.ecartX = ecartX;
		this.ecartY = ecartY;
		this.annePlantation = annePlantation;
		NbrArbres = nbrArbres;
		this.remarque = remarque;
	}
	public PlantationHistory(OccupationHistory o, Plantation p) {
		super();
		
		this.setModificationDate(new Date());
		this.setUser("testeur");
		this.setOccupationId(o.getOccupationId());
		this.setVarieteId(o.getVarieteId());
		this.setParcelleId(o.getParcelleId());
		this.ecartX = p.getEcartX();
		this.ecartY = p.getEcartY();
		this.annePlantation = p.getAnnePlantation();
		this.NbrArbres = p.getNbrArbres();
		this.remarque = p.getRemarque();
		
		// TODO Auto-generated constructor stub
	}
	
	public PlantationHistory(){
		super();
	}
	
	
}
