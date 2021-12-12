package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAtleta")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Atleta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long Id;
    protected String Nome;
    protected boolean Sexo; //true = 1 = homem, false = 0 = mulher
    protected LocalDateTime Nascimento;
    @ManyToOne
    @JoinColumn(name = "idComissao")
    protected Comissao comissao;
    
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

    public boolean getSexo() {
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
