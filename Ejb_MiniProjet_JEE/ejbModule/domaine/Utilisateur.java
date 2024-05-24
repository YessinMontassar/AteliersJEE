package domaine;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Utilisateur
 *
 */
@Entity

public class Utilisateur implements Serializable {

	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String code;
	@Column (length=50)
	private String nom;
	@Column (length=50)
	private String prenom;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateEmbauchement;
	public Utilisateur(String code, String nom, String prenom, java.util.Date dateEmbauchement, String login,
			@Size(min = 6, max = 10) String password, @Pattern(regexp = "EMPLOYE|ADMIN") String type) {
		
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauchement = dateEmbauchement;
		this.login = login;
		this.password = password;
		this.type = type;
	}

	@Column (length=50,unique = true)
	private String login;
	@Size(min = 6, max = 10)
	private String password;
	@Pattern(regexp = "EMPLOYE|ADMIN")
	private String type;
	private static final long serialVersionUID = 1L;

	public Utilisateur() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public java.util.Date getDateEmbauchement() {
		return this.dateEmbauchement;
	}

	public void setDateEmbauchement(java.util.Date dateEmbauchement) {
		this.dateEmbauchement = dateEmbauchement;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	   
		@Override
		public String toString() {
			return "Utilisateur [id=" + id + ", code=" + code + ", nom=" + nom + ", prenom=" + prenom
					+ ", dateEmbauchement=" + dateEmbauchement + ", login=" + login + ", password=" + password + ", type="
					+ type + "]";
		}
   
}
