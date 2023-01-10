package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoSalle;
import projet.commun.exception.ExceptionValidation;

public interface IServiceSalle {

	int inserer(DtoSalle dtoSalle) throws ExceptionValidation;

	void modifier(DtoSalle dtoSalle) throws ExceptionValidation;

	void supprimer(int idSalle) throws ExceptionValidation;

	DtoSalle retrouver(int idSalle);

	List<DtoSalle> listerTout();

}
