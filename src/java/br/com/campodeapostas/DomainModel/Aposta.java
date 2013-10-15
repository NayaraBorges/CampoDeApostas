/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;


/**
 *
 * @author Nayara
 */
@Entity
@Table(name="Aposta")
public class Aposta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ApostaID")
    protected Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAposta;
    @Column(name="Placar1")
    private int placar1;
    @Column(name="Placar2")
    private int placar2;
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Jogo jogo;

    public Date getDataAposta() {
        return dataAposta;
    }

    public void setDataAposta(Date dataAposta) {
        this.dataAposta = dataAposta;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.dataAposta);
        hash = 97 * hash + this.placar1;
        hash = 97 * hash + this.placar2;
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.jogo);
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
        final Aposta other = (Aposta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataAposta, other.dataAposta)) {
            return false;
        }
        if (this.placar1 != other.placar1) {
            return false;
        }
        if (this.placar2 != other.placar2) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.jogo, other.jogo)) {
            return false;
        }
        return true;
    }
    
    
}
