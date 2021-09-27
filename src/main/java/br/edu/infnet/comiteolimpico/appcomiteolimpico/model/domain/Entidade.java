package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain;

import java.util.Date;

public class Entidade {
    
    private long Id;
    private String Nome;
    private String Continente;
    private long Populacao;

    public Entidade(String Nome, String Continente, long Populacao) {
        this.Nome = Nome;
        this.Continente = Continente;
        this.Populacao = Populacao;
    }

    public long getId() {
        return Id;
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
