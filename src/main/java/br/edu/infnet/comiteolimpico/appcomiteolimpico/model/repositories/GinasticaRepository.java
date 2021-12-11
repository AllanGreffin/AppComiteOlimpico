package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GinasticaRepository extends CrudRepository<Ginastica, Integer> {

	public List<Ginastica> findAll(Sort by);
}