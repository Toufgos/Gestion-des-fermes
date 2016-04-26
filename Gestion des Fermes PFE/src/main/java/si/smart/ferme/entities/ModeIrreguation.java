package si.smart.ferme.entities;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import si.smart.ferme.entitiesListner.PreUpdateListner;

@Entity
@EntityListeners(PreUpdateListner.class)
public class ModeIrreguation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_mode;
	private String nom_mode;
	private String description;
	
	
	
	//Getters & setters
	public int getId_mode() {
		return id_mode;
	}
	public void setId_mode(int id_mode) {
		this.id_mode = id_mode;
	}
	public String getNom_mode() {
		return nom_mode;
	}
	public void setNom_mode(String nom_mode) {
		this.nom_mode = nom_mode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	// constructeurs 
	public ModeIrreguation(String nom_mode, String description) {
		super();
		this.nom_mode = nom_mode;
		this.description = description;
	}
	public ModeIrreguation(String nom_mode) {
		super();
		this.nom_mode = nom_mode;
	}
	public ModeIrreguation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ModeIrreguation affect(ModeIrreguation m){
		
		this.description=m.getDescription();
		this.nom_mode=m.getNom_mode();
		
		return this;
	}
	
}
