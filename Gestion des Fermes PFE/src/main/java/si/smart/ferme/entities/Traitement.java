package si.smart.ferme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Traitement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date dateDeTraitement;
	@ManyToOne
	private Produit produit;
	@ManyToOne
	private Parcellaire parcellaire;
	private double quantite;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateDeTraitement() {
		return dateDeTraitement;
	}
	public void setDateDeTraitement(Date dateDeTraitement) {
		this.dateDeTraitement = dateDeTraitement;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Parcellaire getParcellaire() {
		return parcellaire;
	}
	public void setParcellaire(Parcellaire parcellaire) {
		this.parcellaire = parcellaire;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public Traitement(Date dateDeTraitement, double quantite) {
		super();
		this.dateDeTraitement = dateDeTraitement;
		this.quantite = quantite;
	}
	public Traitement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
