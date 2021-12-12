package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEntidade")
public class Entidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Nome;
    private String Continente;
    private long Populacao;
    @OneToOne(cascade = CascadeType.DETACH) 
    @JoinColumn(name = "idComissao")
    private Comissao Comissao;
    
    public Entidade() {
    }
    
    public Entidade(String nome, String continente, long populacao) {
        this.Nome = nome;
        this.Continente = continente;
        this.Populacao = populacao;
    }

    public long getId() {
        return Id;
    }
    
    public void setId(long id) {
        this.Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getContinente() {
        return Continente;
    }

    public void setContinente(String Continente) {
        this.Continente = Continente;
    }

    public long getPopulacao() {
        return Populacao;
    }

    public void setPopulacao(long Populacao) {
        this.Populacao = Populacao;
    }

    public Comissao getComissao() {
        return Comissao;
    }

    public void setComissao(Comissao Comissao) {
        this.Comissao = Comissao;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(Id);
        sb.append(";");
        sb.append(Nome);
        sb.append(";");
        sb.append(Continente);
        sb.append(";");
        sb.append(Populacao);
        
        return sb.toString();
    }
}
