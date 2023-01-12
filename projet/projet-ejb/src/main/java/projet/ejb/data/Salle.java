package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Salle implements Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idSalle")
	private int idSalle;
	private int nombreSalle;
	//@Column(name = "cours")
	//@OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
	//private List<Cours> cours;
	
	public int getId() {
		return idSalle;
	}

	public void setId(int id) {
		this.idSalle = id;
	}

	public int getNombreSalle() {
		return nombreSalle;
	}

	public void setNombreSalle(int nombreSalle) {
		this.nombreSalle = nombreSalle;
	}

}
