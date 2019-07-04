package br.com.pedrosa.pocgraphql.service;

import br.com.pedrosa.pocgraphql.model.Book;
import br.com.pedrosa.pocgraphql.repository.BookRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@GraphQLApi
public class BookService {
    private final BookRepository bookRepository;

    @GraphQLQuery(name = "books")
    public Iterable<Book> getBooks(){
        return  bookRepository.findAll();
    }

    @GraphQLQuery(name = "book")
    public Book getBookById(Long id){
        return  bookRepository.findById(id).get();
    }

    @GraphQLMutation(name = "saveBook")
    public Book saveBook(@GraphQLArgument(name="book") Book book){
        return bookRepository.save(book);
    }

    @GraphQLMutation(name = "deleteBook")
    public void deleteBook(@GraphQLArgument(name="id") Long id){
         bookRepository.deleteById(id);
    }

}
