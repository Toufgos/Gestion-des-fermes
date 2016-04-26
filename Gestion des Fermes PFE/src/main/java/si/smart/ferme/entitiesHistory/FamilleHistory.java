package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.smart.ferme.entities.Famille;



@Entity
public class FamilleHistory {
	
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public FamilleHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FamilleHistory(Famille f) {
		super();
		this.libelle = f.getLibelle();
		this.Description = f.getDescription();
		this.activiteId=f.getActivite().getId();
		this.idFamille=f.getId();
		this.user="Testeur";
		this.ModificationDate= new Date();
		//this.sousFamilles= new ArrayList<SousFamille>();
	}
	
	public long getIdFamille() {
		return idFamille;
	}
	public void setIdFamille(long idFamille) {
		this.idFamille = idFamille;
	}
	public long getActiviteId() {
		return activiteId;
	}
	public void setActiviteId(long activiteId) {
		this.activiteId = activiteId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getModificationDate() {
		return ModificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		ModificationDate = modificationDate;
	}

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long idFamille;
	
	private long activiteId;

	private String libelle;
	private String Description;
	private String user;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ModificationDate;
}
