package projet.ejb.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoCours;
import projet.commun.dto.DtoEnfant;
import projet.commun.dto.DtoMouvement;
import projet.commun.dto.DtoSalle;
import projet.ejb.data.Compte;
import projet.ejb.data.Cours;
import projet.ejb.data.Crenaux;
import projet.ejb.data.Enfant;
import projet.ejb.data.MethodePayement;
import projet.ejb.data.Mouvement;
import projet.ejb.data.Salle;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-09T22:59:37+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 18.0.2 (Eclipse Adoptium)"
)
@ApplicationScoped
public class IMapperEjbImpl implements IMapperEjb {

    @Override
    public Compte map(DtoCompte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setEmail( source.getEmail() );
        compte.setId( source.getId() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            compte.setRoles( new ArrayList<String>( list ) );
        }
        compte.setSolde( source.getSolde() );

        return compte;
    }

    @Override
    public DtoCompte map(Compte source) {
        if ( source == null ) {
            return null;
        }

        DtoCompte dtoCompte = new DtoCompte();

        dtoCompte.setEmail( source.getEmail() );
        dtoCompte.setId( source.getId() );
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoCompte.setRoles( new ArrayList<String>( list ) );
        }
        dtoCompte.setSolde( source.getSolde() );

        return dtoCompte;
    }

    @Override
    public Enfant mapEnfant(DtoEnfant source) {
        if ( source == null ) {
            return null;
        }

        Enfant enfant = new Enfant();

        enfant.setCreneau( source.getCreneau() );
        enfant.setDateDeNaissance( source.getDateDeNaissance() );
        enfant.setId( source.getId() );
        enfant.setMethodePayement( methodePayementToMethodePayement( source.getMethodePayement() ) );
        enfant.setNiveauEtude( source.getNiveauEtude() );
        enfant.setNom( source.getNom() );
        enfant.setPrenom( source.getPrenom() );

        return enfant;
    }

    @Override
    public DtoEnfant mapEnfant(Enfant source) {
        if ( source == null ) {
            return null;
        }

        DtoEnfant dtoEnfant = new DtoEnfant();

        dtoEnfant.setCreneau( source.getCreneau() );
        dtoEnfant.setDateDeNaissance( source.getDateDeNaissance() );
        dtoEnfant.setId( source.getId() );
        dtoEnfant.setMethodePayement( methodePayementToMethodePayement1( source.getMethodePayement() ) );
        dtoEnfant.setNiveauEtude( source.getNiveauEtude() );
        dtoEnfant.setNom( source.getNom() );
        dtoEnfant.setPrenom( source.getPrenom() );

        return dtoEnfant;
    }

    @Override
    public DtoCours mapCours(Cours source) {
        if ( source == null ) {
            return null;
        }

        DtoCours dtoCours = new DtoCours();

        dtoCours.setCapacite( source.getCapacite() );
        dtoCours.setCrenaux( crenauxToCrenaux( source.getCrenaux() ) );
        dtoCours.setId( source.getId() );
        dtoCours.setLibelle( source.getLibelle() );
        dtoCours.setPrix( source.getPrix() );
        dtoCours.setSalle( mapSalle( source.getSalle() ) );

        return dtoCours;
    }

    @Override
    public Cours mapCours(DtoCours source) {
        if ( source == null ) {
            return null;
        }

        Cours cours = new Cours();

        cours.setCrenaux( crenauxToCrenaux1( source.getCrenaux() ) );
        cours.setPrix( source.getPrix() );
        cours.setLibelle( source.getLibelle() );
        cours.setCapacite( source.getCapacite() );
        cours.setId( source.getId() );
        cours.setSalle( mapSalle( source.getSalle() ) );

        return cours;
    }

    @Override
    public DtoMouvement mapMouvement(Mouvement source) {
        if ( source == null ) {
            return null;
        }

        DtoMouvement dtoMouvement = new DtoMouvement();

        dtoMouvement.setId( source.getId() );
        dtoMouvement.setMontant( source.getMontant() );

        return dtoMouvement;
    }

    @Override
    public Mouvement mapMouvement(DtoMouvement source) {
        if ( source == null ) {
            return null;
        }

        Mouvement mouvement = new Mouvement();

        mouvement.setId( source.getId() );
        mouvement.setMontant( source.getMontant() );

        return mouvement;
    }

    @Override
    public DtoSalle mapSalle(Salle source) {
        if ( source == null ) {
            return null;
        }

        DtoSalle dtoSalle = new DtoSalle();

      //  dtoSalle.setCours( coursListToDtoCoursList( source.getCours() ) );
        dtoSalle.setId( source.getId() );
        dtoSalle.setNombreSalle( source.getNombreSalle() );

        return dtoSalle;
    }

    @Override
    public Salle mapSalle(DtoSalle source) {
        if ( source == null ) {
            return null;
        }

        Salle salle = new Salle();

      //  salle.setCours( dtoCoursListToCoursList( source.getCours() ) );
        salle.setId( source.getId() );
        salle.setNombreSalle( source.getNombreSalle() );

        return salle;
    }

    protected MethodePayement methodePayementToMethodePayement(projet.commun.dto.MethodePayement methodePayement) {
        if ( methodePayement == null ) {
            return null;
        }

        MethodePayement methodePayement1;

        switch ( methodePayement ) {
            case CHEQUE: methodePayement1 = MethodePayement.CHEQUE;
            break;
            case ESPECE: methodePayement1 = MethodePayement.ESPECE;
            break;
            case VERSEMENT: methodePayement1 = MethodePayement.VERSEMENT;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + methodePayement );
        }

        return methodePayement1;
    }

    protected projet.commun.dto.MethodePayement methodePayementToMethodePayement1(MethodePayement methodePayement) {
        if ( methodePayement == null ) {
            return null;
        }

        projet.commun.dto.MethodePayement methodePayement1;

        switch ( methodePayement ) {
            case CHEQUE: methodePayement1 = projet.commun.dto.MethodePayement.CHEQUE;
            break;
            case ESPECE: methodePayement1 = projet.commun.dto.MethodePayement.ESPECE;
            break;
            case VERSEMENT: methodePayement1 = projet.commun.dto.MethodePayement.VERSEMENT;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + methodePayement );
        }

        return methodePayement1;
    }

    protected projet.commun.dto.Crenaux crenauxToCrenaux(Crenaux crenaux) {
        if ( crenaux == null ) {
            return null;
        }

        projet.commun.dto.Crenaux crenaux1;

        switch ( crenaux ) {
            case APRESMIDI_DIMANCHE: crenaux1 = projet.commun.dto.Crenaux.APRESMIDI_DIMANCHE;
            break;
            case APRESMIDI_SAMEDI: crenaux1 = projet.commun.dto.Crenaux.APRESMIDI_SAMEDI;
            break;
            case MATIN_DIMANCHE: crenaux1 = projet.commun.dto.Crenaux.MATIN_DIMANCHE;
            break;
            case MATIN_SAMEDI: crenaux1 = projet.commun.dto.Crenaux.MATIN_SAMEDI;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + crenaux );
        }

        return crenaux1;
    }

    protected Crenaux crenauxToCrenaux1(projet.commun.dto.Crenaux crenaux) {
        if ( crenaux == null ) {
            return null;
        }

        Crenaux crenaux1;

        switch ( crenaux ) {
            case APRESMIDI_DIMANCHE: crenaux1 = Crenaux.APRESMIDI_DIMANCHE;
            break;
            case APRESMIDI_SAMEDI: crenaux1 = Crenaux.APRESMIDI_SAMEDI;
            break;
            case MATIN_DIMANCHE: crenaux1 = Crenaux.MATIN_DIMANCHE;
            break;
            case MATIN_SAMEDI: crenaux1 = Crenaux.MATIN_SAMEDI;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + crenaux );
        }

        return crenaux1;
    }

    protected List<DtoCours> coursListToDtoCoursList(List<Cours> list) {
        if ( list == null ) {
            return null;
        }

        List<DtoCours> list1 = new ArrayList<DtoCours>( list.size() );
        for ( Cours cours : list ) {
            list1.add( mapCours( cours ) );
        }

        return list1;
    }

    protected List<Cours> dtoCoursListToCoursList(List<DtoCours> list) {
        if ( list == null ) {
            return null;
        }

        List<Cours> list1 = new ArrayList<Cours>( list.size() );
        for ( DtoCours dtoCours : list ) {
            list1.add( mapCours( dtoCours ) );
        }

        return list1;
    }
}
