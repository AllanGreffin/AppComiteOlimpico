package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.GinasticaRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class GinasticaService {
    
    @Autowired
    private GinasticaRepository ginasticaRepository;

    public void incluir(Ginastica ginastica) {
            ginasticaRepository.save(ginastica);
    }

    public void excluir(Integer id) {
            ginasticaRepository.deleteById(id);
    }

    public Ginastica obterPorId(Integer id) {
            return ginasticaRepository.findById(id).orElse(null);
    }

    public List<Ginastica> obterLista(Usuario usuario){
        List<Ginastica> result;
        if(usuario.isAdmin()){
            result = (List<Ginastica>) ginasticaRepository.findAllOrderByNome();
        }else{
            result = (List<Ginastica>) ginasticaRepository.findAll(usuario.getId());
        }        
        
        
        Collections.sort(result, new Comparator<Ginastica>() {
            public int compare(final Ginastica object1, final Ginastica object2) {
                return object1.getNome().compareToIgnoreCase(object2.getNome());
            }
        });
        return result;
    }
}
