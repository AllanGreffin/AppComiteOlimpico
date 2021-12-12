
package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Atleta;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.AtletaRepository;
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
	
	public List<Atleta> obterLista(){
            
            List<Atleta> result = (List<Atleta>) atletaRepository.findAll();
            return result;
	}
}
