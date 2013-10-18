package br.com.campodeapostas.DomainModel;

import br.com.campodeapostas.DomainModel.Jogo;
import br.com.campodeapostas.DomainModel.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-18T09:45:51")
@StaticMetamodel(Aposta.class)
public class Aposta_ { 

    public static volatile SingularAttribute<Aposta, Long> id;
    public static volatile SingularAttribute<Aposta, Jogo> jogo;
    public static volatile SingularAttribute<Aposta, Integer> placar1;
    public static volatile SingularAttribute<Aposta, Integer> placar2;
    public static volatile SingularAttribute<Aposta, Usuario> usuario;
    public static volatile SingularAttribute<Aposta, Date> dataAposta;

}