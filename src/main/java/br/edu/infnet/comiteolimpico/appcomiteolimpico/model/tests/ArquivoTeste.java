package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.tests;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Skate;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Surfe;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArquivoTeste {
    
    public static void main (String[] args){
    
        String dir = "C:/dev/";
        String arq = "atletas.txt";
        
        try{
         
            try{
                FileReader file = new FileReader(dir+arq);
                BufferedReader leitura = new BufferedReader(file);
                
                FileWriter fileW = new FileWriter(dir+"out_"+arq);
                BufferedWriter escrita = new BufferedWriter(fileW);
                
                String linha = null;
                String[] campos;
                
                linha = leitura.readLine();
                
                while(linha != null){
                    
                    campos = linha.split(";");
                    
                    if(campos.length == 4){
                        Comissao comissao = new Comissao(campos[0], campos[1], campos[2], campos[3]);
                        System.out.println(comissao);
                    }else{
                        switch (campos[0]){
                        case "G":
                            Ginastica ginasta = new Ginastica(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]);
                            System.out.println(ginasta);
                            break;
                        
                        case "SK8":
                            Skate skatista = new Skate(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]);
                            System.out.println(skatista);
                            break;
                        
                        case "Sf":
                            Surfe surfista = new Surfe(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]);
                            System.out.println(surfista);
                            break;
                        default:
                            System.out.println("Atleta sem tipo");
                            break;
                        }
                    }
                    
                    linha = leitura.readLine();
                }
                
                //escrita.write()
                        
                leitura.close();
                file.close();
                
                escrita.close();
                fileW.close();
                
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } finally{
            System.out.println("Processamento realizado!");
        }
    }
}
