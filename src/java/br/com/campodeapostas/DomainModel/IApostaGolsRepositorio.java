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
public interface IApostaGolsRepositorio extends IRepositorio <ApostaGols>{
    List<ApostaGols> listarPorAposta(Aposta aposta);
    List<ApostaGols> listarPorJogador(Jogador jogador);
}
