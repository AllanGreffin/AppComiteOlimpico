package br.edu.infnet.comiteolimpico.appcomiteolimpico;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Endereco;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Skate;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Surfe;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.ComissaoService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.EntidadeService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.GinasticaService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SkateService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SurfeService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class AtletaLoader implements ApplicationRunner {

	@Autowired
	private GinasticaService ginasticaService;
        
        @Autowired
	private SkateService skateService;
        
        @Autowired
	private SurfeService surfeService;
        
        @Autowired
	private UsuarioService usuarioService;
        
        @Autowired
	private ComissaoService comissaoService;
        
        @Autowired
	private EntidadeService entidadeService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

            Usuario usuario = usuarioService.obterLista().get(0);
            
            Entidade entidade = new Entidade("Brasil", "América so Sul", 220000000);
            entidade.setId(1);
            entidade.setUsuario(usuario);
            entidadeService.incluir(entidade);
            
            Comissao comissao = new Comissao("COB", entidade);
            comissao.setId(1);
            comissao.setUsuario(usuario);
            comissaoService.incluir(comissao);
            
            entidade.setComissao(comissao);
            entidadeService.incluir(entidade);
            
            Ginastica ginastica = new Ginastica("Flamengo", "Solo", 10, "Larissa", false, "01/01/1991", comissao);
            ginastica.setUsuario(usuario);
            ginasticaService.incluir(ginastica);

            Skate skate = new Skate("marca X", true, 43, "Thiago", true, "02/02/1992", comissao);
            skate.setUsuario(usuario);
            skateService.incluir(skate);

            Surfe surfe = new Surfe(true, "Marca de prancha Y", 42, "Teobaldo", true, "03/03/1993", comissao);
            surfe.setUsuario(usuario);
            surfeService.incluir(surfe);
	}
}