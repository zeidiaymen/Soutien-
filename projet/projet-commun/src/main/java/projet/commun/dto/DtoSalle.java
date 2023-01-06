package projet.commun.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DtoSalle implements Serializable{

	private int id;
	private int nombreSalle;
	private List<DtoCours> cours;
	
	
	public DtoSalle() {
		super();
	}


	public DtoSalle(int id, int nombreSalle, List<DtoCours> cours) {
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


	public List<DtoCours> getCours() {
		return cours;
	}


	public void setCours(List<DtoCours> cours) {
		this.cours = cours;
	}
	
	
	
}
