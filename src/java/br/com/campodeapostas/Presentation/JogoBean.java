/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;

import br.com.campodeapostas.DomainModel.Estadio;
import br.com.campodeapostas.DomainModel.Fase;
import br.com.campodeapostas.DomainModel.IEstadioRepositorio;
import br.com.campodeapostas.DomainModel.IFaseRepositorio;
import br.com.campodeapostas.DomainModel.IJogoRepositorio;
import br.com.campodeapostas.DomainModel.ISelecaoRepositorio;
import br.com.campodeapostas.DomainModel.Jogo;
import br.com.campodeapostas.DomainModel.Selecao;
import java.io.Serializable;
import java.util.Date;
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
@Named(value = "jogo")
@SessionScoped
public class JogoBean implements Serializable{

    @EJB
    IJogoRepositorio repo;

    @EJB
    ISelecaoRepositorio daoSelecao;
    
    @EJB
    IFaseRepositorio daoFase;
    
    @EJB
    IEstadioRepositorio daoEstadio;
    
    Long id;
    Fase fase;
    Selecao selecao1;
    Selecao selecao2;
    int placar1;
    int placar2;
    Date data;
    Estadio estadio;
    List<Selecao> listagemSelecoes;
    List<Fase> listagemFases;
    List<Estadio> listagemEstadios;
    
    List<Jogo> listagem;
    Jogo jogo;
    
    public String apostar(){
        return "jogos.html";
    }
    
    
    public void faseGrupo(){
        listagem = repo.listarPorFase(daoFase.abrir(1L));
        
    }
    
    public void oitavas(){
        listagem = repo.listarPorFase(daoFase.abrir(2L));
    }
    
    public void quartas(){
        
    }
    
    public void semiFinais(){
        
    }
    
    public void terceiroLugar(){
        
    }
    
    public void primeiroLugar(){
        
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String voltar() {
        listagem = null;
        return "TemplateGlobal.xhtml";
    }
    
    public JogoBean (){
        id = 0L;
        placar1 = 0;
        placar2 = 0;        
    }
    
    public void abrir(){
        if(id > 0)
            setJogo(repo.abrir(id));
    }
    
    public String editar(){
        abrir();
        return "salvarJogo.xhtml";
    }
    
    public String apagar(){
       try {
            abrir();
            repo.apagar(jogo);
            listagem = null;
            exibirMensagem("Excluído com sucesso!");
            return "listarJogo.xhtml";
        } catch (Exception e) {
            exibirMensagem("Erro. Jogo não pode ser excluído pois já foi utilizado em outro cadastro.");
            return null;
        }      
    }
    
    public void salvar(){
        abrir();
        
        if(jogo == null)
            jogo = new Jogo();
        
        jogo.setData(data);
        jogo.setEstadio(estadio);
        jogo.setFase(fase);
        jogo.setPlacar1(placar1);
        jogo.setPlacar2(placar2);
        jogo.setSelecao1(selecao1);
        jogo.setSelecao2(selecao2);
      
        repo.salvar(jogo);
        exibirMensagem("Salvo com Sucesso!");
    }

    public IJogoRepositorio getRepo() {
        return repo;
    }

    public void setRepo(IJogoRepositorio repo) {
        this.repo = repo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Selecao getSelecao1() {
        return selecao1;
    }

    public void setSelecao1(Selecao selecao1) {
        this.selecao1 = selecao1;
    }

    public Selecao getSelecao2() {
        return selecao2;
    }

    public void setSelecao2(Selecao selecao2) {
        this.selecao2 = selecao2;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }
    
    public List<Jogo> getListagem() {
       if (listagem == null){
            listagem = repo.listarTodos();
        }
        return listagem;
    }

    public void setListagem(List<Jogo> listagem) {
        this.listagem = listagem;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
        this.estadio = jogo.getEstadio();
        this.fase = jogo.getFase();
        this.placar1 = jogo.getPlacar1();
        this.placar2 = jogo.getPlacar2();
        this.selecao1 = jogo.getSelecao1();
        this.selecao2 = jogo.getSelecao2();
       
    }
    
     public List<Selecao> getListagemSelecoes() {
        return daoSelecao.listarTodos();
    }

    public void setListagemSelecoes(List<Selecao> listagemSelecoes) {
        this.listagemSelecoes = listagemSelecoes;
    }

    public List<Fase> getListagemFases() {
        return daoFase.listarTodos();
    }

    public void setListagemFases(List<Fase> listagemFases) {
        this.listagemFases = listagemFases;
    }

    public List<Estadio> getListagemEstadios() {
        return daoEstadio.listarTodos();
    }

    public void setListagemEstadios(List<Estadio> listagemEstadios) {
        this.listagemEstadios = listagemEstadios;
    }

    
}
