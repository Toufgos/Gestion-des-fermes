package si.smart.ferme.models;

import si.smart.ferme.entities.Parcellaire;
import si.smart.ferme.entities.ParcellaireBour;
import si.smart.ferme.entities.ParcellaireIrregue;

public class ParcellaireFomr {
	
	private long id_ferme;
	private String libelle;
	private double s_brute;
	private double s_inculte;
	private int typeParcelaire;
	private long parcelle_id;
	private String mode;
	private String submit;
	private String nul;
	private long modeIr;
	
	public long getModeIr() {
		return modeIr;
	}

	public void setModeIr(long modeIr) {
		this.modeIr = modeIr;
	}

	public Parcellaire affect(ParcellaireFomr pf){
		Parcellaire p= new Parcellaire();
		p.setLibelle(libelle);
		p.setS_brute(pf.s_brute);
		p.setS_inculte(pf.s_inculte);
		p.setS_net(p.getS_brute()-p.getS_inculte());
		if(pf.typeParcelaire==1){
			ParcellaireIrregue pi= new ParcellaireIrregue(p);
			pi.setDescription("cette parcellaire est irregue");
			return pi;
		}
		if(pf.typeParcelaire==0){
			ParcellaireBour pb= new ParcellaireBour(p);
			pb.setDescription("Cette Parcellaire est bour");
			return pb;
		}
		
		return p;
	}
	
	public long getId_ferme() {
		return id_ferme;
	}
	public void setId_ferme(long id_ferme) {
		this.id_ferme = id_ferme;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getS_brute() {
		return s_brute;
	}
	@Override
	public String toString() {
		return "ParcellaireFomr [id_ferme=" + id_ferme + ", libelle=" + libelle + ", s_brute=" + s_brute
				+ ", s_inculte=" + s_inculte + ", typeParcelaire=" + typeParcelaire + ", mode=" + mode + ", submit="
				+ submit + ", nul=" + nul + "]";
	}

	public void setS_brute(double s_brute) {
		this.s_brute = s_brute;
	}
	public double getS_inculte() {
		return s_inculte;
	}
	public void setS_inculte(double s_inculte) {
		this.s_inculte = s_inculte;
	}
	public int getTypeParcelaire() {
		return typeParcelaire;
	}
	public void setTypeParcelaire(int typeParcelaire) {
		this.typeParcelaire = typeParcelaire;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getNul() {
		return nul;
	}
	public void setNul(String nul) {
		this.nul = nul;
	}

	public long getParcelle_id() {
		return parcelle_id;
	}

	public void setParcelle_id(long parcelle_id) {
		this.parcelle_id = parcelle_id;
	}
	
	

}
