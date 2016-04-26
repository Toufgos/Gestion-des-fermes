package si.smart.ferme.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import si.smart.ferme.metier.Metier;

@Entity
@DiscriminatorValue(value="Irregue")
public class ParcellaireIrregue extends Parcellaire {
	
	private String description;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Mode")
	private ModeIrreguation mode;
	
	public ParcellaireIrregue(Parcellaire p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public ParcellaireIrregue(Parcellaire p, String description, ModeIrreguation mode) {
		super(p);
		this.description = description;
		this.mode = mode;
	}
	

	public ParcellaireIrregue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParcellaireIrregue(String libelle, double s_brute, double s_inculte, double s_net) {
		super(libelle, s_brute, s_inculte, s_net);
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ModeIrreguation getMode() {
		return mode;
	}

	public void setMode(ModeIrreguation mode) {
		this.mode = mode;
	}
	
	public ParcellaireBour toParcellaireBour(){
		ParcellaireBour p = new ParcellaireBour((Parcellaire) this);
		p.setId_parce(this.getId_parce());
		return p;
	}
	
}
