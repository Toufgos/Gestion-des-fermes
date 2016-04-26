package si.smart.ferme.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CoordonnesGPS implements Serializable {

	
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private double longitude;
	private double latitude;
	@ManyToOne(cascade= CascadeType.ALL)
	private Ferme ferme;
	@ManyToOne(cascade=CascadeType.ALL)
	private Parcellaire parcellaire;
	
	public Parcellaire getParcellaire() {
		return parcellaire;
	}
	public void setParcellaire(Parcellaire parcellaire) {
		this.parcellaire = parcellaire;
	}
	public Ferme getFerme() {
		return ferme;
	}
	public void setFerme(Ferme ferme) {
		this.ferme = ferme;
	}
	// getters & setters
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	// constructeur
	
	public CoordonnesGPS() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CoordonnesGPS(double longitude, double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
	
}
