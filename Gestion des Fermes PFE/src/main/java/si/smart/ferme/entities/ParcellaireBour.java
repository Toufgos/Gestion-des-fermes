package si.smart.ferme.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Bour")
public class ParcellaireBour extends Parcellaire {
	
	public ParcellaireBour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParcellaireBour(Parcellaire p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		
	}
	
	public ParcellaireIrregue toParcellaireIrregue(){
		ParcellaireIrregue p = new ParcellaireIrregue((Parcellaire) this);
		p.setId_parce(this.getId_parce());
		
		return p;
	}
	
}
