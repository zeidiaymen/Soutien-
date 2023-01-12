package projet.commun.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DtoSalle implements Serializable{

	private int id;
	private int nombreSalle;

	
	
	public DtoSalle() {
		super();
	}


	public DtoSalle(int id, int nombreSalle) {
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


	
	
	
}
