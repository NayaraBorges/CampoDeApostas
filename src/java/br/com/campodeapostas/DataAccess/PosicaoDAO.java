/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DataAccess;

import br.com.campodeapostas.DomainModel.Fase;
import br.com.campodeapostas.DomainModel.IPosicaoRepositorio;
import br.com.campodeapostas.DomainModel.Posicao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author NAYARA
 */
@Stateless
public class PosicaoDAO extends DAOGenerico<Posicao> implements IPosicaoRepositorio{

    public PosicaoDAO() {
        super(Posicao.class);
    }
    
    @Override
    public Long getID(Posicao obj){
        return obj.getId();
    }

    @Override
    public List<Posicao> listarTodos() {
        Query query=(Query) manager.createQuery("select u from Posicao u");
        return query.getResultList();
    }

    @Override
    public List<Posicao> listarPorDescricao(String descricao) {
        Query query=(Query) manager.createQuery("select u from Posicao u where u.descricao=:p");
        query.setParameter("p", descricao);
        return query.getResultList();
    }    
    
}
