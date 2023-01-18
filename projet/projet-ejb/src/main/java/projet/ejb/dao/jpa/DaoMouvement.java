package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoCompte;
import projet.ejb.dao.IDaoMouvement;
import projet.ejb.data.Compte;
import projet.ejb.data.Mouvement;

@Stateless
@Local
@TransactionAttribute(MANDATORY)
public class DaoMouvement implements IDaoMouvement {
	@PersistenceContext
	private EntityManager em;
	@Inject
	private IDaoCompte dao;
	// Actions

	@Override
	public int inserer(int idCpt, Mouvement mouvement) {
		Compte c = dao.retrouver(idCpt);
		c.setSolde(c.getSolde() - mouvement.getMontant());
		em.persist(mouvement);
		em.flush();
		dao.modifier(c);
		return mouvement.getId();
	}

	@Override
	public void modifier(Mouvement mouvement) {
		em.merge(mouvement);
	}

	@Override
	public void supprimer(int idMvt) {
		em.remove(retrouver(idMvt));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public Mouvement retrouver(int idMvt) {
		return em.find(Mouvement.class, idMvt);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<Mouvement> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Mouvement c";
		var query = em.createQuery(jpql, Mouvement.class);
		return query.getResultList();
	}

	@Override
	public List<Mouvement> listPerso(int idCompte) {
		String jpql = "SELECT c FROM Mouvement c WHERE c.cpt.id = :id";
		var res = em.createQuery(jpql, Mouvement.class);
		res.setParameter("id", idCompte);
		return res.getResultList();
	}
}
