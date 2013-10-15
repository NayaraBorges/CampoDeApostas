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
@Table(name="Jogador")
public class Jogador implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;
    @Column(name="Nome")
    private String nome;
    @Column(name="NumeroCamisa")
    private int numeroCamisa;
    @ManyToOne
    private Selecao selecao;
    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public Selecao getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }
    private Posicao posicao;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + this.numeroCamisa;
        hash = 79 * hash + Objects.hashCode(this.selecao);
        hash = 79 * hash + Objects.hashCode(this.posicao);
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
        final Jogador other = (Jogador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.numeroCamisa != other.numeroCamisa) {
            return false;
        }
        if (!Objects.equals(this.selecao, other.selecao)) {
            return false;
        }
        if (this.posicao != other.posicao) {
            return false;
        }
        return true;
    }
    
    
}
