package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoEnfant;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceEnfant;
import projet.ejb.dao.IDaoEnfant;
import projet.ejb.data.Enfant;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceEnfant implements IServiceEnfant {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoEnfant daoCompte;

	// Actions

	@Override
	public int inserer(DtoEnfant dtoCompte) throws ExceptionValidation {

		int id = daoCompte.inserer(mapper.mapEnfant(dtoCompte));
		return id;
	}

	@Override
	public void modifier(DtoEnfant dtoCompte) throws ExceptionValidation {

		daoCompte.modifier(mapper.mapEnfant(dtoCompte));
	
	}

	@Override
	public void supprimer(int idCompte) throws ExceptionValidation {
		daoCompte.supprimer(idCompte);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoEnfant retrouver(int idCompte) {
		return mapper.mapEnfant(daoCompte.retrouver(idCompte));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoEnfant> listerTout() {
		List<DtoEnfant> liste = new ArrayList<>();
		for (Enfant compte : daoCompte.listerTout()) {
			liste.add(mapper.mapEnfant(compte));
		}
		return liste;
	}

}
