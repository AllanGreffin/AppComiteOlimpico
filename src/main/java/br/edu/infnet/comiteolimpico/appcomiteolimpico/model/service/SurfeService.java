package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Surfe;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.SurfeRepository;
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

    public List<Surfe> obterLista(){
        return (List<Surfe>) surfeRepository.findAll();
    }
}
