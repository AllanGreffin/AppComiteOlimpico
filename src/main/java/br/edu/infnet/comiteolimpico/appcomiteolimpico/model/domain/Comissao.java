 package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TComissao")
public class Comissao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Nome;
    @OneToOne(cascade = CascadeType.DETACH) 
    @JoinColumn(name = "idEntidade")
    private Entidade Entidade;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "comissao")
    private List<Atleta> Atletas;

    public Comissao() {
    }

    
    
    public Comissao(String Nome, String nomeEntidade, String continenteEntidade, String populacaoEntidade) {
        this.Nome = Nome;
        Entidade entidade = new Entidade(nomeEntidade, continenteEntidade, Long.parseLong(populacaoEntidade));
        this.Entidade = entidade;
        this.Atletas = new ArrayList<>();
    }
    
    public Comissao(String Nome, Entidade Entidade) {
        this.Nome = Nome;
        this.Entidade = Entidade;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Entidade getEntidade() {
        return Entidade;
    }

    public void setEntidade(Entidade Entidade) {
        this.Entidade = Entidade;
    }

    public List<Atleta> getAtletas() {
        return Atletas;
    }

    public void setAtletas(List<Atleta> Atletas) {
        this.Atletas = Atletas;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(Id);
        sb.append(";");
        sb.append(Nome);
        sb.append(";");
        sb.append(Entidade);
        sb.append(";");
        for(int i = 0; i <= Atletas.size(); i++){
            sb.append(Atletas.get(i).getNome());
            if(i < Atletas.size()){
                sb.append(",");
            }
        }
        
        return sb.toString();
    }
    
    public void AddAtleta(Atleta atleta){
        this.Atletas.add(atleta);
    }
}
