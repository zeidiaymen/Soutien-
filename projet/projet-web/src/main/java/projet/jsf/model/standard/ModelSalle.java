package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoSalle;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceSalle;
import projet.jsf.data.Salle;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelSalle implements Serializable {
	
	// Champs
	
	private List<Salle>	liste;
	
	private Salle			courant;
	
	@EJB
	private IServiceSalle	serviceSalle;
	
	@Inject
	private IMapper			mapper;

	
	// Getters 
	
	public List<Salle> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoSalle dto : serviceSalle.listerTout() ) {
				liste.add( mapper.mapSalle( dto ) );
			}
		}
		return liste;
	}
	
		public Salle getCourant() {
			if ( courant == null ) {
				courant = new Salle();
			}
			return courant;
		}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoSalle dto = serviceSalle.retrouver( courant.getId() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "La salle demandé n'existe pas" );
				return "test/liste";
			} else {
				courant = mapper.mapSalle( dto );
			}
		}
		return null;
	}
	
	
	// Actions
	
	/*public String validerMiseAJour() {
		try {
			if ( courant == null) {
				serviceCompte.inserer( mapper.mapSalle(courant) );
			} else {
				serviceCompte.modifier( mapper.mapSalle(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
			
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}*/
	
	public String supprimer( Salle item ) {
		try {
			serviceSalle.supprimer( item.getId() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
}
