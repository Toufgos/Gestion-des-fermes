package si.smart.ferme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Mouvement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String numMouvement;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToOne
	private Ferme ferme;
	@Column(unique=true)
	private String reference;
	private String Type;
	
	/*
	public void ajouterProduit(Produit p){
		if(!this.produits.contains(p))
		this.produits.add(p);
	}
	*/
	
	public Mouvement() {
		super();
		// TODO Auto-generated constructor stub
		//this.produits= new ArrayList<Produit>();
	}
	public Mouvement(String numMouvement, Date date, String reference, String type) {
		super();
		this.numMouvement = numMouvement;
		this.date = date;
		this.reference = reference;
		Type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumMouvement() {
		return numMouvement;
	}
	public void setNumMouvement(String numMouvement) {
		this.numMouvement = numMouvement;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Ferme getFerme() {
		return ferme;
	}
	public void setFerme(Ferme ferme) {
		this.ferme = ferme;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
	
}
