/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DomainModel;

/**
 *
 * @author Nayara
 */
public enum Posicao {
    
    Goleiro ("Goleiro"),
    Zagueiro ("Zagueiro"),
    Lateral_direito ("Lateral direito"),
    Lateral_esquerdo ("Lateral esquerdo"),
    Volante ("Volante"),
    Meio_de_campo ("Meio de campo"),
    Atacante ("Atacante");
    
    public String nome;
    
    Posicao(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    } 
  
}
