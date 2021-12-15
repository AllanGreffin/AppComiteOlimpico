package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GinasticaRepository extends CrudRepository<Ginastica, Integer> {

    @Query("from Ginastica g where g.usuario.id =:id")
    public List<Ginastica> findAll(Integer id);
    
    @Query("from Ginastica g")
    public List<Ginastica> findAllOrderByNome();
}