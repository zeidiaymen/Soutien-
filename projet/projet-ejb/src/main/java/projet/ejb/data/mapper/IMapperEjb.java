package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoCours;
import projet.commun.dto.DtoEnfant;
import projet.commun.dto.DtoMouvement;
import projet.commun.dto.DtoSalle;
import projet.ejb.data.Compte;
import projet.ejb.data.Cours;
import projet.ejb.data.Enfant;
import projet.ejb.data.Mouvement;
import projet.ejb.data.Salle;

@Mapper(componentModel = "cdi")
public interface IMapperEjb {

	static final IMapperEjb INSTANCE = Mappers.getMapper(IMapperEjb.class);

	// Compte

	Compte map(DtoCompte source);

	DtoCompte map(Compte source);

	Enfant mapEnfant(DtoEnfant source);

	DtoEnfant mapEnfant(Enfant source);

	DtoCours mapCours(Cours source);

	Cours mapCours(DtoCours source);

	DtoMouvement mapMouvement(Mouvement source);

	Mouvement mapMouvement(DtoMouvement source);

	DtoSalle mapSalle(Salle source);

	Salle mapSalle(DtoSalle source);
}
