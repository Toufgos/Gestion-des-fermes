package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import si.smart.ferme.entities.Culture;

@Entity
@DiscriminatorValue(value="Culture")
public class CultureHistory extends OccupationHistory {
	
	public CultureHistory() {
		super();
	}

	
	
	public CultureHistory( OccupationHistory o, Culture c ){
		
		this.setModificationDate(new Date());
		this.setUser("testeur");
		this.setOccupationId(o.getOccupationId());
		this.setVarieteId(o.getVarieteId());
		this.setParcelleId(o.getParcelleId());
		this.Remarque= c.getRemarque();
		
	}

	public String getRemarque() {
		return Remarque;
	}

	public void setRemarque(String remarque) {
		Remarque = remarque;
	}

	private String Remarque;
	
	
}
