package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Bour")
public class ParcellaireHistoryBour extends ParcellaireHistory{
	
	public ParcellaireHistoryBour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParcellaireHistoryBour(ParcellaireHistory p) {
		this.setId_parce(  p.getId_parce());
		this.setLibelle( p.getLibelle());
		this.setS_brute(  p.getS_brute());
		this.setS_inculte( p.getS_inculte());
		this.setS_net( p.getS_brute()-p.getS_inculte());
		this.setModificationDate(new Date());
		this.setUser("testeur");
		this.setOccupationId(p.getOccupationId());
		this.setFermeId(p.getFermeId());
		
		// TODO Auto-generated constructor stub
	}

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		
	}
	
}
