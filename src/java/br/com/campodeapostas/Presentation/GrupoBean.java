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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String voltar() {
        listagem = null;
        return "TemplateGlobal.xhtml";
    }
        
    public GrupoBean() {
       id = 0L;
       descricao = "" ;
    }
           
    public void abrir(){
        if(id > 0){
            Grupo tmp = repo.abrir(id);
            setGrupo(tmp);
        }
    }
    
    public String editar(){
        abrir();
        return "salvarGrupo.xhtml";
    }
    
    public String apagar(){
         try {
            abrir();
            repo.apagar(grupo);
            listagem = null;
            exibirMensagem("Excluído com sucesso!");
            return "listarGrupo.xhtml";
        } catch (Exception e) {
            exibirMensagem("Erro. Grupo não pode ser excluído pois já foi utilizado em outro cadastro.");
            return null;
        }      
    }
    
    public void salvar(){
        abrir();
        
        if(grupo == null)
            grupo = new Grupo();
        
        grupo.setDescricao(descricao);
        
        repo.salvar(grupo);
        listagem = null;
        exibirMensagem("Salvo com Sucesso!");
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
