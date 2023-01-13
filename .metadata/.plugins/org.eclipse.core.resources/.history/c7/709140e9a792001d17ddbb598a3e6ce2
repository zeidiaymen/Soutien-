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

@Entity
public class Mouvement implements Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmouvement")
	private int id;
	@Column(name = "prix")

	private double montant;
	@ManyToOne
	@JoinColumn(name = "idcompte")
	private Compte cpt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	

	public Compte getCompte() {
		return cpt;
	}

	public void setCompte(Compte cpt) {
		this.cpt = cpt;
	}

}