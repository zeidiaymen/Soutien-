package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoEnfant;
import projet.commun.exception.ExceptionValidation;


public interface IServiceEnfant {
	
	int				inserer( DtoEnfant dtoCompte ) throws ExceptionValidation;

	void			modifier( DtoEnfant dtoCompte ) throws ExceptionValidation; 

	void			supprimer( int idCompte ) throws ExceptionValidation;

	DtoEnfant 		retrouver( int idCompte ) ;

	List<DtoEnfant>	listerTout() ;

}
