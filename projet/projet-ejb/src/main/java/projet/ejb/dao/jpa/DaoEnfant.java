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
import projet.ejb.dao.IDaoCours;
import projet.ejb.dao.IDaoEnfant;
import projet.ejb.data.Compte;
import projet.ejb.data.Cours;
import projet.ejb.data.Enfant;
import projet.ejb.data.MethodePayement;

@Stateless
@Local
@TransactionAttribute(MANDATORY)
public class DaoEnfant implements IDaoEnfant {

	// Champs

	@PersistenceContext
	private EntityManager em;
	@Inject
	private IDaoCours daoCours;
	@Inject
	private IDaoCompte daoCompte;

	@Override
	public int inserer(Enfant enfant) {
		System.out.println("testing dao id " + enfant.getCompte().getId());
		em.persist(enfant);
		em.flush();
		return enfant.getId();
	}

	@Override
	public void modifier(Enfant enfant) {
		em.merge(enfant);
	}

	@Override
	public void supprimer(int idCompte) {
		em.remove(retrouver(idCompte));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public Enfant retrouver(int idCompte) {
		return em.find(Enfant.class, idCompte);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<Enfant> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Enfant c ORDER BY c.nom";
		var query = em.createQuery(jpql, Enfant.class);
		return query.getResultList();
	}

	@Override
	public boolean affecterCours(int idEnfant, int idCours, MethodePayement methode) {
		Cours c = daoCours.retrouver(idCours);
		Enfant e = retrouver(idEnfant);
		if (c.getCapacite() > 0) {
			c.setCapacite(c.getCapacite() - 1);
			daoCours.modifier(c);
			e.setCours(c);
			e.setCreneau(c.getCrenaux().toString());
			Compte parent = e.getCompte();
			parent.setSolde(parent.getSolde() + c.getPrix());
			e.setMethodePayement(methode);
			daoCompte.modifier(parent);
			modifier(e);
			return true;
		}

		return false;

	}

}
