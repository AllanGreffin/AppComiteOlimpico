package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.EntidadeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EntidadeService {
    
    @Autowired
    private EntidadeRepository entidadeRepository;

    public void incluir(Entidade entidade) {
            entidadeRepository.save(entidade);
    }

    public void excluir(Integer id) {
            entidadeRepository.deleteById(id);
    }

    public Entidade obterPorId(Integer id) {
            return entidadeRepository.findById(id).orElse(null);
    }

    public List<Entidade> obterLista(){
            return (List<Entidade>) entidadeRepository.findAll();
    }
    
}