package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Atleta {
    
    protected long Id;
    protected String Nome;
    protected boolean Sexo; //true = 1 = homem, false = 0 = mulher
    protected LocalDateTime Nascimento;

    public Atleta(String Nome, String Sexo, String Nascimento) {
        this.Nome = Nome;
        boolean sexo = Boolean.parseBoolean(Sexo);
        this.Sexo = sexo;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.Nascimento = LocalDateTime.parse(Nascimento, formatter);
    }
    
    public Atleta(String Nome, boolean Sexo, String Nascimento) {
        this.Nome = Nome;
        this.Sexo = Sexo;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.Nascimento = LocalDateTime.parse(Nascimento, formatter);
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

    public boolean isSexo() {
        return Sexo;
    }

    public void setSexo(boolean Sexo) {
        this.Sexo = Sexo;
    }

    public LocalDateTime getNascimento() {
        return Nascimento;
    }

    public void setNascimento(LocalDateTime Nascimento) {
        this.Nascimento = Nascimento;
    }
    
    public abstract String ResumoAtleta();
}
