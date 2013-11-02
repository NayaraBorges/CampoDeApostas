/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;

import br.com.campodeapostas.DomainModel.IUsuarioRepositorio;
import br.com.campodeapostas.DomainModel.Usuario;
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
@Named(value = "usuario")
@SessionScoped
public class UsuarioBean implements Serializable{

    @EJB
    IUsuarioRepositorio repo;
    
    
    Long id;
    String login;
    String senha;
    int ranking;
    Boolean administrador;
    
    List<Usuario> listagem;
    Usuario usuario;
    
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String voltar() {
        listagem = null;
        return "TemplateGlobal.xhtml";
    }
    
    public UsuarioBean (){
        id = 0L;
        administrador = false;
    }
    
    public void abrir(){
        if(id > 0)
            setUsuario(repo.abrir(id));
    }
    
    public String editar(){
        abrir();
        return "salvarUsuario.xhtml";
    }
    
    public String apagar(){
       try {
            abrir();
            repo.apagar(usuario);
            listagem = null;
            exibirMensagem("Excluído com sucesso!");
            return "listarUsuario.xhtml";
        } catch (Exception e) {
            exibirMensagem("Erro. Usuario não pode ser excluído.");
            return null;
        }      
    }
    
    public void salvar(){
        abrir();
        
        if(usuario == null)
            usuario = new Usuario();
        
        usuario.setAdministrador(administrador);
        usuario.setLogin(login);
        usuario.setRanking(ranking);
        usuario.setSenha(senha);
      
        repo.salvar(usuario);
        exibirMensagem("Salvo com Sucesso!");
    }

    public IUsuarioRepositorio getRepo() {
        return repo;
    }

    public void setRepo(IUsuarioRepositorio repo) {
        this.repo = repo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.administrador = usuario.getAdministrador();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.ranking = usuario.getRanking();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public List<Usuario> getListagem() {
         if (listagem == null){
            listagem = repo.listarTodos();
        }
         return listagem;
    }
    
}
