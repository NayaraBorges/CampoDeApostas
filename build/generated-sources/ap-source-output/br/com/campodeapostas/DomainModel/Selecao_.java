package br.com.campodeapostas.DomainModel;

import br.com.campodeapostas.DomainModel.Grupo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-22T00:36:58")
@StaticMetamodel(Selecao.class)
public class Selecao_ { 

    public static volatile SingularAttribute<Selecao, Long> id;
    public static volatile SingularAttribute<Selecao, Grupo> grupo;
    public static volatile SingularAttribute<Selecao, String> nome;
    public static volatile SingularAttribute<Selecao, String> tecnico;

}