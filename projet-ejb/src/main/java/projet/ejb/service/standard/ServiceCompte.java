package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoCompte;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCompte;
import projet.ejb.dao.IDaoCompte;
import projet.ejb.data.Compte;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceCompte implements IServiceCompte {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoCompte daoCompte;

	// Actions

	@Override
	public int inserer(DtoCompte dtoCompte) throws ExceptionValidation {
		verifierValiditeDonnees(dtoCompte);
		int id = daoCompte.inserer(mapper.map(dtoCompte));
		return id;
	}

	@Override
	public void modifier(DtoCompte dtoCompte) throws ExceptionValidation {
		verifierValiditeDonnees(dtoCompte);
		daoCompte.modifier(mapper.map(dtoCompte));
	}

	@Override
	public void supprimer(int idCompte) throws ExceptionValidation {
		daoCompte.supprimer(idCompte);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoCompte retrouver(int idCompte) {
		return mapper.map(daoCompte.retrouver(idCompte));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoCompte> listerTout() {
		List<DtoCompte> liste = new ArrayList<>();
		for (Compte compte : daoCompte.listerTout()) {
			liste.add(mapper.map(compte));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoCompte dtoCompte) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoCompte.getPseudo() == null || dtoCompte.getPseudo().isEmpty()) {
			message.append("\nLe pseudo est absent.");
		} else if (dtoCompte.getPseudo().length() < 3) {
			message.append("\nLe pseudo est trop court.");
		} else if (dtoCompte.getPseudo().length() > 25) {
			message.append("\nLe pseudo est trop long.");
		} else if (!daoCompte.verifierUnicitePseudo(dtoCompte.getPseudo(), dtoCompte.getId())) {
			message.append("\nLe pseudo " + dtoCompte.getPseudo() + " est déjà utilisé.");
		}

		if (dtoCompte.getMotDePasse() == null || dtoCompte.getMotDePasse().isEmpty()) {
			message.append("\nLe mot de passe est absent.");
		} else if (dtoCompte.getMotDePasse().length() < 3) {
			message.append("\nLe mot de passe est trop court.");
		} else if (dtoCompte.getMotDePasse().length() > 25) {
			message.append("\nLe mot de passe est trop long.");
		}

		if (dtoCompte.getEmail() == null || dtoCompte.getEmail().isEmpty()) {
			message.append("\nL'adresse e-mail est absente.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
