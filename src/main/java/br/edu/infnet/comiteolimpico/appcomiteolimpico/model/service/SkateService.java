package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Skate;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.SkateRepository;
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

    public List<Skate> obterLista(){
            return (List<Skate>) skateRepository.findAll();
    }
}
