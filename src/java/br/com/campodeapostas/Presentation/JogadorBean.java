/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;


import br.com.campodeapostas.DomainModel.IJogadorRepositorio;
import br.com.campodeapostas.DomainModel.IPosicaoRepositorio;
import br.com.campodeapostas.DomainModel.ISelecaoRepositorio;
import br.com.campodeapostas.DomainModel.Jogador;
import br.com.campodeapostas.DomainModel.Posicao;
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
@Named(value = "jogador")
@SessionScoped
public class JogadorBean implements Serializable{

    @EJB
    IJogadorRepositorio repo;
    
    @EJB
    ISelecaoRepositorio daoSelecao;
    
    @EJB
    IPosicaoRepositorio daoPosicao;
    
    Long id;
    String nome;
    int numeroCamisa;
    Selecao selecao;
    Posicao posicao;
    List<Selecao> listagemSelecoes;
    List<Posicao> listagemPosicoes;
    
    List<Jogador> listagem;
    Jogador jogador;
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String voltar() {
        listagem = null;
        return "TemplateGlobal.xhtml";
    }
        
    public JogadorBean(){
        id = 0L;
        nome = "";
        numeroCamisa = 0; 
    }

     public void abrir(){
        if(id > 0)
            setJogador(repo.abrir(id));
    }
    
    public String editar(){
        abrir();
        return "salvarJogador.xhtml";
    }
    
    public String apagar(){
         try {
            abrir();
            repo.apagar(jogador);
            listagem = null;
            exibirMensagem("Excluído com sucesso!");
            return "listarJogador.xhtml";
        } catch (Exception e) {
            exibirMensagem("Erro. Jogador não pode ser excluído pois já foi utilizado em outro cadastro.");
            return null;
        }      
    }
    
    public void salvar(){
        abrir();
        
        if(jogador == null)
            jogador = new Jogador();
        
        jogador.setNome(nome);
        jogador.setNumeroCamisa(numeroCamisa);
        jogador.setSelecao(selecao);
        jogador.setPosicao(posicao);
        
        repo.salvar(jogador);
        exibirMensagem("Salvo com Sucesso!");
    }
   
    public List<Jogador> getListagem() {
        if (listagem == null){
            listagem = repo.listarTodos();
        }
        return listagem;
    }

    public void setListagem(List<Jogador> listagem) {
        this.listagem = listagem;
    }
        
    public IJogadorRepositorio getRepo() {
        return repo;
    }

    public void setRepo(IJogadorRepositorio repo) {
        this.repo = repo;
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

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public Selecao getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }

  
    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
        this.nome = jogador.getNome();
        this.numeroCamisa = jogador.getNumeroCamisa();
        this.selecao = jogador.getSelecao();
        this.posicao = jogador.getPosicao();
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public List<Selecao> getListagemSelecoes() {
        return daoSelecao.listarTodos();
    }

    public void setListagemSelecoes(List<Selecao> listagemSelecoes) {
        this.listagemSelecoes = listagemSelecoes;
    }       
    
    public List<Posicao> getListagemPosicoes() {
        return daoPosicao.listarTodos();
    }

    public void setListagemPosicoes(List<Posicao> listagemPosicoes) {
        this.listagemPosicoes = listagemPosicoes;
    }

}
