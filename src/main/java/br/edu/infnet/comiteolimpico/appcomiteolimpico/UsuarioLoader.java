package br.edu.infnet.comiteolimpico.appcomiteolimpico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Endereco;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		Endereco endereco = new Endereco();
		endereco.setBairro("bairro");
		endereco.setCep("123123123");
		endereco.setComplemento("complemento");
		endereco.setLocalidade("localidade");
		endereco.setLogradouro("logradouro");
		endereco.setUf("RJ");
		
		Usuario usuario = new Usuario();
		usuario.setEmail("allan.greffin@al.infnet.edu.br");
		usuario.setNome("Allan Greffin");
		usuario.setSenha("123");
		usuario.setAdmin(true);
		
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);
	}
}