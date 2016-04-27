package si.smart.ferme.entities;

import java.util.regex.Matcher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
@Entity
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String nom;
	@Column(columnDefinition="text")
	private String adresse;
	@Pattern(regexp="^$[0-9]{10}")
	private String tel;
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String email;

	
	public Fournisseur() {
		super();
		
	}



	public Fournisseur(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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







	public String getTel() {
		return tel;
	}







	public void setTel(String tel) {
		String s="^$[0-9]{10}";
		java.util.regex.Pattern pattern= java.util.regex.Pattern.compile(s);
		Matcher matcher =  pattern.matcher(email);
		if( matcher.matches())
		this.tel = tel;
		else {
			System.out.println("le numero de tel est invalide");
		}
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		String s="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		java.util.regex.Pattern pattern= java.util.regex.Pattern.compile(s);
		Matcher matcher =  pattern.matcher(email);
		if( matcher.matches())
			this.email = email;
		else {
			System.out.println("email n'est pas valide");
		}
			
		
		
	}

//
//
//
//
//
//
//	public boolean validate(final String hex) {
//		String s="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//		java.util.regex.Pattern pattern= java.util.regex.Pattern.compile(s);
//		Matcher matcher =  pattern.matcher(hex);
//		return matcher.matches();
//
//	}
//	
//	
}
