package projet.ejb.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoEnfant;
import projet.ejb.data.Compte;
import projet.ejb.data.Enfant;
import projet.ejb.data.MethodePayement;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-04T09:30:19+0100",
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
}
