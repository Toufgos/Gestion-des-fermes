package si.smart.ferme.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import si.smart.ferme.models.OccupationForm;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_Occupation")
@DiscriminatorValue(value="Mere")
public class Occupation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@OneToOne(cascade = CascadeType.ALL, mappedBy="occupation")
	private Parcellaire parcelle;
	
	private int ordrevariete;
//	@OneToOne
//	@JoinColumn(name = "famille")
//	private Famille famille;
//	@OneToOne
//	@JoinColumn(name = "sousFamille")
//	private SousFamille sousFamille;
	@OneToOne
	@JoinColumn(name = "var")
	private Variete variete;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Parcellaire getParcelle() {
		return parcelle;
	}
	public void setParcelle(Parcellaire parcelle) {
		this.parcelle = parcelle;
	}
	public int getOrdrevariete() {
		return ordrevariete;
	}
	public void setOrdrevariete(int ordrevariete) {
		this.ordrevariete = ordrevariete;
	}
//	public Famille getFamille() {
//		return famille;
//	}
//	public void setFamille(Famille famille2) {
//		this.famille = famille2;
//	}
//	public SousFamille getSousFamille() {
//		return sousFamille;
//	}
//	public void setSousFamille(SousFamille sousFamille) {
//		this.sousFamille = sousFamille;
//	}
	public Variete getVariete() {
		return variete;
	}
	public void setVariete(Variete variete) {
		this.variete = variete;
	}
	public Occupation(int ordrevariete) {
		super();
		this.ordrevariete = ordrevariete;
	}
	public Occupation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Occupation(Occupation o) {
		//this.famille=o.famille;
		this.id=o.id;
		this.ordrevariete=o.ordrevariete;
		//this.sousFamille=o.sousFamille;
		this.variete=o.variete;
		// TODO Auto-generated constructor stub
	}
	
	public Occupation affect(OccupationForm o){
		
		this.ordrevariete= o.getOrdrevar();
		
		return this;
	}
	
}
