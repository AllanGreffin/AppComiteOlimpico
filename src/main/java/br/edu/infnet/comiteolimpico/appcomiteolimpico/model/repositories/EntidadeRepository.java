package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadeRepository extends CrudRepository<Entidade, Integer> {

    @Query("from Entidade e where e.usuario.id =:id")
    public List<Entidade> findAll(Integer id);
    
    @Query("from Entidade e")
    public List<Entidade> findAllOrderByNome();
}
