/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DataAccess;


import br.com.campodeapostas.DomainModel.ApostaGols;
import br.com.campodeapostas.DomainModel.IJogadorRepositorio;
import br.com.campodeapostas.DomainModel.Jogador;
import br.com.campodeapostas.DomainModel.Selecao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author NAYARA
 */
@Stateless
public class JogadorDAO extends DAOGenerico<Jogador> implements IJogadorRepositorio{

    public JogadorDAO() {
        super(ApostaGols.class);
    }
    
    @Override
    public Long getID(Jogador obj){
        return obj.getId();
    }

    @Override
    public List<Jogador> listarTodos() {
        Query query=(Query) manager.createQuery("select u from Jogador u");
        return query.getResultList();
    }

    @Override
    public List<Jogador> listarPorNome(String nome) {
        Query query=(Query) manager.createQuery("select u from Jogador u where u.nome=:p");
        query.setParameter("p", nome);
        return query.getResultList();
    }

    @Override
    public List<Jogador> listarPorSelecao(Selecao selecao) {
        Query query=(Query) manager.createQuery("select u from Jogador u where u.selecao=:p");
        query.setParameter("p", selecao);
        return query.getResultList();
    }
    
    
    
}
