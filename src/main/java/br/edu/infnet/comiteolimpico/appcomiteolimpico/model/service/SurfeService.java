package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Surfe;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.SurfeRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SurfeService {
    
    @Autowired
    private SurfeRepository surfeRepository;

    public void incluir(Surfe surfe) {
        surfeRepository.save(surfe);
    }

    public void excluir(Integer id) {
        surfeRepository.deleteById(id);
    }

    public Surfe obterPorId(Integer id) {
        return surfeRepository.findById(id).orElse(null);
    }

    public List<Surfe> obterLista(Usuario usuario){
        
        List<Surfe> result = (List<Surfe>) surfeRepository.findAll(usuario.getId());
        Collections.sort(result, new Comparator<Surfe>() {
            public int compare(final Surfe object1, final Surfe object2) {
                return object1.getNome().compareToIgnoreCase(object2.getNome());
            }
        });
        return result;
    }
}
