package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.exceptions.TamanhoUniformeNegativoException;
import java.time.format.DateTimeFormatter;

public class Ginastica extends Atleta {
    
    private String Clube;
    private String Especialidade;
    private int TamanhoUniforme; 

    public Ginastica(String Clube, String Especialidade, String TamanhoUniforme, String Nome, String Sexo, String Nascimento) {
        super(Nome, Sexo, Nascimento);
        this.Clube = Clube;
        this.Especialidade = Especialidade;
        int tamanhoUniforme = Integer.parseInt(TamanhoUniforme);
        this.TamanhoUniforme = tamanhoUniforme;
    }
    
    public Ginastica(String Clube, String Especialidade, int TamanhoUniforme, String Nome, boolean Sexo, String Nascimento) {
        super(Nome, Sexo, Nascimento);
        this.Clube = Clube;
        this.Especialidade = Especialidade;
        this.TamanhoUniforme = TamanhoUniforme;
    }

    public String getClube() {
        return Clube;
    }

    public void setClube(String Clube) {
        this.Clube = Clube;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(String Especialidade) {
        this.Especialidade = Especialidade;
    }

    public int getTamanhoUniforme() {
        return TamanhoUniforme;
    }

    public void setTamanhoUniforme(int TamanhoUniforme) throws TamanhoUniformeNegativoException {
        if(TamanhoUniforme < 0){
            throw new TamanhoUniformeNegativoException("O tamanho do uniforme não pode ser negativo");
        }
        this.TamanhoUniforme = TamanhoUniforme;
    }
    
    @Override
    public String toString(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        StringBuilder sb = new StringBuilder();
        sb.append(Id);
        sb.append(";");
        sb.append(Nome);
        sb.append(";");
        sb.append(Sexo ? "M" : "F");
        sb.append(";");
        sb.append(Nascimento.format(formato));
        sb.append(";");
        sb.append(Clube);
        sb.append(";");
        sb.append(Especialidade);
        sb.append(";");
        sb.append(TamanhoUniforme);
        
        return sb.toString();
    }

    @Override
    public String ResumoAtleta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ginasta ");
        sb.append(getNome());
        sb.append(", treina no ");
        sb.append(getClube());
        sb.append(" e usa uniforme tamanho ");
        sb.append(getTamanhoUniforme());
        return sb.toString();
    }
}
