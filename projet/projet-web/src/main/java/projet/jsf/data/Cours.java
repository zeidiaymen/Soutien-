package projet.jsf.data;

import java.util.Objects;

@SuppressWarnings("serial")
public class Cours {

	private Integer id;
	private double prix;
	private String libelle;
	private int capacite;
	private Crenaux crenaux;

	private Enfant enfant;
	private Salle salle;

	public Cours() {
		super();
	}

	public Integer getId() {
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

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cours other = (Cours) obj;
		return Objects.equals(id, other.id);
	}

}
