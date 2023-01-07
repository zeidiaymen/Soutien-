package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoSalle;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceSalle;
import projet.ejb.dao.IDaoSalle;
import projet.ejb.data.Salle;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceSalle implements IServiceSalle {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoSalle daoSalle;

	// Actions

	@Override
	public int inserer(DtoSalle DtoSalle) throws ExceptionValidation {

		int id = daoSalle.inserer(mapper.mapSalle(DtoSalle));
		return id;
	}

	@Override
	public void modifier(DtoSalle dtoSalle) throws ExceptionValidation {

		daoSalle.modifier(mapper.mapSalle(dtoSalle));

	}

	@Override
	public void supprimer(int idSalle) throws ExceptionValidation {
		daoSalle.supprimer(idSalle);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoSalle retrouver(int idSalle) {
		return mapper.mapSalle(daoSalle.retrouver(idSalle));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoSalle> listerTout() {
		List<DtoSalle> liste = new ArrayList<>();
		for (Salle salle : daoSalle.listerTout()) {
			liste.add(mapper.mapSalle(salle));
		}
		return liste;
	}

}
