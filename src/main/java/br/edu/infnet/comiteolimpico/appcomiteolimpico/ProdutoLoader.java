package br.edu.infnet.comiteolimpico.appcomiteolimpico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProdutoLoader implements ApplicationRunner {

//	@Autowired
//	private BebidaService bebidaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

//		try {
//			Bebida suco = new Bebida("suco", 10, 123);		
//			suco.setGelada(true);
//			suco.setMarca("sucao");
//			suco.setTamanho(500);
//			bebidaService.incluir(suco);
//		} catch (TamanhoNegativoException e) {
//			System.out.println(e.getMessage());
//		}
	}

}