package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoCours implements Serializable {

	private int id;
	private double prix;
	private String libelle;
	private int capacite;
	private Crenaux crenaux;

	private DtoEnfant enfant;
	private DtoSalle salle;

	public DtoCours() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public Crenaux getCrenaux() {
		return crenaux;
	}

	public void setCrenaux(Crenaux crenaux) {
		this.crenaux = crenaux;
	}

	public DtoEnfant getEnfant() {
		return enfant;
	}

	public void setEnfant(DtoEnfant enfant) {
		this.enfant = enfant;
	}

	public DtoSalle getSalle() {
		return salle;
	}

	public void setSalle(DtoSalle salle) {
		this.salle = salle;
	}

}
