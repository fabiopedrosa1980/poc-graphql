package br.com.pedrosa.pocgraphql;

import br.com.pedrosa.pocgraphql.model.Book;
import br.com.pedrosa.pocgraphql.model.Person;
import br.com.pedrosa.pocgraphql.repository.BookRepository;
import br.com.pedrosa.pocgraphql.repository.PersonRepository;
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
	public CommandLineRunner demo(BookRepository bookRepository, PersonRepository personRepository){
		return (args) -> {
			bookRepository.save(new Book(null,"Reactive Java","teste",500));
			personRepository.save(new Person(null,"Fabio Pedrosa",38));
		};

	}

}
