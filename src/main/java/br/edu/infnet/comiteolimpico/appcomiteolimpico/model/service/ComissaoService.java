package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.ComissaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public class ComissaoService {
    
    @Autowired
    private ComissaoRepository comissaoRepository;

    public void incluir(Comissao comida) {
            comissaoRepository.save(comida);
    }

    public void excluir(Integer id) {
            comissaoRepository.deleteById(id);
    }

    public Comissao obterPorId(Integer id) {
            return comissaoRepository.findById(id).orElse(null);
    }

    public List<Comissao> obterLista(Comissao comissao){
            return (List<Comissao>) comissaoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }
}
