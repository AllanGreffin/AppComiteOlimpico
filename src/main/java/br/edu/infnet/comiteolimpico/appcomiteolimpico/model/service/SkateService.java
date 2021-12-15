package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Skate;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.SkateRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SkateService {
    
    @Autowired
    private SkateRepository skateRepository;

    public void incluir(Skate skate) {
            skateRepository.save(skate);
    }

    public void excluir(Integer id) {
            skateRepository.deleteById(id);
    }

    public Skate obterPorId(Integer id) {
            return skateRepository.findById(id).orElse(null);
    }

    public List<Skate> obterLista(Usuario usuario){
        List<Skate> result;
        if(usuario.isAdmin()){
            result = (List<Skate>) skateRepository.findAllOrderByNome();
        }else{
            result = (List<Skate>) skateRepository.findAll(usuario.getId());
        }    
        
        Collections.sort(result, new Comparator<Skate>() {
            public int compare(final Skate object1, final Skate object2) {
                return object1.getNome().compareToIgnoreCase(object2.getNome());
            }
        });
        return result;
    }
}
