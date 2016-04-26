package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.smart.ferme.entities.Personnel;

@Entity
public class PersonnelHistory {
	
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "FERME_ID")
	//private Ferme ferme;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	private String user;
	
	@Column(name="id_personnel")
	private long idpers;
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
	
	public PersonnelHistory() {
		super();
		this.modificationDate= new Date();
		this.user="testeur";
		
	}
	public PersonnelHistory(Personnel p){
		super();
		this.modificationDate= new Date();
		this.user="testeur";
		this.cin=p.getCin();
		this.idpers=p.getId();
		this.nom=p.getNom();
		this.responsabilite=p.getResponsabilite();
	}
	// Getters & Setters

	public long getId() {
		return id;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public long getIdpers() {
		return idpers;
	}
	public void setIdpers(long idpers) {
		this.idpers = idpers;
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
