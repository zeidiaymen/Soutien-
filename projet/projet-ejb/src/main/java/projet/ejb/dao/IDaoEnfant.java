package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Enfant;
import projet.ejb.data.MethodePayement;

public interface IDaoEnfant {

	int inserer(Enfant compte);

	void modifier(Enfant compte);

	void supprimer(int idCompte);

	Enfant retrouver(int idCompte);

	List<Enfant> listerTout();

	boolean affecterCours(int idEnfant, int idCours , MethodePayement methode);
	List<Enfant> listPerso(int idCompte);
}
