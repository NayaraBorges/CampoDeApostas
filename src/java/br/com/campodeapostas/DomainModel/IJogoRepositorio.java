/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DomainModel;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nayara
 */
@Local
public interface IJogoRepositorio extends IRepositorio <Jogo>{
    List<Jogo> listarPorFase(Fase fase);
    List<Jogo> listarPorDataJogo(Date dataJogo);
    List<Jogo> listarPorSelecao(Selecao selecao);
    List<Jogo> listarPorEstadio(Estadio estadio);
    
}
