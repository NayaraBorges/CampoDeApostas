/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;

import br.com.campodeapostas.DomainModel.Estadio;
import br.com.campodeapostas.DomainModel.IEstadioRepositorio;
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
@Named(value = "estadioConverter")
@SessionScoped
public class EstadioConverter implements Serializable, Converter {

    @EJB
    IEstadioRepositorio daoEstadio;
    /**
     * Creates a new instance of GrupoConverter
     */
    public EstadioConverter() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoEstadio.abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Estadio e = (Estadio) value;
            return e.getId().toString();
        }
    }
    
}
