package projet.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class DtoCompte implements Serializable {

	// Champs

	private int id;

	private String pseudo;

	private String motDePasse;

	private String email;

	private List<String> roles = new ArrayList<>();

	private double solde = 0;

	private List<DtoMouvement> mouvements;

	public DtoCompte() {
		super();
	}

	public DtoCompte(int id, String pseudo, String motDePasse, String email, List<String> roles, double solde,
			List<DtoMouvement> mouvements) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.email = email;
		this.roles = roles;
		this.solde = solde;
		this.mouvements = mouvements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<DtoMouvement> getMouvements() {
		return mouvements;
	}

	public void setMouvements(List<DtoMouvement> mouvements) {
		this.mouvements = mouvements;
	}

	public boolean isInRole(String role) {

		if (role != null) {
			for (String r : roles) {
				if (r.equals(role)) {
					return true;
				}
			}
		}
		return false;
	}
}
