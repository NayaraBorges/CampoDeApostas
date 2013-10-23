/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;

import br.com.campodeapostas.DomainModel.Grupo;
import br.com.campodeapostas.DomainModel.IGrupoRepositorio;
import br.com.campodeapostas.DomainModel.ISelecaoRepositorio;
import br.com.campodeapostas.DomainModel.Selecao;
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
@Named(value = "selecao")
@SessionScoped
public class SelecaoBean implements Serializable{

    @EJB
    ISelecaoRepositorio repo;
    
    @EJB
    IGrupoRepositorio daoGrupo;
    
    Long id;
    String nome;
    Grupo grupo;
    String tecnico; 
    List<Grupo> listagemGrupos;
    
    List<Selecao> listagem;
    Selecao selecao;
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String voltar() {
        listagem = null;
        return "TemplateGlobal.xhtml";
    }
        
    public SelecaoBean (){
        id = 0L;
        nome = "";
    }

     public void abrir(){
        if(id > 0)
            setSelecao(repo.abrir(id));
    }
    
    public String editar(){
        abrir();
        return "salvarSelecao.xhtml";
    }
    
    public String apagar(){
         try {
            abrir();
            repo.apagar(selecao);
            listagem = null;
            exibirMensagem("Excluído com sucesso!");
            return "listarSelecao.xhtml";
        } catch (Exception e) {
            exibirMensagem("Erro. Selecao não pode ser excluída pois já foi utilizada em outro cadastro.");
            return null;
        }      
    }
    
    public void salvar(){
        abrir();
        
        if(selecao == null)
            selecao = new Selecao();
        
        selecao.setGrupo(grupo);
        selecao.setNome(nome);
        selecao.setTecnico(tecnico);
              
        repo.salvar(selecao);
        exibirMensagem("Salvo com Sucesso!");
    }
    
    public ISelecaoRepositorio getRepo() {
        return repo;
    }

    public void setRepo(ISelecaoRepositorio repo) {
        this.repo = repo;
    }

    public List<Selecao> getListagem() {
        if(listagem == null){
            listagem = repo.listarTodos();
        }
        return listagem;
    }

    public void setListagem(List<Selecao> listagem) {
        this.listagem = listagem;
    }

    public Selecao getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
        this.grupo = selecao.getGrupo();
        this.nome = selecao.getNome();
        this.tecnico = selecao.getTecnico();
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public List<Grupo> getListagemGrupos() {
        return daoGrupo.listarTodos();
    }

    public void setListagemGrupos(List<Grupo> listagemGrupos) {
        this.listagemGrupos = listagemGrupos;
    }

}
