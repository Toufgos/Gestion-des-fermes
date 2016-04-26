package si.smart.ferme.entitiesHistory;

import java.util.Date;

import javax.persistence.Column;
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

import si.smart.ferme.entities.Parcellaire;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_parcellaire")
@DiscriminatorValue(value="Mere")
public class ParcellaireHistory {
	
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

	public long getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(long occupationId) {
		this.occupationId = occupationId;
	}

	public long getFermeId() {
		return fermeId;
	}

	public void setFermeId(long fermeId) {
		this.fermeId = fermeId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long id_parce;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	private String user;
	

	private long occupationId;
	
	
	

	@Column(name="libel")
	private String libelle;
	@Column(name="surface_brute")
	private double s_brute;
	@Column(name="surface_inculte")
	private double s_inculte;
	@Column(name="surface_Net")
	private double s_net;
	private boolean activated;
	
	private long fermeId;

	

	public ParcellaireHistory(Parcellaire p) {
		super();
		this.id_parce = p.getId_parce();
		this.libelle = p.getLibelle();
		this.s_brute = p.getS_brute();
		this.s_inculte = p.getS_inculte();
		this.s_net = p.getS_brute()-p.getS_inculte();
		this.modificationDate=new Date();
		this.user="testeur";
		this.occupationId=p.getOccupation().getId();
		this.fermeId=p.getFerme().getId_Ferme();
		this.activated=p.getActivited();
		
	}

	public ParcellaireHistory() {
		super();
		// TODO Auto-generated constructor stub
		this.modificationDate=new Date();
		this.user="testeur";
	}

	public long getId_parce() {
		return id_parce;
	}

	public void setId_parce(long id_parce) {
		this.id_parce = id_parce;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getS_brute() {
		return s_brute;
	}

	public void setS_brute(double s_brute) {
		this.s_brute = s_brute;
	}

	public double getS_inculte() {
		return s_inculte;
	}

	public void setS_inculte(double s_inculte) {
		this.s_inculte = s_inculte;
	}

	public double getS_net() {
		return s_net;
	}

	public void setS_net(double s_net) {
		this.s_net = s_net;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}


}
