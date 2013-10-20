/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;

import br.com.campodeapostas.DomainModel.Fase;
import br.com.campodeapostas.DomainModel.Grupo;
import br.com.campodeapostas.DomainModel.IFaseRepositorio;
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
@Named(value = "faseConverter")
@SessionScoped
public class FaseConverter implements Serializable, Converter {

    @EJB
    IFaseRepositorio daoFase;
    /**
     * Creates a new instance of GrupoConverter
     */
    public FaseConverter() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoFase.abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Fase f = (Fase) value;
            return f.getId().toString();
        }
    }
    
}
