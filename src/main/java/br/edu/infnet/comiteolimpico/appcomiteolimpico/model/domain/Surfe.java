package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.exceptions.TamanhoBermudaNegativoException;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TSurfe")
public class Surfe extends Atleta {
    
    private boolean OndasGigantes;
    private String MarcaPrancha;
    private int TamanhoBermuda;
    
    public Surfe(boolean OndasGigantes, String MarcaPrancha, int TamanhoBermuda, String Nome, boolean Sexo, String Nascimento) {
        super(Nome, Sexo, Nascimento);
        this.OndasGigantes = OndasGigantes;
        this.MarcaPrancha = MarcaPrancha;
        this.TamanhoBermuda = TamanhoBermuda;
    }

    public boolean isOndasGigantes() {
        return OndasGigantes;
    }

    public void setOndasGigantes(boolean OndasGigantes) {
        this.OndasGigantes = OndasGigantes;
    }

    public String getMarcaPrancha() {
        return MarcaPrancha;
    }

    public void setMarcaPrancha(String MarcaPrancha) {
        this.MarcaPrancha = MarcaPrancha;
    }

    public int getTamanhoBermuda() {
        return TamanhoBermuda;
    }

    public void setTamanhoBermuda(int TamanhoBermuda) throws TamanhoBermudaNegativoException {
        if(TamanhoBermuda <= 0){
            throw new TamanhoBermudaNegativoException("O tamanho da bermuda não pode ser negativo");
        }
        this.TamanhoBermuda = TamanhoBermuda;
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
        sb.append(OndasGigantes);
        sb.append(";");
        sb.append(MarcaPrancha);
        sb.append(";");
        sb.append(TamanhoBermuda);
        
        return sb.toString();
    }
    
    @Override
    public String ResumoAtleta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Surfista ");
        sb.append(getNome());
        sb.append(", prefere pranchas da marca ");
        sb.append(getMarcaPrancha());
        sb.append(" e usa bermuda tamanho ");
        sb.append(getTamanhoBermuda());
        return sb.toString();
    }
}
