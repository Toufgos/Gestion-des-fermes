package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.smart.ferme.entities.Groupe;

@Entity
public class GroupeHistory{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long groupeId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	private String user;
	
	@Column(name="libelle")
	private String nom;

	@Column(name="Description")
	private String Description;
	
	
	// Getters & setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// constructeurs 

	public GroupeHistory() {
		super();
		this.modificationDate= new Date();
		this.user="testeur";
		// TODO Auto-generated constructor stub
	}
	
	
	public long getGroupeId() {
		return groupeId;
	}
	public void setGroupeId(long groupeId) {
		this.groupeId = groupeId;
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
	public GroupeHistory( Groupe g){
		super();
		
		this.groupeId= g.getId();
		this.nom=g.getNom();
		this.Description=g.getDescription();
		this.user="Testeur";
		this.modificationDate= new Date();
		
	}
	
	
}
