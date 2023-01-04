package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Enfant;


public interface IDaoEnfant {

	int			inserer( Enfant compte );

	void 		modifier( Enfant compte );

	void 		supprimer( int idCompte );

	Enfant 		retrouver( int idCompte );

	List<Enfant> listerTout();

	

}
