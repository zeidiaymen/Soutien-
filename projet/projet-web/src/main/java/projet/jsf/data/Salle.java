package projet.jsf.data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Salle implements Serializable {

	private int id;
	private int nombreSalle;
	private List<Cours> cours;

	public Salle() {
		super();
	}

	public Salle(int id, int nombreSalle, List<Cours> cours) {
		super();
		this.id = id;
		this.nombreSalle = nombreSalle;
		this.cours = cours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNombreSalle() {
		return nombreSalle;
	}

	public void setNombreSalle(int nombreSalle) {
		this.nombreSalle = nombreSalle;
	}

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

}
