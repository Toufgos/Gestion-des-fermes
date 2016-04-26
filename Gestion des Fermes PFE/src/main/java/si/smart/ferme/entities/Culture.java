package si.smart.ferme.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import si.smart.ferme.models.OccupationForm;

@Entity
@DiscriminatorValue(value="Culture")
public class Culture extends Occupation {
	
	public Culture() {
		super();
	}

	public Culture(int ordrevariete, String remarque) {
		super(ordrevariete);
		Remarque = remarque;
	}
	
	public Culture( Occupation o){
		super(o);
	}

	public String getRemarque() {
		return Remarque;
	}

	public void setRemarque(String remarque) {
		Remarque = remarque;
	}

	private String Remarque;
	
	public Culture affect(OccupationForm o){
		
	
		this.setOrdrevariete(o.getOrdrevar());
		
		return this;
	}
}
