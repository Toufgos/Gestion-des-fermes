package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.smart.ferme.entities.Occupation;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_Occupation")
@DiscriminatorValue(value="Mere")
public class OccupationHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private long occupationId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	private String user;
	
	private long parcelleId;
	
	private int ordrevariete;
//	@OneToOne
//	@JoinColumn(name = "famille")
//	private Famille famille;
//	@OneToOne
//	@JoinColumn(name = "sousFamille")
//	private SousFamille sousFamille;
	
	private long varieteId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getOrdrevariete() {
		return ordrevariete;
	}
	public void setOrdrevariete(int ordrevariete) {
		this.ordrevariete = ordrevariete;
	}

	public OccupationHistory() {
		super();
		this.modificationDate= new Date();
		this.user="testeur";
	}
	
	
	public long getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(long occupationId) {
		this.occupationId = occupationId;
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
	public long getParcelleId() {
		return parcelleId;
	}
	public void setParcelleId(long parcelleId) {
		this.parcelleId = parcelleId;
	}
	public long getVarieteId() {
		return varieteId;
	}
	public void setVarieteId(long varieteId) {
		this.varieteId = varieteId;
	}
	
	
	public OccupationHistory(Occupation o) {
		this.modificationDate= new Date();
		this.user="testeur";
		this.occupationId=o.getId();
		this.ordrevariete=o.getOrdrevariete();
		this.parcelleId=o.getParcelle().getId_parce();
		this.varieteId=o.getVariete().getId();
		
	}
	
	
	
}
