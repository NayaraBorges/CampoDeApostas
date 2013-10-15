/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DomainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Nayara
 */
@Entity
@Table(name="ApostaGols")
public class ApostaGols implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @ManyToOne
    private Aposta aposta;
    @OneToOne
    private Jogador jogador;

    public Aposta getAposta() {
        return aposta;
    }

    public void setAposta(Aposta aposta) {
        this.aposta = aposta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.aposta);
        hash = 89 * hash + Objects.hashCode(this.jogador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ApostaGols other = (ApostaGols) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.aposta, other.aposta)) {
            return false;
        }
        if (!Objects.equals(this.jogador, other.jogador)) {
            return false;
        }
        return true;
    }
    
    
    
}
