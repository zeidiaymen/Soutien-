package projet.jsf.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoCours;
import projet.commun.dto.DtoEnfant;
import projet.commun.dto.DtoMouvement;
import projet.commun.dto.DtoSalle;
import projet.jsf.data.Compte;
import projet.jsf.data.Cours;
import projet.jsf.data.Crenaux;
import projet.jsf.data.Enfant;
import projet.jsf.data.MethodePayement;
import projet.jsf.data.Mouvement;
import projet.jsf.data.Salle;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-07T13:12:34+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 18.0.2 (Eclipse Adoptium)"
)
@ApplicationScoped
public class IMapperImpl implements IMapper {

    @Override
    public Compte map(DtoCompte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setEmail( source.getEmail() );
        compte.setId( source.getId() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setMouvements( dtoMouvementListToMouvementList( source.getMouvements() ) );
        compte.setPseudo( source.getPseudo() );
        List<String> list1 = source.getRoles();
        if ( list1 != null ) {
            compte.setRoles( new ArrayList<String>( list1 ) );
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
        if ( source.getId() != null ) {
            dtoCompte.setId( source.getId() );
        }
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setMouvements( mouvementListToDtoMouvementList( source.getMouvements() ) );
        dtoCompte.setPseudo( source.getPseudo() );
        List<String> list1 = source.getRoles();
        if ( list1 != null ) {
            dtoCompte.setRoles( new ArrayList<String>( list1 ) );
        }
        dtoCompte.setSolde( source.getSolde() );

        return dtoCompte;
    }

    @Override
    public Compte duplicate(Compte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setEmail( source.getEmail() );
        if ( source.getId() != null ) {
            compte.setId( source.getId() );
        }
        compte.setMotDePasse( source.getMotDePasse() );
        List<Mouvement> list = source.getMouvements();
        if ( list != null ) {
            compte.setMouvements( new ArrayList<Mouvement>( list ) );
        }
        compte.setPseudo( source.getPseudo() );
        List<String> list1 = source.getRoles();
        if ( list1 != null ) {
            compte.setRoles( new ArrayList<String>( list1 ) );
        }
        compte.setSolde( source.getSolde() );

        return compte;
    }

    @Override
    public Compte update(Compte target, Compte source) {
        if ( source == null ) {
            return target;
        }

        target.setEmail( source.getEmail() );
        if ( source.getId() != null ) {
            target.setId( source.getId() );
        }
        target.setMotDePasse( source.getMotDePasse() );
        if ( target.getMouvements() != null ) {
            List<Mouvement> list = source.getMouvements();
            if ( list != null ) {
                target.getMouvements().clear();
                target.getMouvements().addAll( list );
            }
            else {
                target.setMouvements( null );
            }
        }
        else {
            List<Mouvement> list = source.getMouvements();
            if ( list != null ) {
                target.setMouvements( new ArrayList<Mouvement>( list ) );
            }
        }
        target.setPseudo( source.getPseudo() );
        if ( target.getRoles() != null ) {
            List<String> list1 = source.getRoles();
            if ( list1 != null ) {
                target.getRoles().clear();
                target.getRoles().addAll( list1 );
            }
            else {
                target.setRoles( null );
            }
        }
        else {
            List<String> list1 = source.getRoles();
            if ( list1 != null ) {
                target.setRoles( new ArrayList<String>( list1 ) );
            }
        }
        target.setSolde( source.getSolde() );

        return target;
    }

    @Override
    public Enfant mapEnfant(DtoEnfant source) {
        if ( source == null ) {
            return null;
        }

        Enfant enfant = new Enfant();

        enfant.setCompte( map( source.getCompte() ) );
        enfant.setCours( mapCours( source.getCours() ) );
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

        dtoEnfant.setCompte( map( source.getCompte() ) );
        dtoEnfant.setCours( mapCours( source.getCours() ) );
        dtoEnfant.setCreneau( source.getCreneau() );
        dtoEnfant.setDateDeNaissance( source.getDateDeNaissance() );
        if ( source.getId() != null ) {
            dtoEnfant.setId( source.getId() );
        }
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
        dtoCours.setEnfant( mapEnfant( source.getEnfant() ) );
        if ( source.getId() != null ) {
            dtoCours.setId( source.getId() );
        }
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

        cours.setCapacite( source.getCapacite() );
        cours.setCrenaux( crenauxToCrenaux1( source.getCrenaux() ) );
        cours.setEnfant( mapEnfant( source.getEnfant() ) );
        cours.setId( source.getId() );
        cours.setLibelle( source.getLibelle() );
        cours.setPrix( source.getPrix() );
        cours.setSalle( mapSalle( source.getSalle() ) );

        return cours;
    }

    @Override
    public DtoMouvement mapMouvement(Mouvement source) {
        if ( source == null ) {
            return null;
        }

        DtoMouvement dtoMouvement = new DtoMouvement();

        dtoMouvement.setCompte( map( source.getCompte() ) );
        if ( source.getId() != null ) {
            dtoMouvement.setId( source.getId() );
        }
        dtoMouvement.setMontant( source.getMontant() );

        return dtoMouvement;
    }

    @Override
    public Mouvement mapMouvement(DtoMouvement source) {
        if ( source == null ) {
            return null;
        }

        Mouvement mouvement = new Mouvement();

        mouvement.setCompte( map( source.getCompte() ) );
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

        dtoSalle.setCours( coursListToDtoCoursList( source.getCours() ) );
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

        salle.setCours( dtoCoursListToCoursList( source.getCours() ) );
        salle.setId( source.getId() );
        salle.setNombreSalle( source.getNombreSalle() );

        return salle;
    }

    protected List<Mouvement> dtoMouvementListToMouvementList(List<DtoMouvement> list) {
        if ( list == null ) {
            return null;
        }

        List<Mouvement> list1 = new ArrayList<Mouvement>( list.size() );
        for ( DtoMouvement dtoMouvement : list ) {
            list1.add( mapMouvement( dtoMouvement ) );
        }

        return list1;
    }

    protected List<DtoMouvement> mouvementListToDtoMouvementList(List<Mouvement> list) {
        if ( list == null ) {
            return null;
        }

        List<DtoMouvement> list1 = new ArrayList<DtoMouvement>( list.size() );
        for ( Mouvement mouvement : list ) {
            list1.add( mapMouvement( mouvement ) );
        }

        return list1;
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
