package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoCours;
import projet.ejb.data.Cours;
@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoCours implements IDaoCours {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int inserer(Cours cours) {
		em.persist(cours);
		em.flush();
		return cours.getId();
	}

	@Override
	public void modifier(Cours cours) {
		em.merge(cours);

	}

	@Override
	public void supprimer(int idCours) {
		em.remove(em.getReference(Cours.class, idCours));

	}

	@TransactionAttribute(NOT_SUPPORTED)

	@Override
	public Cours retrouver(int idCours) {

		return em.find(Cours.class, idCours);
	}

	@TransactionAttribute(NOT_SUPPORTED)

	@Override
	public List<Cours> listerTout() {
		String jpql = "SELECT c FROM Cours c";
		var res = em.createQuery(jpql, Cours.class);
		return res.getResultList();
	}

}
