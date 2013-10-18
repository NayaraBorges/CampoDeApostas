package br.com.campodeapostas.DomainModel;

import br.com.campodeapostas.DomainModel.Posicao;
import br.com.campodeapostas.DomainModel.Selecao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-18T09:45:51")
@StaticMetamodel(Jogador.class)
public class Jogador_ { 

    public static volatile SingularAttribute<Jogador, Long> id;
    public static volatile SingularAttribute<Jogador, Integer> numeroCamisa;
    public static volatile SingularAttribute<Jogador, Posicao> posicao;
    public static volatile SingularAttribute<Jogador, Selecao> selecao;
    public static volatile SingularAttribute<Jogador, String> nome;

}