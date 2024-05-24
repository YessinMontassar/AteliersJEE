package domaine;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Entity implementation class for Entity: Conge
 *
 */
@Entity

public class Conge implements Serializable {

	public Conge(String description, Date dateDebut, Date dateFin, Date dateRepture,
			@Pattern(regexp = "SOLLICITE|VALIDE|REFUSE|ANNULE|EN_COURS|ARRETE|FINI") String etat) {
		
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateRepture = dateRepture;
		this.etat = etat;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebut;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateFin;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateRepture;
	@Pattern(regexp = "SOLLICITE|VALIDE|REFUSE|ANNULE|EN_COURS|ARRETE|FINI")
	private String etat;
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	private static final long serialVersionUID = 1L;

	public Conge() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public java.util.Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(java.util.Date dateDebut) {
		this.dateDebut = dateDebut;
	}   
	public java.util.Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(java.util.Date dateFin) {
		this.dateFin = dateFin;
	}   
	public java.util.Date getDateRepture() {
		return this.dateRepture;
	}

	public void setDateRepture(java.util.Date dateRepture) {
		this.dateRepture = dateRepture;
	}   
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
   
}
