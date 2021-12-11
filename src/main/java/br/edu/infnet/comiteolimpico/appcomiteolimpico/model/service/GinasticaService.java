package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.GinasticaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

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

    public List<Ginastica> obterLista(){
            return (List<Ginastica>) ginasticaRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }
}
