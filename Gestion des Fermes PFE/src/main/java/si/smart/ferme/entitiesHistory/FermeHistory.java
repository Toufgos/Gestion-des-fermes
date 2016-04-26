package si.smart.ferme.entitiesHistory;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.smart.ferme.entities.Ferme;



@Entity
public class FermeHistory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long id_Ferme;
	@Column(name = "Nom_Ferme", unique = false, nullable = true, length = 30)
	private String nom_Ferme;
	@Column(name = "Adresse_Ferme", unique = false, nullable = true, length = 200)
	private String Adresse;
	@Column(name = "Prop_de_Ferme")
	private String proprietaire_ferme;
	@Column(name = "ville_Ferme")
	private String ville_ferme;
	@Column(name = "pays_Ferme")
	private String pays_ferme;
	@Column(name = "observation_Ferme")
	private String observation_ferme;
	
	private double titre_foncier_ferme;
	
	private long groupeId;
	
	private long gerantId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	private String user;
	
	
	
	// Getters & setters
	public long getId_Ferme() {
		return id_Ferme;
	}
	

	public void setId_Ferme(long id_Ferme) {
		this.id_Ferme = id_Ferme;
	}
	public String getNom_Ferme() {
		return nom_Ferme;
	}
	public void setNom_Ferme(String nom_Ferme) {
		this.nom_Ferme = nom_Ferme;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getProprietaire_ferme() {
		return proprietaire_ferme;
	}
	public void setProprietaire_ferme(String proprietaire_ferme) {
		this.proprietaire_ferme = proprietaire_ferme;
	}
	public String getVille_ferme() {
		return ville_ferme;
	}
	public void setVille_ferme(String ville_ferme) {
		this.ville_ferme = ville_ferme;
	}
	public String getPays_ferme() {
		return pays_ferme;
	}
	public void setPays_ferme(String pays_ferme) {
		this.pays_ferme = pays_ferme;
	}
	public String getObservation_ferme() {
		return observation_ferme;
	}
	public void setObservation_ferme(String observation_ferme) {
		this.observation_ferme = observation_ferme;
	}
	
	public double getTitre_foncier_ferme() {
		return titre_foncier_ferme;
	}
	public void setTitre_foncier_ferme(double titre_foncier_ferme) {
		this.titre_foncier_ferme = titre_foncier_ferme;
	}
	
	
	// constructeurs !
	public FermeHistory(Ferme f) {
		super();
		this.nom_Ferme = f.getNom_Ferme();
		this.id_Ferme= f.getId_Ferme();
		this.Adresse =  f.getAdresse();
		this.proprietaire_ferme =  f.getProprietaire_ferme();
		this.ville_ferme = f.getVille_ferme();
		this.titre_foncier_ferme =f.getTitre_foncier_ferme();
		this.gerantId=f.getGerant().getId();
		this.groupeId=f.getGroupe().getId();
		this.user="Testeur";
		this.modificationDate= new Date();
		
	}
	public FermeHistory() {
		super();
		this.modificationDate= new Date();
		this.user="testeur";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getGroupeId() {
		return groupeId;
	}


	public void setGroupeId(long groupeId) {
		this.groupeId = groupeId;
	}


	public long getGerantId() {
		return gerantId;
	}


	public void setGerantId(long gerantId) {
		this.gerantId = gerantId;
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

	
	
	
	
}
