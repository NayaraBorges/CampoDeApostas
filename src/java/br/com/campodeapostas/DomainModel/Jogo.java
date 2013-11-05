/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataJogo;
    @OneToOne
    private Estadio estadio;
    @OneToMany
    private List<JogoGols> listaGols1;
    @OneToMany
    private List<JogoGols> listaGols2;

    public Date getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(Date dataJogo) {
        this.dataJogo = dataJogo;
    }

    public List<JogoGols> getListaGols1() {
        return listaGols1;
    }

    public void setListaGols1(List<JogoGols> listaGols1) {
        this.listaGols1 = listaGols1;
    }

    public List<JogoGols> getListaGols2() {
        return listaGols2;
    }

    public void setListaGols2(List<JogoGols> listaGols2) {
        this.listaGols2 = listaGols2;
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
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.fase);
        hash = 17 * hash + Objects.hashCode(this.selecao1);
        hash = 17 * hash + Objects.hashCode(this.selecao2);
        hash = 17 * hash + this.placar1;
        hash = 17 * hash + this.placar2;
        hash = 17 * hash + Objects.hashCode(this.dataJogo);
        hash = 17 * hash + Objects.hashCode(this.estadio);
        hash = 17 * hash + Objects.hashCode(this.listaGols1);
        hash = 17 * hash + Objects.hashCode(this.listaGols2);
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
        if (!Objects.equals(this.estadio, other.estadio)) {
            return false;
        }
        if (!Objects.equals(this.listaGols1, other.listaGols1)) {
            return false;
        }
        if (!Objects.equals(this.listaGols2, other.listaGols2)) {
            return false;
        }
        return true;
    }
    
    
}