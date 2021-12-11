package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadeRepository extends CrudRepository<Entidade, Integer> {

	public List<Entidade> findAll(Sort by);
}
