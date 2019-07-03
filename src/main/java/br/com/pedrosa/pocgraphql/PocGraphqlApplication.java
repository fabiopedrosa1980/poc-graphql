package br.com.pedrosa.pocgraphql;

import br.com.pedrosa.pocgraphql.model.Author;
import br.com.pedrosa.pocgraphql.model.Book;
import br.com.pedrosa.pocgraphql.repository.AuthorRepository;
import br.com.pedrosa.pocgraphql.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PocGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocGraphqlApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository){
		return (args) -> {
			Author author = new Author(null,"teste","teste");
			authorRepository.save(author);

			Book book = new Book(null,"Reactive Java","teste",500,author);
			bookRepository.save(book);

		};

	}

}
