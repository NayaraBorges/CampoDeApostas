/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DataAccess;


import br.com.campodeapostas.DomainModel.IRepositorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NAYARA
 */
public abstract class DAOGenerico <T> implements IRepositorio<T>{

    private Class type;
    
    @PersistenceContext(name = "CampoDeApostasPU")
    protected EntityManager manager;
    
    protected EntityManager getManager() {
        return manager;
    }
    
    public DAOGenerico(Class t) {
        type = t;
    }   
    
    @Override
    public boolean salvar(T obj) {
         try {
            getManager().merge(obj);
            getManager().flush();            
            return true;
        } catch (Exception e) {  
            e.printStackTrace();
            return false;          
        }
    }

    @Override
    public T abrir(long id) {
        return (T)getManager().find(type, id);
    }
    
    
    @Override
    public boolean apagar(T obj) {
       try {
           T x = (T)getManager().getReference(type, getID(obj));
            getManager().remove(x);
            return true;
        } catch (Exception e) {  
            e.printStackTrace();
            return false;  
        }
    }

    @Override
    public abstract List<T> listarTodos();

    public abstract Long getID(T obj);
    
    
}
