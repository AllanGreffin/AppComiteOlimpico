package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Surfe;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.UsuarioRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario autenticacao(String email, String senha) {
		return usuarioRepository.autenticacao(email, senha);
	}
	
	public void incluir(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> obterLista(){
                
            List<Usuario> result = (List<Usuario>) usuarioRepository.findAll();
            Collections.sort(result, new Comparator<Usuario>() {
                public int compare(final Usuario object1, final Usuario object2) {
                    return object1.getNome().compareToIgnoreCase(object2.getNome());
                }
            });
            return result;
	}

	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);		
	}
}