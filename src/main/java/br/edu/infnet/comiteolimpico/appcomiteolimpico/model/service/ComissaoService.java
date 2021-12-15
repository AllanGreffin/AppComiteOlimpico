package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.ComissaoRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
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

    public List<Comissao> obterLista(Usuario usuario){
        List<Comissao> result =  (List<Comissao>) comissaoRepository.findAll(usuario.getId());
        Collections.sort(result, new Comparator<Comissao>() {
            public int compare(final Comissao object1, final Comissao object2) {
                return object1.getNome().compareToIgnoreCase(object2.getNome());
            }
        });
        return result;
    }
}
