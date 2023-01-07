package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Cours;

public interface IDaoCours {

	int inserer(Cours compte);

	void modifier(Cours compte);

	void supprimer(int idCompte);

	Cours retrouver(int idCompte);

	List<Cours> listerTout();

}
