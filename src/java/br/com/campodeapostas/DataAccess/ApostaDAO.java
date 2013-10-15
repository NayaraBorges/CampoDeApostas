/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DataAccess;

import br.com.campodeapostas.DomainModel.Aposta;
import br.com.campodeapostas.DomainModel.IApostaRepositorio;
import br.com.campodeapostas.DomainModel.Jogo;
import br.com.campodeapostas.DomainModel.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author NAYARA
 */
@Stateless
public class ApostaDAO extends DAOGenerico<Aposta> implements IApostaRepositorio{

    public ApostaDAO() {
        super(Aposta.class);
    }
    
    @Override
    public Long getID(Aposta obj){
        return obj.getId();
    }

    @Override
    public List<Aposta> listarTodos() {
        Query query=(Query) manager.createQuery("select u from Aposta u");
        return query.getResultList();
    }

    @Override
    public List<Aposta> listarPorData(Date dataAposta) {
        Query query=(Query) manager.createQuery("select u from Aposta u where u.dataAposta=:p");
        query.setParameter("p", dataAposta);
        return query.getResultList();
    }

    @Override
    public List<Aposta> listarPorJogo(Jogo jogo) {
        Query query=(Query) manager.createQuery("select u from Aposta u where u.jogo=:p");
        query.setParameter("p", jogo);
        return query.getResultList();
    }

    @Override
    public List<Aposta> listarPorUsuario(Usuario usuario) {
        Query query=(Query) manager.createQuery("select u from Aposta u where u.usuario=:p");
        query.setParameter("p", usuario);
        return query.getResultList();
    }
    
    
    
}
