/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;


import br.com.campodeapostas.DomainModel.Grupo;
import br.com.campodeapostas.DomainModel.IGrupoRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Nayara
 */
@Named(value = "grupo")
@SessionScoped
public class GrupoBean implements Serializable{

    @EJB
    IGrupoRepositorio repo;
    
    Long id;
    String descricao;
    
    List<Grupo> listagem;
    Grupo grupo;

    public GrupoBean() {
       id = 0L;
       descricao = "" ;
    }
           
    public void abrir(){
        if(id > 0)
            setGrupo(repo.abrir(id));
    }
    
    public String editar(){
        abrir();
        return "salvarGrupo.xhtml";
    }
    
    public String apagar(){
        abrir();
        repo.apagar(grupo);
        listagem = null;
        return "listarGrupo.xhtml";
    }
    
    public void salvar(){
        abrir();
        
        if(grupo == null)
            grupo = new Grupo();
        
        grupo.setDescricao(descricao);
        
        repo.salvar(grupo);
    }

    public IGrupoRepositorio getRepo() {
        return repo;
    }

    public void setRepo(IGrupoRepositorio repo) {
        this.repo = repo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Grupo> getListagem() {
        if(listagem == null){
            listagem = repo.listarTodos();
        }
        return listagem;
    }

    public void setListagem(List<Grupo> listagem) {
        this.listagem = listagem;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
        this.descricao = grupo.getDescricao();
    }
    
    
    

}
