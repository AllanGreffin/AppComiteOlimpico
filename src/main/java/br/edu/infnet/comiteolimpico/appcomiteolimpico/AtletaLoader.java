package br.edu.infnet.comiteolimpico.appcomiteolimpico;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.GinasticaService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SkateService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SurfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class AtletaLoader implements ApplicationRunner {

	@Autowired
	private GinasticaService ginasticaService;
        
        @Autowired
	private SkateService skateService;
        
        @Autowired
	private SurfeService surfeService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

//            public Ginastica(String Clube, String Especialidade, int TamanhoUniforme, String Nome, boolean Sexo, String Nascimento) {
            Ginastica ginastica = new Ginastica("Flamengo", "Solo", 10, "Larissa", false, "01/01/1991");
            ginasticaService.incluir(ginastica);
            
            
            
//		Endereco endereco = new Endereco();
//		endereco.setBairro("bairro");
//		endereco.setCep("123123123");
//		endereco.setComplemento("complemento");
//		endereco.setLocalidade("localidade");
//		endereco.setLogradouro("logradouro");
//		endereco.setUf("RJ");
//		
//		Usuario usuario = new Usuario();
//		usuario.setEmail("allan.greffin@al.infnet.edu.br");
//		usuario.setNome("Allan Greffin");
//		usuario.setSenha("123");
//		usuario.setAdmin(true);
//		
//		usuario.setEndereco(endereco);
//		
//		usuarioService.incluir(usuario);
	}
}