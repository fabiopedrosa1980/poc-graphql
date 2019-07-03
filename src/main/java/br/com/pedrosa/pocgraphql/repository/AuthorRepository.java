package br.com.pedrosa.pocgraphql.repository;

import br.com.pedrosa.pocgraphql.model.Author;
import br.com.pedrosa.pocgraphql.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
