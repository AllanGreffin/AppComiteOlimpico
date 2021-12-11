package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Skate;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkateRepository extends CrudRepository<Skate, Integer> {

	public List<Skate> findAll(Sort by);
}
