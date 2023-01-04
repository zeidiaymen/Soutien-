package projet.jsf.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoEnfant;
import projet.jsf.data.Compte;
import projet.jsf.data.Enfant;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-04T09:30:20+0100",
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
        if ( source.getId() != null ) {
            dtoCompte.setId( source.getId() );
        }
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoCompte.setRoles( new ArrayList<String>( list ) );
        }

        return dtoCompte;
    }

    @Override
    public Compte duplicate(Compte source) {
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
    public Compte update(Compte target, Compte source) {
        if ( source == null ) {
            return target;
        }

        target.setEmail( source.getEmail() );
        target.setId( source.getId() );
        target.setMotDePasse( source.getMotDePasse() );
        target.setPseudo( source.getPseudo() );
        if ( target.getRoles() != null ) {
            List<String> list = source.getRoles();
            if ( list != null ) {
                target.getRoles().clear();
                target.getRoles().addAll( list );
            }
            else {
                target.setRoles( null );
            }
        }
        else {
            List<String> list = source.getRoles();
            if ( list != null ) {
                target.setRoles( new ArrayList<String>( list ) );
            }
        }

        return target;
    }

    @Override
    public Enfant map(DtoEnfant dto) {
        if ( dto == null ) {
            return null;
        }

        Enfant enfant = new Enfant();

        enfant.setCreneau( dto.getCreneau() );
        enfant.setDateDeNaissance( dto.getDateDeNaissance() );
        enfant.setId( dto.getId() );
        enfant.setMethodePayement( dto.getMethodePayement() );
        enfant.setNiveauEtude( dto.getNiveauEtude() );
        enfant.setNom( dto.getNom() );
        enfant.setPrenom( dto.getPrenom() );

        return enfant;
    }
}
