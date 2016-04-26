package si.smart.ferme.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import si.smart.ferme.entitiesListner.PreUpdateListner;
import si.smart.ferme.models.FamilleForm;



@Entity
@EntityListeners(PreUpdateListner.class)
public class Famille {
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Activite getActivite() {
		return activite;
	}
	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Famille() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Famille(String libelle, String description) {
		super();
		this.libelle = libelle;
		Description = description;
		//this.sousFamilles= new ArrayList<SousFamille>();
	}
	
	public List<SousFamille> getSousFamilles() {
		//return sousFamilles;
		return null;
	}
	public void setSousFamilles(List<SousFamille> sousFamilles) {
		//this.sousFamilles.addAll(sousFamilles);
	}
	
	public void setSousFamilles(SousFamille sousFamille) {
	//	if(!this.sousFamilles.contains(sousFamille))
		//	this.sousFamilles.add(sousFamille) ;
	}
	
	public Famille affect(FamilleForm f){
		
		this.Description=f.getDescription();
		this.libelle=f.getLibelle();
       // this.sousFamilles = new ArrayList<SousFamille>();
		
		return this;
	}
	public Famille affect(Famille f){
		
		this.Description=f.getDescription();
		this.libelle=f.getLibelle();
		this.activite= f.getActivite();
		//if(f.getSousFamilles()==null)
		//	this.sousFamilles = new ArrayList<SousFamille>();
		//else 
			//this.sousFamilles=f.getSousFamilles();
		return this;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade=CascadeType.ALL)
	private Activite activite;
//	@OneToMany(mappedBy = "famille", cascade=CascadeType.ALL)
//	private List<SousFamille> sousFamilles;
	private String libelle;
	private String Description;
	
}
