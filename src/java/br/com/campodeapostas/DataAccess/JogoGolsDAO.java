/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DataAccess;


import br.com.campodeapostas.DomainModel.IJogoGolsRepositorio;
import br.com.campodeapostas.DomainModel.Jogador;
import br.com.campodeapostas.DomainModel.Jogo;
import br.com.campodeapostas.DomainModel.JogoGols;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author NAYARA
 */
@Stateless
public class JogoGolsDAO extends DAOGenerico<JogoGols> implements IJogoGolsRepositorio{

    public JogoGolsDAO() {
        super(JogoGols.class);
    }
    
    @Override
    public Long getID(JogoGols obj){
        return obj.getId();
    }

    @Override
    public List<JogoGols> listarTodos() {
        Query query=(Query) manager.createQuery("select u from JogoGols u");
        return query.getResultList();
    }

    @Override
    public List<JogoGols> listarPorJogador(Jogador jogador) {
        Query query=(Query) manager.createQuery("select u from JogoGols u where u.jogador=:p");
        query.setParameter("p", jogador);
        return query.getResultList();
    }

    @Override
    public List<JogoGols> listarPorJogo(Jogo jogo) {
        Query query=(Query) manager.createQuery("select u from JogoGols u where u.jogo=:p");
        query.setParameter("p", jogo);
        return query.getResultList();
    }
    
    
    
}
