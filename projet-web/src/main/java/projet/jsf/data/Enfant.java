package projet.jsf.data;

import java.io.Serializable;
import java.util.Date;

import projet.commun.dto.MethodePayement;

public class Enfant implements Serializable{

	private int id;

	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String niveauEtude;
	private String creneau;
	private MethodePayement methodePayement;

	//private Compte compte;
	

	//private Cours cours;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	//public Cours getCours() {
		//return cours;
	//}

	//public void Cours(Cours cours) {
		//this.cours = cours;
	//}

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

	//public Compte getCompte() {
		//return compte;
	//}

	//public void setCompte(Compte compte) {
		//this.compte = compte;
	//}

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
	}
	
}
