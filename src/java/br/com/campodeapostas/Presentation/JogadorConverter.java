/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;

import br.com.campodeapostas.DomainModel.IJogadorRepositorio;
import br.com.campodeapostas.DomainModel.Jogador;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Nayara
 */
@Named(value = "jogadorConverter")
@SessionScoped
public class JogadorConverter implements Serializable, Converter {

    @EJB
    IJogadorRepositorio daoJogador;
    /**
     * Creates a new instance of GrupoConverter
     */
    public JogadorConverter() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoJogador.abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Jogador j = (Jogador) value;
            return j.getId().toString();
        }
    }
    
}
