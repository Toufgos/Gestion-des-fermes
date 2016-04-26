package si.smart.ferme.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.smart.ferme.entitiesListner.PreUpdateListner;

@Entity
@EntityListeners(PreUpdateListner.class)
public class Climatologie {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="Temperature_Moyenne")
    private	double temperature;
    
    @Column(name="précipitations_de_pluie")
    private double pluie;
	
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Ferme")
    private Ferme ferme;

	public Climatologie(Date date, double temperature, double pluie) {
		super();
		this.date = date;
		this.temperature = temperature;
		this.pluie = pluie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public void setDate(String dateS) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(dateS);
			System.out.println(formatter.format(date));
			this.date=date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Date date= new Date();
			this.date=date;
		}
	}
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getPluie() {
		return pluie;
	}

	public void setPluie(double pluie) {
		this.pluie = pluie;
	}

	public Ferme getFerme() {
		return ferme;
	}

	public void setFerme(Ferme ferme) {
		this.ferme = ferme;
	}

	public Climatologie() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
    
     
    
    
}
