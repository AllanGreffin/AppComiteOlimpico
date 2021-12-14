package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain;


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
@Table(name = "TUsuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private boolean admin;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idendereco")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
    private List<Entidade> entidades;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
    private List<Comissao> comissoes;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
    private List<Atleta> atletas;
    
    public Usuario() {
    }

    public Integer getId() {
            return id;
    }

    public void setId(Integer id) {
            this.id = id;
    }

    public String getNome() {
            return nome;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getSenha() {
            return senha;
    }

    public void setSenha(String senha) {
            this.senha = senha;
    }

    public boolean isAdmin() {
            return admin;
    }

    public void setAdmin(boolean admin) {
            this.admin = admin;
    }

    public Endereco getEndereco() {
            return endereco;
    }

    public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
    }

    public List<Entidade> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidade> entidades) {
        this.entidades = entidades;
    }

    public List<Comissao> getComissoes() {
        return comissoes;
    }

    public void setComissoes(List<Comissao> comissoes) {
        this.comissoes = comissoes;
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atleta> atletas) {
        this.atletas = atletas;
    }
    
    
}