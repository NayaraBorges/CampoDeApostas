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
    
    GOLEIRO ("Goleiro"),
    ZAGUEIRO ("Zagueiro"),
    LATERAL_DIREITO ("Lateral direito"),
    LATERAL_ESQUERDO ("Lateral esquerdo"),
    VOLANTE ("Volante"),
    MEIO_DE_CAMPO ("Meio de campo"),
    ATACANTE ("Atacante");
    
    public String nome;
    
    Posicao(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    } 
  
}
