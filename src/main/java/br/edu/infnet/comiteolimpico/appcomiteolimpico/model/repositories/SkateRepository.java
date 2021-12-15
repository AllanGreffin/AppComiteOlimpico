package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Skate;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkateRepository extends CrudRepository<Skate, Integer> {

    @Query("from Skate s where s.usuario.id =:id")
    public List<Skate> findAll(Integer id);
    
    @Query("from Skate s")
    public List<Skate> findAllOrderByNome();
}
