package br.com.campodeapostas.DomainModel;

import br.com.campodeapostas.DomainModel.Aposta;
import br.com.campodeapostas.DomainModel.Jogador;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-22T20:04:17")
@StaticMetamodel(ApostaGols.class)
public class ApostaGols_ { 

    public static volatile SingularAttribute<ApostaGols, Long> id;
    public static volatile SingularAttribute<ApostaGols, Aposta> aposta;
    public static volatile SingularAttribute<ApostaGols, Jogador> jogador;

}