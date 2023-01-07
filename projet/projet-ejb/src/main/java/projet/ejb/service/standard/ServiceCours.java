package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoCours;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCours;
import projet.ejb.dao.IDaoCours;
import projet.ejb.data.Cours;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceCours implements IServiceCours {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private IDaoCours daoCours;

	// Actions

	@Override
	public int inserer(DtoCours dtoCours) throws ExceptionValidation {

		int id = daoCours.inserer(mapper.mapCours(dtoCours));
		return id;
	}

	@Override
	public void modifier(DtoCours dtoCorus) throws ExceptionValidation {

		daoCours.modifier(mapper.mapCours(dtoCorus));

	}

	@Override
	public void supprimer(int idCours) throws ExceptionValidation {
		daoCours.supprimer(idCours);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoCours retrouver(int idCompte) {
		return mapper.mapCours(daoCours.retrouver(idCompte));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoCours> listerTout() {
		List<DtoCours> liste = new ArrayList<>();
		for (Cours compte : daoCours.listerTout()) {
			liste.add(mapper.mapCours(compte));
		}
		return liste;
	}

}
