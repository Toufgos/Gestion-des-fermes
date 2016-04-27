package si.smart.ferme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String libelle;
	@Column(columnDefinition="text")
	private String descreption;
	private double quantiteMinAuStock;
	private double quantiteEnStock;
	private double CMUPunitare;
	private double pu;
	
//	@OneToMany(mappedBy="produit")
//	private List<Mouvement> mouvements;
	
	@ManyToOne
	private CategorieProduit categorie;
	
	
	public double getPu() {
		return pu;
	}
	public void setPu(double pu) {
		this.pu = pu;
	}
	public double getQuantiteEnStock() {
		return quantiteEnStock;
	}
	public void setQuantiteEnStock(double quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}
	public double getCMUPunitare() {
		return CMUPunitare;
	}
	public void setCMUPunitare(double cMUPunitare) {
		CMUPunitare = cMUPunitare;
	}
	public CategorieProduit getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieProduit categorie) {
		this.categorie = categorie;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String libelle, String descreption, double quantiteMinAuStock) {
		super();
		this.libelle = libelle;
		this.descreption = descreption;
		this.quantiteMinAuStock = quantiteMinAuStock;
	}
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
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	public double getQuantiteMinAuStock() {
		return quantiteMinAuStock;
	}
	public void setQuantiteMinAuStock(double quantiteMinAuStock) {
		this.quantiteMinAuStock = quantiteMinAuStock;
	}
	
	
	
	
}
