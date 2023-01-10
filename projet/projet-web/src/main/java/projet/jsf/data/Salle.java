package projet.jsf.data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("serial")
public class Salle implements Serializable {

	private int id;
	private int nombreSalle;
	private List<Cours> cours;

	public Salle() {
		super();
	}

	public Salle(int id, int nombreSalle) {
		super();
		this.id = id;
		this.nombreSalle = nombreSalle;

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

	@Override
	public int hashCode() {
		return Objects.hash(cours);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salle other = (Salle) obj;
		return Objects.equals(cours, other.cours);
	}

}
