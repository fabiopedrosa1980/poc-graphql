package br.com.pedrosa.pocgraphql.service;

import br.com.pedrosa.pocgraphql.model.Book;
import br.com.pedrosa.pocgraphql.model.Person;
import br.com.pedrosa.pocgraphql.repository.BookRepository;
import br.com.pedrosa.pocgraphql.repository.PersonRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@GraphQLApi
public class PersonService {
    private final PersonRepository personRepository;

    @GraphQLQuery(name = "persons")
    public Iterable<Person> getPerson(){
        return  personRepository.findAll();
    }

    @GraphQLQuery(name = "person")
    public Person getPersonById(Long id){
        return  personRepository.findById(id).get();
    }

    @GraphQLMutation(name = "savePerson")
    public Person savePerson(@GraphQLArgument(name="person") Person person){
        return personRepository.save(person);
    }

    @GraphQLMutation(name = "deletePerson")
    public void deletePerson(@GraphQLArgument(name="id") Long id){
        personRepository.deleteById(id);
    }



}
