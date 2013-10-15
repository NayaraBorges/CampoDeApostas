/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DataAccess;


import br.com.campodeapostas.DomainModel.Grupo;
import br.com.campodeapostas.DomainModel.IGrupoRepositorio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author NAYARA
 */
@Stateless
public class GrupoDAO extends DAOGenerico<Grupo> implements IGrupoRepositorio{

    public GrupoDAO() {
        super(Grupo.class);
    }
    
    @Override
    public Long getID(Grupo obj){
        return obj.getId();
    }

    @Override
    public List<Grupo> listarTodos() {
        Query query=(Query) manager.createQuery("select u from Grupo u");
        return query.getResultList();
    }

    @Override
    public List<Grupo> listarPorDescricao(String descricao) {
        Query query=(Query) manager.createQuery("select u from Grupo u where u.descricao=:p");
        query.setParameter("p", descricao);
        return query.getResultList();
    }
    
    
    
}
