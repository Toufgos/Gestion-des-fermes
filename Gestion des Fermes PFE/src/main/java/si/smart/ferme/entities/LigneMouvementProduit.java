package si.smart.ferme.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LigneMouvementProduit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Mouvement mouvement;
	@OneToOne
	private Produit produit;
	private double quantite;
	private double prixUnitaire;
	private double remise;
	private double montant;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Mouvement getMouvement() {
		return mouvement;
	}

	public void setMouvement(Mouvement mouvement) {
		this.mouvement = mouvement;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public LigneMouvementProduit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneMouvementProduit(double quantite, double prixUnitaire, double remise) {
		super();
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remise = remise;
		this.montant = (quantite*prixUnitaire)-remise;
	}
	
	
	
	
	
	
	
}
