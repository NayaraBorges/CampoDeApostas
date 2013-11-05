/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;

import br.com.campodeapostas.DomainModel.Aposta;
import br.com.campodeapostas.DomainModel.ApostaGols;
import br.com.campodeapostas.DomainModel.IApostaRepositorio;
import br.com.campodeapostas.DomainModel.Jogo;
import br.com.campodeapostas.DomainModel.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author Nayara
 */
@Named(value = "aposta")
@SessionScoped
public class ApostaBean implements Serializable{

    @EJB
    IApostaRepositorio repo;   
    
    Long id;
    int placar1;
    int placar2;
    Date dataAposta;
    Usuario usuario;
    List<ApostaGols> listaGols1;
    List<ApostaGols> listaGols2;
    Jogo jogo;
    
    List<Aposta> listagem;
    Aposta aposta;
    
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String voltar() {
        listagem = null;
        return "TemplateGlobal.xhtml";
    }
    
    public ApostaBean (){
        id = 0L;
        placar1 = 0;
        placar2 = 0;        
    }
    
    public void abrir(){
        if(id > 0)
            setAposta(repo.abrir(id));
    }
    
    public String editar(){
        abrir();
        return "salvarAposta.xhtml";
    }
    
    public String apagar(){
       try {
            abrir();
            repo.apagar(aposta);
            listagem = null;
            exibirMensagem("Excluída com sucesso!");
            return "listarAposta.xhtml";
        } catch (Exception e) {
            exibirMensagem("Erro. Aposta não pode ser excluída.");
            return null;
        }      
    }
    
    public void salvar(){
        abrir();
        
        if(aposta == null)
            aposta = new Aposta();
        
        aposta.setDataAposta(dataAposta);
        aposta.setUsuario(usuario);
        aposta.setJogo(jogo);
        aposta.setPlacar1(placar1);
        aposta.setPlacar2(placar2);
      
        repo.salvar(aposta);
        exibirMensagem("Salvo com Sucesso!");
    }
    
    public void salvarJogador1(ValueChangeEvent evento){
        aposta.setListaGols1(listaGols1);
    }
    
    public void salvarJogador2(ValueChangeEvent evento){
        aposta.setListaGols2(listaGols2);
    }

    public IApostaRepositorio getRepo() {
        return repo;
    }

    public void setRepo(IApostaRepositorio repo) {
        this.repo = repo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    public int getPlacar1() {
        return placar1;
    }

    public void setPlacar1(int placar1) {
        this.placar1 = placar1;
    }

    public int getPlacar2() {
        return placar2;
    }

    public void setPlacar2(int placar2) {
        this.placar2 = placar2;
    }

    public Date getDataAposta() {
        return dataAposta;
    }

    public void setDataAposta(Date dataAposta) {
        this.dataAposta = dataAposta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
       
    public List<Aposta> getListagem() {
       if (listagem == null){
            listagem = repo.listarTodos();
        }
        return listagem;
    }

    public void setListagem(List<Aposta> listagem) {
        this.listagem = listagem;
    }

    public List<ApostaGols> getListaGols1() {
        return listaGols1;
    }

    public void setListaGols1(List<ApostaGols> listaGols1) {
        this.listaGols1 = listaGols1;
    }

    public List<ApostaGols> getListaGols2() {
        return listaGols2;
    }

    public void setListaGols2(List<ApostaGols> listaGols2) {
        this.listaGols2 = listaGols2;
    }
    
    public Aposta getAposta() {
        return aposta;
    }

    public void setAposta(Aposta aposta) {
        this.aposta = aposta;
        this.usuario = aposta.getUsuario();
        this.jogo = aposta.getJogo();
        this.placar1 = jogo.getPlacar1();
        this.placar2 = jogo.getPlacar2();
       
    }
    
}
