package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enfant")
public class Enfant implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idenfant")
	private int id;

	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String niveauEtude;
	private String creneau;
	private MethodePayement methodePayement;

	@ManyToOne
	@JoinColumn(name = "idcompte")
	private Compte compte;

	@ManyToOne
	@JoinColumn(name = "idcours")
	private Cours cours;

	public Enfant() {
		super();
	}

	public Enfant(int id, String nom, String prenom, Date dateDeNaissance, String niveauEtude, String creneau,
			MethodePayement methodePayement) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.niveauEtude = niveauEtude;
		this.creneau = creneau;
		this.methodePayement = methodePayement;
		// this.compte = compte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public String getCreneau() {
		return creneau;
	}

	public void setCreneau(String creneau) {
		this.creneau = creneau;
	}

	public MethodePayement getMethodePayement() {
		return methodePayement;
	}

	public void setMethodePayement(MethodePayement methodePayement) {
		this.methodePayement = methodePayement;
	}

//	public Compte getCompte() {
	// return compte;
	// }

	// public void setCompte(Compte compte) {
	// this.compte = compte;
	// }

}
