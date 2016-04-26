package si.smart.ferme.entities;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import si.smart.ferme.entitiesListner.PreUpdateListner;
import si.smart.ferme.models.FamilleForm;

@Entity
@EntityListeners(PreUpdateListner.class)
public class Variete {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long AgeAdulte; // en nombre des Années
	private String nom;
	public Variete() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Variete(long ageAdulte, String nom) {
		super();
		AgeAdulte = ageAdulte;
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@ManyToOne
	@JoinColumn(nullable=true)
	private SousFamille sousfamille;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAgeAdulte() {
		return AgeAdulte;
	}
	public void setAgeAdulte(long ageAdulte) {
		AgeAdulte = ageAdulte;
	}
	public SousFamille getSousfamille() {
		return sousfamille;
	}
	public void setSousfamille(SousFamille sousfamille) {
		this.sousfamille = sousfamille;
	}
	
	public Variete affect(FamilleForm f){
		
		this.nom= f.getLibelle();
		this.AgeAdulte= f.getAge();
		
		return this;
	}
	
	public Variete affect(Variete v){
		
		this.AgeAdulte=v.getAgeAdulte();
		this.nom=v.getNom();
		if(v.getSousfamille()!=null )
			this.sousfamille =v.getSousfamille();
		
		return this;
	}
	
}
