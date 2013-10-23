/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;


import br.com.campodeapostas.DomainModel.IPosicaoRepositorio;
import br.com.campodeapostas.DomainModel.Posicao;
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
@Named(value = "posicao")
@SessionScoped
public class PosicaoBean implements Serializable{
    @EJB
    IPosicaoRepositorio repo;

    Long id;
    String descricao;

    List<Posicao> listagem;
    Posicao posicao;
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String voltar() {
        listagem = null;
        return "TemplateGlobal.xhtml";
    }
        
    public PosicaoBean() {
        id = 0L;
        descricao = "";
    }
    
    public void abrir(){
        if(id > 0)
            setPosicao(repo.abrir(id));
    }
    
    public String editar(){
        abrir();
        return "salvarPosicao.xhtml";
    }
    
    public String apagar(){
        try {
            abrir();
            repo.apagar(posicao);
            listagem = null;
            exibirMensagem("Excluído com sucesso!");
            return "listarPosicao.xhtml";
        } catch (Exception e) {
            exibirMensagem("Erro. Posicao não pode ser excluída pois já foi utilizada em outro cadastro.");
            return null;
        }      
    }
    
    public void salvar(){
        abrir();
        
        if(posicao == null)
            posicao = new Posicao();
        
        posicao.setDescricao(descricao);
        
        repo.salvar(posicao);
        listagem = null;
        exibirMensagem("Salvo com Sucesso!");
    }    

    public IPosicaoRepositorio getRepo() {
        return repo;
    }

    public void setRepo(IPosicaoRepositorio repo) {
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

    public List<Posicao> getListagem() {
        if(listagem == null){
            listagem = repo.listarTodos();
        }
        return listagem;
    }

    public void setListagem(List<Posicao> listagem) {
        this.listagem = listagem;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
        this.descricao = posicao.getDescricao();
    }    
    
}
