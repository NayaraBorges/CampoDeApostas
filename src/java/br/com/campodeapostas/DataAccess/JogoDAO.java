/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DataAccess;


import br.com.campodeapostas.DomainModel.Estadio;
import br.com.campodeapostas.DomainModel.Fase;
import br.com.campodeapostas.DomainModel.IJogoRepositorio;
import br.com.campodeapostas.DomainModel.Jogo;
import br.com.campodeapostas.DomainModel.Selecao;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
/**
 *
 * @author NAYARA
 */
@Stateless
public class JogoDAO extends DAOGenerico<Jogo> implements IJogoRepositorio{

    public JogoDAO() {
        super(Jogo.class);
    }
    
    @Override
    public Long getID(Jogo obj){
        return obj.getId();
    }

    @Override
    public List<Jogo> listarTodos() {
        Query query=(Query) manager.createQuery("select u from Jogo u");
        return query.getResultList();
    }

    @Override
    public List<Jogo> listarPorFase(Fase fase) {
        Query query=(Query) manager.createQuery("select u from Jogo u where u.fase=:p");
        query.setParameter("p", fase);
        return query.getResultList();
    }

    @Override
    public List<Jogo> listarPorDataJogo(Date dataJogo) {
        Query query=(Query) manager.createQuery("select u from Jogo u where u.dataJogo=:p");
        query.setParameter("p", dataJogo);
        return query.getResultList();
    }

    @Override
    public List<Jogo> listarPorSelecao(Selecao selecao) {
        Query query=(Query) manager.createQuery("select u from Jogo u where u.selecao=:p");
        query.setParameter("p", selecao);
        return query.getResultList();
    }

    @Override
    public List<Jogo> listarPorEstadio(Estadio estadio) {
        Query query=(Query) manager.createQuery("select u from Jogo u where u.estadio=:p");
        query.setParameter("p", estadio);
        return query.getResultList();
    }
    
    
    
}
