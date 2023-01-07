package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoMouvement;
import projet.commun.exception.ExceptionValidation;

public interface IServiceMouvement {

	int inserer(DtoMouvement dtoMouvement) throws ExceptionValidation;

	void modifier(DtoMouvement dtoMouvement) throws ExceptionValidation;

	void supprimer(int idMouvement) throws ExceptionValidation;

	DtoMouvement retrouver(int idMouvement);

	List<DtoMouvement> listerTout();

}
