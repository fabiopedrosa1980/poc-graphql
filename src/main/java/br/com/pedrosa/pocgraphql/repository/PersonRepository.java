package br.com.pedrosa.pocgraphql.repository;

import br.com.pedrosa.pocgraphql.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
