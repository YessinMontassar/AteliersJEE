package domaine;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categorie
 *
 */
@Entity

public class Categorie implements Serializable {

	   
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (length=50)
	private String libelle;
	private static final long serialVersionUID = 1L;

	public Categorie() {
		super();
	}   
	
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
   

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + "]";
	}

}
