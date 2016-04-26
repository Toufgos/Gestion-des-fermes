package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.smart.ferme.entities.SousFamille;

@Entity
@Table(name="SousFamilleHistory")
public class SousFamilleHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long ssId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	private String user;
	
	
	private long familleId;

	private String Libelle;
	


	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public SousFamilleHistory() {
		super();
		this.modificationDate=new Date();
		this.user="testeur";
	}

	
	
	
	public SousFamilleHistory( SousFamille s){
		
		this.Libelle=s.getLibelle();
		this.modificationDate=new Date();
		this.user="testeur";
		this.ssId=s.getId();
		this.familleId=s.getFamille().getId();
		
		
	}


	public long getSsId() {
		return ssId;
	}


	public void setSsId(long ssId) {
		this.ssId = ssId;
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


	public long getFamilleId() {
		return familleId;
	}


	public void setFamilleId(long familleId) {
		this.familleId = familleId;
	}
}
