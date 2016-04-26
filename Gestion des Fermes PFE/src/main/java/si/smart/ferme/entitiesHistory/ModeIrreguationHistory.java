package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.smart.ferme.entities.ModeIrreguation;

@Entity
public class ModeIrreguationHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	private String user;
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
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	// constructeurs 
	public ModeIrreguationHistory(String nom_mode, String description) {
		super();
		this.nom_mode = nom_mode;
		this.description = description;
	}
	
	public ModeIrreguationHistory() {
		super();
		this.modificationDate= new Date();
		this.user="testeur";
		// TODO Auto-generated constructor stub
	}
	
	public ModeIrreguationHistory(ModeIrreguation m){
		
		this.description=m.getDescription();
		this.nom_mode=m.getNom_mode();
		this.modificationDate= new Date();
		this.user="testeur";
		this.id_mode=m.getId_mode();
		this.user="Testeur";
		this.modificationDate= new Date();
		
	}
	
}
