package br.com.campodeapostas.DomainModel;

import br.com.campodeapostas.DomainModel.Jogador;
import br.com.campodeapostas.DomainModel.Jogo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-18T09:45:51")
@StaticMetamodel(JogoGols.class)
public class JogoGols_ { 

    public static volatile SingularAttribute<JogoGols, Long> id;
    public static volatile SingularAttribute<JogoGols, Integer> quantidade;
    public static volatile SingularAttribute<JogoGols, Jogador> jogador;
    public static volatile SingularAttribute<JogoGols, Jogo> jogo;

}