/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DomainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Nayara
 */
@Entity
@Table(name="JogoGols")
public class JogoGols implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;
    @Column(name="Quantidade")
    private int quantidade;
    @OneToOne
    private Jogador jogador;
    @ManyToOne
    private Jogo jogo;

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

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + this.quantidade;
        hash = 29 * hash + Objects.hashCode(this.jogador);
        hash = 29 * hash + Objects.hashCode(this.jogo);
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
        final JogoGols other = (JogoGols) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.jogador, other.jogador)) {
            return false;
        }
        if (!Objects.equals(this.jogo, other.jogo)) {
            return false;
        }
        return true;
    }
    
}
