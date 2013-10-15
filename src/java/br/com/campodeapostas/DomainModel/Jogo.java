/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Nayara
 */
@Entity
@Table(name="Jogo")
public class Jogo implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;
    @ManyToOne
    private Fase fase;
    @ManyToOne
    private Selecao selecao1;
    @ManyToOne
    private Selecao selecao2;
    @Column(name="Placar1")
    private int placar1;
    @Column(name="Placar2")
    private int placar2;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataJogo;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date hora;
    @OneToOne
    private Estadio estadio;
    

    public Date getData() {
        return dataJogo;
    }

    
    public void setData(Date dataJogo) {
        this.dataJogo = dataJogo;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPlacar1() {
        return placar1;
    }

    public void setPlacar1(int placar1) {
        this.placar1 = placar1;
    }

    public int getPlacar2() {
        return placar2;
    }

    public void setPlacar2(int placar2) {
        this.placar2 = placar2;
    }

    public Selecao getSelecao1() {
        return selecao1;
    }

    public void setSelecao1(Selecao selecao1) {
        this.selecao1 = selecao1;
    }

    public Selecao getSelecao2() {
        return selecao2;
    }

    public void setSelecao2(Selecao selecao2) {
        this.selecao2 = selecao2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.fase);
        hash = 43 * hash + Objects.hashCode(this.selecao1);
        hash = 43 * hash + Objects.hashCode(this.selecao2);
        hash = 43 * hash + this.placar1;
        hash = 43 * hash + this.placar2;
        hash = 43 * hash + Objects.hashCode(this.dataJogo);
        hash = 43 * hash + Objects.hashCode(this.hora);
        hash = 43 * hash + Objects.hashCode(this.estadio);
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
        final Jogo other = (Jogo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fase, other.fase)) {
            return false;
        }
        if (!Objects.equals(this.selecao1, other.selecao1)) {
            return false;
        }
        if (!Objects.equals(this.selecao2, other.selecao2)) {
            return false;
        }
        if (this.placar1 != other.placar1) {
            return false;
        }
        if (this.placar2 != other.placar2) {
            return false;
        }
        if (!Objects.equals(this.dataJogo, other.dataJogo)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.estadio, other.estadio)) {
            return false;
        }
        return true;
    }
    
}
