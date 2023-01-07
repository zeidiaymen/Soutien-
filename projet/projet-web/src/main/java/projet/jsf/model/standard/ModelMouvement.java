package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoMouvement;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceMouvement;
import projet.jsf.data.Compte;
import projet.jsf.data.Mouvement;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelMouvement implements Serializable {

	// Champs

	private List<Mouvement> liste;

	private Mouvement courant;

	@EJB
	private IServiceMouvement serviceMouvement;

	@Inject
	private IMapper mapper;

	// Getters

	public List<Mouvement> getListe() {
		if (liste == null) {
			liste = new ArrayList<>();
			for (DtoMouvement dto : serviceMouvement.listerTout()) {
				liste.add(mapper.mapMouvement(dto));
			}
		}
		return liste;
	}

	public Mouvement getCourant() {
		if (courant == null) {
			courant = new Mouvement();
		}
		return courant;
	}

	// Initialisaitons

	public String actualiserCourant() {
		if (courant != null) {
			DtoMouvement dto = serviceMouvement.retrouver(courant.getId());
			if (dto == null) {
				UtilJsf.messageError("Le mouvement demandé n'existe pas");
				return "test/liste";
			} else {
				courant = mapper.mapMouvement(dto);
			}
		}
		return null;
	}

	// Actions

	public String validerMiseAJour() {
		try {
			if (courant.getId() == null) {
				serviceMouvement.inserer(mapper.mapMouvement(courant));
			} else {
				serviceMouvement.modifier(mapper.mapMouvement(courant));
			}
			UtilJsf.messageInfo("Mise à jour effectuée avec succès.");
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public String supprimer(Compte item) {
		try {
			serviceMouvement.supprimer(item.getId());
			liste.remove(item);
			UtilJsf.messageInfo("Suppression effectuée avec succès.");
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
		}
		return null;
	}

}
