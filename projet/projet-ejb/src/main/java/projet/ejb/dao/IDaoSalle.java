package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Salle;


public interface IDaoSalle {

	int			inserer( Salle enfant );

	void 		modifier( Salle enfant );

	void 		supprimer( int idenfant );

	Salle 		retrouver( int idenfant );

	List<Salle> listerTout();

	

}
