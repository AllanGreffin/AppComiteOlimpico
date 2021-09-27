package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.exceptions.TamanhoCalcadoNegativoException;
import java.time.LocalDateTime;

public class Skate extends Atleta {
    
    private String RolamentoPreferido;
    private boolean DisputaXGames;
    private int Calcado;

    public Skate(String RolamentoPreferido, String DisputaXGames, String Calcado, String Nome, String Sexo, String Nascimento) {
        super(Nome, Sexo, Nascimento);
        this.RolamentoPreferido = RolamentoPreferido;
        boolean disputaXGames = Boolean.parseBoolean(DisputaXGames);
        this.DisputaXGames = disputaXGames;
        int calcado = Integer.parseInt(Calcado);
        this.Calcado = calcado;
    }
    
    public Skate(String RolamentoPreferido, boolean DisputaXGames, int Calcado, String Nome, boolean Sexo, String Nascimento) {
        super(Nome, Sexo, Nascimento);
        this.RolamentoPreferido = RolamentoPreferido;
        this.DisputaXGames = DisputaXGames;
        this.Calcado = Calcado;
    }

    public String getRolamentoPreferido() {
        return RolamentoPreferido;
    }

    public void setRolamentoPreferido(String RolamentoPreferido) {
        this.RolamentoPreferido = RolamentoPreferido;
    }

    public boolean isDisputaXGames() {
        return DisputaXGames;
    }

    public void setDisputaXGames(boolean DisputaXGames) {
        this.DisputaXGames = DisputaXGames;
    }

    public int getCalcado() {
        return Calcado;
    }

    public void setCalcado(int Calcado) throws TamanhoCalcadoNegativoException {
        if(Calcado <= 0){
            throw new TamanhoCalcadoNegativoException("O tamanho do calçado tem que ser maior que 0");
        }
        this.Calcado = Calcado;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(Id);
        sb.append(";");
        sb.append(Nome);
        sb.append(";");
        sb.append(Sexo);
        sb.append(";");
        sb.append(Nascimento);
        sb.append(";");
        sb.append(RolamentoPreferido);
        sb.append(";");
        sb.append(DisputaXGames);
        sb.append(";");
        sb.append(Calcado);
        
        return sb.toString();
    }
    
    @Override
    public String ResumoAtleta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Skatista ");
        sb.append(getNome());
        sb.append(", tem preferência pelo rolamento ");
        sb.append(getRolamentoPreferido());
        sb.append(" e usa utiliza calçado tamanho ");
        sb.append(getCalcado());
        return sb.toString();
    }
}
