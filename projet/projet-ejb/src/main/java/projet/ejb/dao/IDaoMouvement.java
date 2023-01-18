package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Enfant;
import projet.ejb.data.Mouvement;

public interface IDaoMouvement {

	int inserer(int idMvt ,Mouvement mvt);

	void modifier(Mouvement mvt);

	void supprimer(int idMvt);

	Mouvement retrouver(int idMvt);

	List<Mouvement> listerTout();
	List<Mouvement> listPerso(int idCompte);

}
