package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoSalle;
import projet.ejb.data.Salle;

@Stateless
@Local
@TransactionAttribute(MANDATORY)
public class DaoSalle implements IDaoSalle {

	// Champs

	@PersistenceContext
	private EntityManager em;

	// Actions

	@Override
	public int inserer(Salle salle) {
		em.persist(salle);
		em.flush();
		return salle.getId();
	}

	@Override
	public void modifier(Salle salle) {
		em.merge(salle);
	}

	@Override
	public void supprimer(int idSalle) {
		em.remove(retrouver(idSalle));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public Salle retrouver(int idSalle) {
		return em.find(Salle.class, idSalle);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<Salle> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Salle c ORDER BY c.nombreSalle";
		var query = em.createQuery(jpql, Salle.class);
		return query.getResultList();
	}

}
