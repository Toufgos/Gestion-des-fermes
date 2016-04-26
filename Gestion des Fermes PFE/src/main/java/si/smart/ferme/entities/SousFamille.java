package si.smart.ferme.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import si.smart.ferme.entitiesListner.PreUpdateListner;
import si.smart.ferme.models.FamilleForm;

@Entity
@Table(name="SousFamille")
@EntityListeners(PreUpdateListner.class)
public class SousFamille {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=true)
	private Famille famille;
	
	private String Libelle;
	
//	@OneToMany(mappedBy = "sousfamille", cascade=CascadeType.ALL)
//	private List<Variete> varietes;

	public long getId() {
		return id;
	}

	public List<Variete> getVarietes() {
		//return varietes;
		return null;
	}

	public void setVarietes(List<Variete> varietes) {
	//	this.varietes.addAll(varietes);
	}
	
	public void setVarietes(Variete variete) {
	//	if(!this.varietes.contains(variete))
	//	this.varietes.add(variete);
	}

	public void setId(long id) {
		this.id = id;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public SousFamille() {
		super();
	//	this.varietes= new ArrayList<Variete>();
		// TODO Auto-generated constructor stub
	}

	public SousFamille(String libelle) {
		super();
		Libelle = libelle;
		//this.varietes= new ArrayList<Variete>();
	}
	
	public SousFamille affect(FamilleForm f){
		
		this.Libelle=f.getLibelle();
		
		return this;
	}
	
	public SousFamille affect( SousFamille s){
		
		this.Libelle=s.getLibelle();
		if(s.getFamille()!= null) this.famille=s.getFamille();
		
		return this;
	}
}
