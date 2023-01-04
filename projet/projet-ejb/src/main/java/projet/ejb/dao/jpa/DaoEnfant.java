package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoEnfant;
import projet.ejb.data.Compte;
import projet.ejb.data.Enfant;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEnfant implements IDaoEnfant {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Enfant compte) {
		em.persist(compte);
		em.flush();
		return compte.getId();
	}

	@Override
	public void modifier(Enfant compte) {
		em.merge( compte );
	}

	@Override
	public void supprimer(int idCompte) {
		em.remove( retrouver(idCompte) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Enfant retrouver(int idCompte) {
		return em.find( Enfant.class, idCompte );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Enfant> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Enfant c ORDER BY c.nom";
		var query = em.createQuery( jpql, Enfant.class );
		return query.getResultList();
	}



	
}
