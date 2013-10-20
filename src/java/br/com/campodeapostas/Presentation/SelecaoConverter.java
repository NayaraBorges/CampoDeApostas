/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;

import br.com.campodeapostas.DomainModel.ISelecaoRepositorio;
import br.com.campodeapostas.DomainModel.Selecao;
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
@Named(value = "selecaoConverter")
@SessionScoped
public class SelecaoConverter implements Serializable, Converter{

    @EJB
    ISelecaoRepositorio daoSelecao;
    /**
     * Creates a new instance of SelecaoConverter
     */
    public SelecaoConverter() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoSelecao.abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Selecao s = (Selecao) value;
            return s.getId().toString();
        }
    }
    
}
