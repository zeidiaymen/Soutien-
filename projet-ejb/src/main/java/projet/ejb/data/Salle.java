package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salle implements Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idsalle")
	private int id;
	private int nombreSalle = 46;
	@Column(name = "cours")
	@OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
	private List<Cours> cours;
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
