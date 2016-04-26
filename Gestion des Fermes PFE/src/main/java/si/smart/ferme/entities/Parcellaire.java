package si.smart.ferme.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import si.smart.ferme.entitiesListner.PreUpdateListner;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_parcellaire")
@DiscriminatorValue(value="Mere")
//@EntityListeners(value=PreUpdateListner.class)
public class Parcellaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_parce;
	
	private boolean activited;
	
	public boolean getActivited() {
		return activited;
	}
	
	@OneToMany(fetch=FetchType.LAZY , cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="ferme")
	
	private List<CoordonnesGPS> polygoneMaps_parcelle;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique=true)
	private Occupation occupation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique=true)
	private Occupation occupation2;
	
	public Occupation getOccupation2() {
		return occupation2;
	}

	public void setOccupation2(Occupation occupation2) {
		this.occupation2 = occupation2;
	}

	public List<CoordonnesGPS> getPolygoneMaps_parcelle() {
		return polygoneMaps_parcelle;
	}

	public void setPolygoneMaps_parcelle(List<CoordonnesGPS> polygoneMaps_parcelle) {
		this.polygoneMaps_parcelle = polygoneMaps_parcelle;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}
	
	

	@Column(name="libel", nullable=false, unique=true)
	private String libelle;
	@Column(name="surface_brute")
	private double s_brute;
	@Column(name="surface_inculte")
	private double s_inculte;
	@Column(name="surface_Net")
	private double s_net;
	
	@ManyToOne(cascade=CascadeType.ALL )
	@JoinColumn(name = "Ferme_ID")
	private Ferme ferme;

	public Parcellaire(String libelle, double s_brute, double s_inculte, double s_net) {
		super();
		this.libelle = libelle;
		this.s_brute = s_brute;
		this.s_inculte = s_inculte;
		this.s_net = s_net;
		polygoneMaps_parcelle= new ArrayList<CoordonnesGPS>();
	}

	public Parcellaire(Parcellaire p) {
		super();
		this.id_parce = p.id_parce;
		this.libelle = p.libelle;
		this.s_brute = p.s_brute;
		this.s_inculte = p.s_inculte;
		this.s_net = p.s_net;
		this.polygoneMaps_parcelle = p.polygoneMaps_parcelle;
		this.ferme = p.ferme;
		this.activited=p.activited;
	}

	public Parcellaire() {
		super();
		// TODO Auto-generated constructor stub
		polygoneMaps_parcelle= new ArrayList<CoordonnesGPS>();
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

	public List<CoordonnesGPS> getPolygoneMaps_parce() {
		return polygoneMaps_parcelle;
	}

	public void setPolygoneMaps_parce(List<CoordonnesGPS> polygoneMaps_parce) {
		this.polygoneMaps_parcelle = polygoneMaps_parce;
	}

	public Ferme getFerme() {
		return ferme;
	}

	public void setFerme(Ferme ferme) {
		this.ferme = ferme;
	}
	
	public void setPolygoneMaps_parce(CoordonnesGPS polygoneMaps_parce) {
		this.polygoneMaps_parcelle.add(polygoneMaps_parce);
	}

	public boolean isActivited() {
		return activited;
	}

	public void setActivited(boolean activited) {
		this.activited = activited;
	}
}
