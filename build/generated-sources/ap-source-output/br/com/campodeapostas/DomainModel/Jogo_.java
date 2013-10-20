package br.com.campodeapostas.DomainModel;

import br.com.campodeapostas.DomainModel.Estadio;
import br.com.campodeapostas.DomainModel.Fase;
import br.com.campodeapostas.DomainModel.Selecao;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-19T17:31:12")
@StaticMetamodel(Jogo.class)
public class Jogo_ { 

    public static volatile SingularAttribute<Jogo, Long> id;
    public static volatile SingularAttribute<Jogo, Selecao> selecao2;
    public static volatile SingularAttribute<Jogo, Integer> placar1;
    public static volatile SingularAttribute<Jogo, Integer> placar2;
    public static volatile SingularAttribute<Jogo, Estadio> estadio;
    public static volatile SingularAttribute<Jogo, Selecao> selecao1;
    public static volatile SingularAttribute<Jogo, Fase> fase;
    public static volatile SingularAttribute<Jogo, Date> dataJogo;

}