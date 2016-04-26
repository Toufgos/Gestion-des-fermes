package si.smart.ferme.models;

public class FermeForm {
	
	private String nom;
	private String adresse;
	private String ville;
	private String pays;
	private String prop;
	double titre;
	private long groupe;
	private long gerant;
	private String submit;
	private long id_Ferme;
	
	
	
	@Override
	public String toString() {
		return "FermeForm [nom=" + nom + ", adresse=" + adresse + ", ville=" + ville + ", pays=" + pays + ", titre="
				+ titre + ", groupe=" + groupe + ", gerant=" + gerant + ", submit=" + submit + ", id_Ferme=" + id_Ferme
				+ "]";
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public long getGerant() {
		return gerant;
	}
	public void setGerant(long gerant) {
		this.gerant = gerant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public double getTitre() {
		return titre;
	}
	public void setTitre(double titre) {
		this.titre = titre;
	}
	public long getGroupe() {
		return groupe;
	}
	public void setGroupe(long groupe) {
		this.groupe = groupe;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public long getId_Ferme() {
		return id_Ferme;
	}
	public void setId_Ferme(long id_Ferme) {
		this.id_Ferme = id_Ferme;
	}
	public String getProp() {
		return prop;
	}
	public void setProp(String prop) {
		this.prop = prop;
	}
	
	
}
