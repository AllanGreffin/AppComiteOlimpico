package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Atleta;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface AtletaRepository extends CrudRepository<Atleta, Integer> {

	public List<Atleta> findAll(Integer id, Sort by);
}