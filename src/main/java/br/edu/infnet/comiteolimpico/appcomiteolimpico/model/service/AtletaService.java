
package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Atleta;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.AtletaRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AtletaService {
    
        @Autowired
	private AtletaRepository atletaRepository;

	public void excluir(Integer id) {
            atletaRepository.deleteById(id);
	}
	
	public Atleta obterPorId(Integer id) {
            return atletaRepository.findById(id).orElse(null);
	}
	
	public List<Atleta> obterLista(Usuario usuario){
            List<Atleta> result;
            if(usuario.isAdmin()){
                result = (List<Atleta>) atletaRepository.findAllOrderByNome();
            }else{
                result = (List<Atleta>) atletaRepository.findAll(usuario.getId());
            }    
            
            Collections.sort(result, new Comparator<Atleta>() {
                public int compare(final Atleta object1, final Atleta object2) {
                    return object1.getNome().compareToIgnoreCase(object2.getNome());
                }
            });
            return result;
	}
}
