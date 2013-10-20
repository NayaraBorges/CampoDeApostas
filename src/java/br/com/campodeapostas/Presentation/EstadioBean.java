/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campodeapostas.Presentation;


import br.com.campodeapostas.DomainModel.Estadio;
import br.com.campodeapostas.DomainModel.IEstadioRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Nayara
 */
@Named(value = "estadio")
@SessionScoped
public class EstadioBean implements Serializable{
    
    @EJB
    IEstadioRepositorio repo;

    Long id;
    private String nome;
    private String cidade;
    private String estado;

    List<Estadio> listagem;
    Estadio estadio;
    
    public EstadioBean() {
        id = 0L;
        nome = "";
        cidade = "";
        estado = "";
    }
    
    public void abrir(){
        if(id > 0)
            setEstadio(repo.abrir(id));
    }
    
    public String editar(){
        abrir();
        return "salvarEstadio.xhtml";
    }
    
    public String apagar(){
        abrir();
        repo.apagar(estadio);
        listagem = null;
        return "listarEstadio.xhtml";
    }
    
    public void salvar(){
        abrir();
        
        if(estadio == null)
            estadio = new Estadio();
        
        estadio.setNome(nome);
        estadio.setCidade(cidade);
        estadio.setEstado(estado);
        
        repo.salvar(estadio);
        listagem = null;
    }
    

    public IEstadioRepositorio getRepo() {
        return repo;
    }

    public void setRepo(IEstadioRepositorio repo) {
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Estadio> getListagem() {
        if(listagem == null){
            listagem = repo.listarTodos();
        }
        return listagem;
    }

    public void setListagem(List<Estadio> listagem) {
        this.listagem = listagem;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }    
    
}
