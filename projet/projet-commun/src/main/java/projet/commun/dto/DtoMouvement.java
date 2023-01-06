package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoMouvement implements Serializable {

	private int id;
	private double montant;
	private DtoCompte compte;

	public DtoMouvement() {
		super();
	}

	public DtoMouvement(int id, double montant, DtoCompte compte) {
		super();
		this.id = id;
		this.montant = montant;
		this.compte = compte;
	}

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

	public DtoCompte getCompte() {
		return compte;
	}

	public void setCompte(DtoCompte compte) {
		this.compte = compte;
	}

}
