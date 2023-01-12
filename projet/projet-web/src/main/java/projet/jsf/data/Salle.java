package projet.jsf.data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("serial")
public class Salle implements Serializable {

	private int id;
	private int nombreSalle;


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

	@Override
	public int hashCode() {
		return Objects.hash(id, nombreSalle);
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
		return id == other.id && nombreSalle == other.nombreSalle;
	}




}
