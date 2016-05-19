package si.smart.ferme.models;

import java.util.Date;

public class TraitementForm {
	
	private long parce;
	private long prod;
	private Date date;
	private double qte;
	private String submit;
	public long getParce() {
		return parce;
	}
	public void setParce(long parce) {
		this.parce = parce;
	}
	public long getProd() {
		return prod;
	}
	public void setProd(long prod) {
		this.prod = prod;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getQte() {
		return qte;
	}
	public void setQte(double qte) {
		this.qte = qte;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public TraitementForm() {
		super();
		
	}
	
	
}
