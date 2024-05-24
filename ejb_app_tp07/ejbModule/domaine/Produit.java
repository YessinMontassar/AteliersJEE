package domaine;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Long;
import java.lang.String;
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

	private Double prix;
	private int quantite;
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date dateAchat;
	public java.util.Date getDateAchat() {
	return dateAchat;
	}
	public void setDateAchat(java.util.Date dateAchat) {
	this.dateAchat = dateAchat; }


	public Produit() {
		super();
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
	public Double getPrix() {
		return this.prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}   
	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
   
}
