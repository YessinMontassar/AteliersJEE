package domaine;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Produit
 *
 */
@Entity

public class Produit implements Serializable {

	   
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (length=50)
	private String designation;
	private double prix;
	private int quantite;
	@Temporal(TemporalType.DATE)
	private Date dateAchat;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id")
	private Categorie categorie;

	private static final long serialVersionUID = 1L;

	public Produit() {
		super();
	}
	
	public Produit(String designation, double prix, int quantite, Date dateAchat, Categorie categorie) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.dateAchat = dateAchat;
		this.categorie = categorie;
	}
	public Produit(String designation, double prix, int quantite, Date dateAchat) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.dateAchat = dateAchat;
	}  
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}   
	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}   
	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}   
	public Date getDateAchat() {
		return this.dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
   
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", prix=" + prix + ", quantite=" + quantite
				+ ", dateAchat=" + dateAchat + ", categorie=" + categorie + "]";
	}
}
