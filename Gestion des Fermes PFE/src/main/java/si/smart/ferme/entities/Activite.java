package si.smart.ferme.entities;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import si.smart.ferme.entitiesListner.PreUpdateListner;
import si.smart.ferme.models.FamilleForm;

@Entity
@EntityListeners(PreUpdateListner.class)
public class Activite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
//	@OneToOne(cascade = CascadeType.ALL)
//	private Famille famille;
//	public Famille getFamille() {
//		return famille;
//	}
//	public void setFamille(Famille famille) {
//		this.famille = famille;
//	}
	private String libelle;
	public Activite(String libelle, String observation) {
		super();
		this.libelle = libelle;
		this.observation = observation;
	}
	private String observation;
	public Activite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	public Activite affect(FamilleForm f){
		
		this.libelle=f.getLibelle();
		this.observation= f.getDescription();
		
		return this;
	}
	
}
