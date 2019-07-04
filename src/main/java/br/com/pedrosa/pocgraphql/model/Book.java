package br.com.pedrosa.pocgraphql.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GraphQLQuery(name = "id",description = "A id book")
    private Long id;

    @GraphQLQuery(name = "title",description = "A title book")
    private String title;

    @GraphQLQuery(name = "isbn",description = "A isbn book")
    private String isbn;

    @GraphQLQuery(name = "pageCount",description = "A pageCount book")
    private int pageCount;
}
