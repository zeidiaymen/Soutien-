package projet.jsf.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mouvement implements Serializable {

	private Integer id;
	private double montant;
	private Compte compte;

	public Mouvement() {
		super();
	}

	public Mouvement(int id, double montant, Compte compte) {
		super();
		this.id = id;
		this.montant = montant;
		this.compte = compte;
	}

	public Integer getId() {
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
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
