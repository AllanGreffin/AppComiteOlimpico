package br.edu.infnet.comiteolimpico.appcomiteolimpico;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Endereco;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Skate;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Surfe;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.GinasticaService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SkateService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SurfeService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.UsuarioService;
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
        
        @Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

            Ginastica ginastica = new Ginastica("Flamengo", "Solo", 10, "Larissa", false, "01/01/1991");
            ginasticaService.incluir(ginastica);

            Skate skate = new Skate("marca X", true, 43, "Thiago", true, "02/02/1992");
            skateService.incluir(skate);

            Surfe surfe = new Surfe(true, "Marca de prancha Y", 42, "Teobaldo", true, "03/03/1993");
            surfeService.incluir(surfe);
            
		Endereco endereco = new Endereco();
		endereco.setBairro("bairro");
		endereco.setCep("123123123");
		endereco.setComplemento("complemento");
		endereco.setLocalidade("localidade");
		endereco.setLogradouro("logradouro");
		endereco.setUf("RJ");
//		
		Usuario usuario = new Usuario();
		usuario.setEmail("allan.greffin@al.infnet.edu.br");
		usuario.setNome("Allan Greffin");
		usuario.setSenha("123456");
		usuario.setAdmin(true);
		
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);
	}
}