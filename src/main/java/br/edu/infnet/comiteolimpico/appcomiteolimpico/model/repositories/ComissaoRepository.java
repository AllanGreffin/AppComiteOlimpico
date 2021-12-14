package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComissaoRepository extends CrudRepository<Comissao, Integer> {

    @Query("from Comissao c where c.usuario.id =:id")
    public List<Comissao> findAllByOrderByNomeAsc();
}
