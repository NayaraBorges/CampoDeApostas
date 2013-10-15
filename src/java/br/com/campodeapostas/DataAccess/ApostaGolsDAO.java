/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DataAccess;

import br.com.campodeapostas.DomainModel.Aposta;
import br.com.campodeapostas.DomainModel.ApostaGols;
import br.com.campodeapostas.DomainModel.IApostaGolsRepositorio;
import br.com.campodeapostas.DomainModel.Jogador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author NAYARA
 */
@Stateless
public class ApostaGolsDAO extends DAOGenerico<ApostaGols> implements IApostaGolsRepositorio{

    public ApostaGolsDAO() {
        super(ApostaGols.class);
    }
    
    @Override
    public Long getID(ApostaGols obj){
        return obj.getId();
    }

    @Override
    public List<ApostaGols> listarTodos() {
        Query query=(Query) manager.createQuery("select u from ApostaGols u");
        return query.getResultList();
    }

    @Override
    public List<ApostaGols> listarPorAposta(Aposta aposta) {
        Query query=(Query) manager.createQuery("select u from ApostaGols u where u.aposta=:p");
        query.setParameter("p", aposta);
        return query.getResultList();
    }

    @Override
    public List<ApostaGols> listarPorJogador(Jogador jogador) {
        Query query=(Query) manager.createQuery("select u from ApostaGols u where u.jogador=:p");
        query.setParameter("p", jogador);
        return query.getResultList();
    }
    
    
    
}
