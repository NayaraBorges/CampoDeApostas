/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;

import br.com.campodeapostas.DomainModel.Grupo;
import br.com.campodeapostas.DomainModel.IGrupoRepositorio;
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
@Named(value = "grupoConverter")
@SessionScoped
public class GrupoConverter implements Serializable, Converter {

    @EJB
    IGrupoRepositorio daoGrupo;
    /**
     * Creates a new instance of GrupoConverter
     */
    public GrupoConverter() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoGrupo.abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Grupo g = (Grupo) value;
            return g.getId().toString();
        }
    }
    
}
