/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;

import br.com.campodeapostas.DomainModel.IPosicaoRepositorio;
import br.com.campodeapostas.DomainModel.Posicao;
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
@Named(value = "posicaoConverter")
@SessionScoped
public class PosicaoConverter implements Serializable, Converter {

    @EJB
    IPosicaoRepositorio daoPosicao;
    
    /**
     * Creates a new instance of PosicaoConverter
     */
    public PosicaoConverter() {
    }
    
     @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoPosicao.abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Posicao p = (Posicao) value;
            return p.getId().toString();
        }
    }
    
}
