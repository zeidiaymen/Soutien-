package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cours implements Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCours")
	private int id;

	@ManyToOne
	@JoinColumn(name = "idSalle")
	private Salle salle;

	@OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
	private List<Enfant> enfants;

	private double prix;
	private String libelle;
	private int capacite;
	private Crenaux crenaux;

	public double getPrix() {
		return prix;
	}

	public Crenaux getCrenaux() {
		return crenaux;
	}

	public void setCrenaux(Crenaux crenaux) {
		this.crenaux = crenaux;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public List<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}
}
