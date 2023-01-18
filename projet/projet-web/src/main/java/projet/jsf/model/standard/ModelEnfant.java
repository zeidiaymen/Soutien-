package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoEnfant;
import projet.commun.dto.MethodePayement;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceEnfant;
import projet.jsf.data.Compte;
import projet.jsf.data.Enfant;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelEnfant implements Serializable {

	// Champs

	public void setCourant(Enfant courant) {
		this.courant = courant;
	}

	private Enfant temp;
	private List<Enfant> liste;
	private String id;
	private String methode;
	private Enfant courant;

	@EJB
	private IServiceEnfant serviceCompte;

	@Inject
	private IMapper mapper;

	@Inject
	private ModelCours model;

	@Inject
	private ModelCompte compte;
	@Inject
	private CompteActif compteActif ;
	// Getters

	public List<Enfant> getListe() {
		if (liste == null) {
			liste = new ArrayList<>();
			Compte p = compte.getListe().stream()
					.filter((a) -> a.getPseudo().equals(compteActif.getIdConnectedUser())).findFirst().get();
			System.out.println("compte sssssssssssssssssssss" + p.getId());

			for (DtoEnfant dto : serviceCompte.listPerso(p.getId())) {
				liste.add(mapper.mapEnfant(dto));
			}
		}
		return liste;
	}

	public Enfant getCourant() {
		if (courant == null) {
			courant = new Enfant();
		}
		return courant;
	}

	// Initialisaitons

	public String actualiserCourant() {
		if (courant != null) {
			DtoEnfant dto = serviceCompte.retrouver(courant.getId());
			if (dto == null) {
				UtilJsf.messageError("L'enfant demandé n'existe pas");
				return "test/liste";
			} else {
				courant = mapper.mapEnfant(dto);
			}
		}
		return null;
	}

	// Actions

	public String validerMiseAJour() {
		try {
			if (courant.getId() == null) {
				Compte p = compte.getListe().stream()
						.filter((a) -> a.getPseudo().equals(compteActif.getIdConnectedUser())).findFirst().get();
				courant.setCompte(p);
				serviceCompte.inserer(mapper.mapEnfant(courant));
			} else {

				serviceCompte.modifier(mapper.mapEnfant(courant));
			}
			UtilJsf.messageInfo("Mise à jour effectuée avec succès.");
			return "liste";

		} catch (Exception e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public String validerAffectation() {
		try {
			serviceCompte.affecterEnfant(Integer.parseInt(temp.toString().substring(11, 12)),
					model.getCourant().getId(), MethodePayement.valueOf(methode));
			return "liste";
		} catch (Exception e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public String supprimer(Enfant item) {
		try {
			serviceCompte.supprimer(item.getId());
			liste.remove(item);
			UtilJsf.messageInfo("Suppression effectuée avec succès.");
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
		}
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Enfant getTemp() {
		return temp;
	}

	public void setTemp(Enfant temp) {
		this.temp = temp;
	}

	public String getMethode() {
		return methode;
	}

	public void setMethode(String methode) {
		this.methode = methode;
	}
}
