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
public interface IApostaRepositorio extends IRepositorio <Aposta>{
    List<Aposta> listarPorData(Date dataAposta);
    List<Aposta> listarPorJogo(Jogo jogo);
    List<Aposta> listarPorUsuario(Usuario usuario);
}
