package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Surfe;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurfeRepository extends CrudRepository<Surfe, Integer> {

	public List<Surfe> findAll(Sort by);
}
