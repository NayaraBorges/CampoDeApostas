/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DomainModel;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nayara
 */
@Local
public interface IRepositorio <T>{
    boolean salvar (T obj);
    T abrir (long id);
    boolean apagar (T obj);
    List<T> listarTodos();
}
