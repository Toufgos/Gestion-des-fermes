package si.smart.ferme.entitiesHistory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.smart.ferme.entities.Climatologie;

@Entity
public class ClimatologieHistory {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private Long id_Climat;
	private String user;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="Temperature_Moyenne")
    private	double temperature;
    
    @Column(name="précipitations_de_pluie")
    private double pluie;
	
   
    private Long fermeId;

	public ClimatologieHistory(Climatologie c) {
		super();
		this.id_Climat= c.getId();
		this.date = c.getDate();
		this.temperature = c.getTemperature();
		this.pluie = c.getPluie();
		this.fermeId= c.getFerme().getId_Ferme();
		this.user="Testeur";
		this.modificationDate= new Date();
	}

	public ClimatologieHistory(){
		this.user="Testeur";
		this.modificationDate= new Date();
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

	public Long getId_Climat() {
		return id_Climat;
	}

	public void setId_Climat(Long id_Climat) {
		this.id_Climat = id_Climat;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Long getFermeId() {
		return fermeId;
	}

	public void setFermeId(Long fermeId) {
		this.fermeId = fermeId;
	}

	
	
    
     
    
    
}
