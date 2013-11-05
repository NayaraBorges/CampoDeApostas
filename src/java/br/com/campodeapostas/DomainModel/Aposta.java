/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    @OneToMany
    private List<ApostaGols> listaGols1;
    @OneToMany
    private List<ApostaGols> listaGols2;

    public List<ApostaGols> getListaGols1() {
        return listaGols1;
    }

    public void setListaGols1(List<ApostaGols> listaGols1) {
        this.listaGols1 = listaGols1;
    }

    public List<ApostaGols> getListaGols2() {
        return listaGols2;
    }

    public void setListaGols2(List<ApostaGols> listaGols2) {
        this.listaGols2 = listaGols2;
    }

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
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.dataAposta);
        hash = 59 * hash + this.placar1;
        hash = 59 * hash + this.placar2;
        hash = 59 * hash + Objects.hashCode(this.usuario);
        hash = 59 * hash + Objects.hashCode(this.jogo);
        hash = 59 * hash + Objects.hashCode(this.listaGols1);
        hash = 59 * hash + Objects.hashCode(this.listaGols2);
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
        if (!Objects.equals(this.listaGols1, other.listaGols1)) {
            return false;
        }
        if (!Objects.equals(this.listaGols2, other.listaGols2)) {
            return false;
        }
        return true;
    }

   
}
