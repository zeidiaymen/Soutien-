package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoMouvement;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceMouvement;
import projet.ejb.dao.IDaoMouvement;
import projet.ejb.data.Mouvement;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceMouvement implements IServiceMouvement {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoMouvement daoMouvement;

	// Actions

	@Override
	public int inserer(DtoMouvement DtoMouvement) throws ExceptionValidation {

		int id = daoMouvement.inserer(DtoMouvement.getCompte().getId() ,mapper.mapMouvement(DtoMouvement));
		return id;
	}

	@Override
	public void modifier(DtoMouvement dtoMouvement) throws ExceptionValidation {

		daoMouvement.modifier(mapper.mapMouvement(dtoMouvement));

	}

	@Override
	public void supprimer(int idMouvement) throws ExceptionValidation {
		daoMouvement.supprimer(idMouvement);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoMouvement retrouver(int idMvt) {
		return mapper.mapMouvement(daoMouvement.retrouver(idMvt));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoMouvement> listerTout() {
		List<DtoMouvement> liste = new ArrayList<>();
		for (Mouvement mvt : daoMouvement.listerTout()) {
			liste.add(mapper.mapMouvement(mvt));
		}
		return liste;
	}

}
