package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.smart.ferme.entities.Variete;

@Entity
public class VarieteHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long idVar;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	private String user;
	
	private long AgeAdulte; // en nombre des Années
	private String nom;
	public VarieteHistory() {
		super();
		this.modificationDate=new Date();
		this.user="testeur";
		
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	private long sousFamilleId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAgeAdulte() {
		return AgeAdulte;
	}
	public void setAgeAdulte(long ageAdulte) {
		AgeAdulte = ageAdulte;
	}
	
	

	
	public VarieteHistory (Variete v){
		this.modificationDate=new Date();
		this.user="testeur";
		this.AgeAdulte=v.getAgeAdulte();
		this.nom=v.getNom();
		this.idVar=v.getId();
		this.sousFamilleId=v.getSousfamille().getId();
		
		
	}

	public long getIdVar() {
		return idVar;
	}

	public void setIdVar(long idVar) {
		this.idVar = idVar;
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

	public long getSousFamilleId() {
		return sousFamilleId;
	}

	public void setSousFamilleId(long sousFamilleId) {
		this.sousFamilleId = sousFamilleId;
	}
	
}
