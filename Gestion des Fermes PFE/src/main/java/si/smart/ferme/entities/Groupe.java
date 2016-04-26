package si.smart.ferme.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import si.smart.ferme.entitiesListner.PreUpdateListner;

@Entity
@EntityListeners(PreUpdateListner.class)
public class Groupe{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="libelle")
	private String nom;

	@Column(name="Description")
	private String Description;
	@OneToMany(mappedBy = "groupe", cascade=CascadeType.ALL)
	private List<Ferme> fermes;
	
	
	// Getters & setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public List<Ferme> getFerme() {
		return fermes;
	}
	public void setFerme(List<Ferme> f) {
		this.fermes = f;
	}
	public void setFerme(Ferme f){
		if(!this.fermes.contains(f))
		this.fermes.add(f);
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Ferme> getFermes() {
		return fermes;
	}
	public void setFermes(List<Ferme> fermes) {
		this.fermes = fermes;
	}
	
	// constructeurs 
	public Groupe(String description) {
		super();
		Description = description;
		this.fermes=new ArrayList<Ferme>();
	}
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groupe( Groupe g){
		super();
		this.fermes=new ArrayList<Ferme>();
		this.id=g.getId();
		this.Description=g.getDescription();
		this.fermes=g.getFerme();
	}
	
	
}
