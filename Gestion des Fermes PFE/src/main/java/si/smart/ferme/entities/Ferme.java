package si.smart.ferme.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import si.smart.ferme.entitiesListner.PreUpdateListner;
import si.smart.ferme.models.FermeForm;



@Entity
@EntityListeners(PreUpdateListner.class)
public class Ferme implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_Ferme;
	@Column(name = "Nom_Ferme", unique = true, nullable = true, length = 30)
	private String nom_Ferme;
	@Column(name = "Adresse_Ferme", unique = true, nullable = true, length = 200)
	private String Adresse;
	@Column(name = "Prop_de_Ferme")
	private String proprietaire_ferme;
	@Column(name = "ville_Ferme")
	private String ville_ferme;
	@Column(name = "pays_Ferme")
	private String pays_ferme;
	@Column(name = "observation_Ferme")
	private String observation_ferme;
	@OneToMany(fetch=FetchType.LAZY , cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="ferme")
	private List<CoordonnesGPS> polygoneMaps_ferme;
	private double titre_foncier_ferme;
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "ferme")
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name="personnel_Fermes")
	private List<Personnel> personnels;
	@ManyToOne()
	@JoinColumn(name = "Groupe_ID", nullable = true)
	private Groupe groupe;
	@ManyToOne
	@JoinColumn(name="gerant_frm")
	private Personnel gerant;
	
	@OneToMany(mappedBy = "ferme", cascade=CascadeType.ALL)
	private List<Parcellaire> parces;
	
	
	// Getters & setters
	public long getId_Ferme() {
		return id_Ferme;
	}
	
	public Groupe getGroupe(){
		return this.groupe;
	}
	
	public void setGroupe(Groupe g){
		this.groupe=g;
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
	public List<CoordonnesGPS> getPolygoneMaps_ferme() {
		return polygoneMaps_ferme;
	}
	public void setPolygoneMaps_ferme(List<CoordonnesGPS> polygoneMaps_ferme) {
		this.polygoneMaps_ferme = polygoneMaps_ferme;
	}
	public void setPolygoneMaps_ferme(CoordonnesGPS polygoneMaps_ferme) {
		this.polygoneMaps_ferme.add(polygoneMaps_ferme);
	}
	public double getTitre_foncier_ferme() {
		return titre_foncier_ferme;
	}
	public void setTitre_foncier_ferme(double titre_foncier_ferme) {
		this.titre_foncier_ferme = titre_foncier_ferme;
	}
	public List<Personnel> getPersonnels() {
		return personnels;
	}
	public void setpersonnels(Personnel personnels) {
		this.personnels.add( personnels);
	}
	
	// constructeurs !
	public Ferme(String nom_Ferme, String adresse, String proprietaire_ferme, String ville_ferme,
			double titre_foncier_ferme) {
		super();
		this.nom_Ferme = nom_Ferme;
		Adresse = adresse;
		this.proprietaire_ferme = proprietaire_ferme;
		this.ville_ferme = ville_ferme;
		this.titre_foncier_ferme = titre_foncier_ferme;
		this.polygoneMaps_ferme=new ArrayList<CoordonnesGPS>();
		this.personnels= new ArrayList<Personnel>();
		this.parces= new ArrayList<Parcellaire>();
	}
	public Ferme() {
		super();
		// TODO Auto-generated constructor stub
		this.polygoneMaps_ferme= new ArrayList<CoordonnesGPS>();
		this.personnels= new ArrayList<Personnel>();
		this.parces= new ArrayList<Parcellaire>();
	}
	public List<Parcellaire> getParces() {
		return parces;
	}

	public void setParces(List<Parcellaire> parces) {
		this.parces = parces;
	}
	public void setParces(Parcellaire parces) {
		this.parces.add(parces);
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}

	public Ferme affect(Ferme f){
		this.nom_Ferme = f.nom_Ferme;
		this.Adresse = f.Adresse;
		this.proprietaire_ferme = f.proprietaire_ferme;
		this.ville_ferme = f.ville_ferme;
		this.titre_foncier_ferme = f.titre_foncier_ferme;
		this.polygoneMaps_ferme=f.polygoneMaps_ferme;
		this.id_Ferme=f.id_Ferme;
		//this.personnels=f.getPersonnels();
		this.groupe=f.groupe;
		return this;
	}
	
	public Ferme affect1(FermeForm f){
		this.nom_Ferme = f.getNom();
		this.Adresse = f.getAdresse();
		this.proprietaire_ferme = f.getProp();
		this.ville_ferme = f.getVille();
		this.titre_foncier_ferme = f.getTitre();
		
		//this.personnels=f.getPersonnels();
		
		return this;
	}
	public Personnel getGerant() {
		return gerant;
	}

	public void setGerant(Personnel gerant) {
		this.gerant = gerant;
	}
	
	public void affect(FermeForm ff){
		this.Adresse=ff.getAdresse();
		this.nom_Ferme=ff.getNom();
		this.ville_ferme=ff.getAdresse();
		this.titre_foncier_ferme=ff.getTitre();
		
	}
	
	/*
	 * 
	 * Lydec : cent quatre vingt et un Dirhams et quatre vingt trois centimes  181.83
	 * 
	 * IAM : 3 cents soixante douze Dirhams et trente et un centimes 372.31 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
}
