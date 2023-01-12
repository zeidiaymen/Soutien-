package projet.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoCours;
import projet.commun.dto.DtoEnfant;
import projet.commun.dto.DtoMouvement;
import projet.commun.dto.DtoSalle;
import projet.jsf.data.Compte;
import projet.jsf.data.Cours;
import projet.jsf.data.Enfant;
import projet.jsf.data.Mouvement;
import projet.jsf.data.Salle;

@Mapper(componentModel = "cdi")
public interface IMapper {

	// Compte

	Compte map(DtoCompte source);

	DtoCompte map(Compte source);

	Compte duplicate(Compte source);

	Compte update(@MappingTarget Compte target, Compte source);

	Enfant mapEnfant(DtoEnfant source);

	DtoEnfant mapEnfant(Enfant source);

	//Enfant duplicate(Enfant source);

//
	Salle mapSalle(DtoSalle source);

	DtoSalle mapSalle(Salle source);

	//Salle duplicate(Salle source);

	DtoCours mapCours(Cours source);

	Cours mapCours(DtoCours source);

	// Cours duplicate(Cours source);

	DtoMouvement mapMouvement(Mouvement source);

	Mouvement mapMouvement(DtoMouvement source);

	// Mouvement duplicate(Mouvement source);

}
