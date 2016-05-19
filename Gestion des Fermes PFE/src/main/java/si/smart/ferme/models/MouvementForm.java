package si.smart.ferme.models;

import java.util.Date;

public class MouvementForm {
	
	private String num;
	private String ref;
	private long ferme;
	private Date date;
	private String submit;
	private String type;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public long getFerme() {
		return ferme;
	}
	public void setFerme(long ferme) {
		this.ferme = ferme;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
