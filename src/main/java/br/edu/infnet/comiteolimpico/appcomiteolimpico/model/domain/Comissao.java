 package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Comissao {
    
    private long Id;
    private String Nome;
    private Entidade Entidade;
    private List<Atleta> Atletas;

    public Comissao(String Nome, String nomeEntidade, String continenteEntidade, String populacaoEntidade) {
        this.Nome = Nome;
        Entidade entidade = new Entidade(nomeEntidade, continenteEntidade, Long.parseLong(populacaoEntidade));
        this.Entidade = entidade;
        this.Atletas = new ArrayList<>();
    }
    
    public Comissao(String Nome, Entidade Entidade) {
        this.Nome = Nome;
        this.Entidade = Entidade;
        this.Atletas = new ArrayList<>();
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

    public long getId() {
        return Id;
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
