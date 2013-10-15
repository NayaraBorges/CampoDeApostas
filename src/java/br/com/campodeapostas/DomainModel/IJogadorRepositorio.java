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
public interface IJogadorRepositorio extends IRepositorio <Jogador>{
    List<Jogador> listarPorNome(String nome);
    List<Jogador> listarPorSelecao(Selecao selecao);
}
