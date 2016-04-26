package si.smart.ferme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import si.smart.ferme.entitiesListner.PreUpdateListner;

@Entity
@EntityListeners(PreUpdateListner.class)
public class Personnel {
	
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "FERME_ID")
	//private Ferme ferme;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id;
	@Column(name="nom_Personnel")
	 private String nom;
	@Column(name="cin_Personnel")
	 private String cin;
	@Column(name="poste_Personnel")
	 private String responsabilite;
	@Column(name="description")
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	// constructeurs 
	public Personnel(String nom, String cin, String responsabilite) {
		super();
		this.nom = nom;
		this.cin = cin;
		this.responsabilite = responsabilite;
	}
	public Personnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personnel(Personnel p){
		super();
		this.cin=p.getCin();
		//this.ferme=p.getFerme();
		this.id=p.getId();
		this.nom=p.getNom();
		this.responsabilite=p.getResponsabilite();
	}
	// Getters & Setters
//	public Ferme getFerme() {
//		return ferme;
//	}
//	public void setFerme(Ferme ferme) {
//		this.ferme = ferme;
//	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getResponsabilite() {
		return responsabilite;
	}
	public void setResponsabilite(String responsabilite) {
		this.responsabilite = responsabilite;
	}
	 
	
	
	
}
