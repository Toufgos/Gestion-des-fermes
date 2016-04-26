package si.smart.ferme.models;

public class ClimatologieForm {
	
	private String  date;
	private double pluie;
	private double temperature;
	private long ferme;
	private String submit;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPluie() {
		return pluie;
	}
	public void setPluie(double pluie) {
		this.pluie = pluie;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public long getFerme() {
		return ferme;
	}
	public void setFerme(long ferme) {
		this.ferme = ferme;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
}
