package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Irregue")
public class ParcellaireHistoryIrregue extends ParcellaireHistory {
	
	private String description;
	
	private long modeId;
	
	public ParcellaireHistoryIrregue(ParcellaireHistory p) {
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

	public ParcellaireHistoryIrregue(ParcellaireHistory p, String description, long mode) {
		this.setId_parce(  p.getId_parce());
		this.setLibelle( p.getLibelle());
		this.setS_brute(  p.getS_brute());
		this.setS_inculte( p.getS_inculte());
		this.setS_net( p.getS_brute()-p.getS_inculte());
		this.setModificationDate(new Date());
		this.setUser("testeur");
		this.setOccupationId(p.getOccupationId());
		this.setFermeId(p.getFermeId());
		this.description = description;
		this.modeId = mode;
	}
	

	public ParcellaireHistoryIrregue() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getMode() {
		return modeId;
	}

	public void setMode(long mode) {
		this.modeId = mode;
	}
	
	
}
