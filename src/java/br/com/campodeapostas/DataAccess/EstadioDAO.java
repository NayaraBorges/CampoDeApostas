/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DataAccess;

import br.com.campodeapostas.DomainModel.Estadio;
import br.com.campodeapostas.DomainModel.IEstadioRepositorio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author NAYARA
 */
@Stateless
public class EstadioDAO extends DAOGenerico<Estadio> implements IEstadioRepositorio{

    public EstadioDAO() {
        super(Estadio.class);
    }
    
    @Override
    public Long getID(Estadio obj){
        return obj.getId();
    }

    @Override
    public List<Estadio> listarTodos() {
        Query query=(Query) manager.createQuery("select u from Estadio u");
        return query.getResultList();
    }

    @Override
    public List<Estadio> listarPorCidade(String cidade) {
        Query query=(Query) manager.createQuery("select u from Estadio u where u.cidade=:p");
        query.setParameter("p", cidade);
        return query.getResultList();
    }

    @Override
    public List<Estadio> listarPorNome(String nome) {
        Query query=(Query) manager.createQuery("select u from Estadio u where u.nome=:p");
        query.setParameter("p", nome);
        return query.getResultList();
    }

    @Override
    public List<Estadio> listarPorEstado(String estado) {
        Query query=(Query) manager.createQuery("select u from Estadio u where u.estado=:p");
        query.setParameter("p", estado);
        return query.getResultList();
    }   
    
}
