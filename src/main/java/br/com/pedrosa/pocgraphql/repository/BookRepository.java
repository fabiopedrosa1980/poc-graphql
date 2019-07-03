package br.com.pedrosa.pocgraphql.repository;

import br.com.pedrosa.pocgraphql.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
