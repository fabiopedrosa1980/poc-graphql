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
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GraphQLQuery(name = "idPerson",description = "A id person")
    private Long id;

    @GraphQLQuery(name = "namePerson",description = "A name person")
    private String name;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @GraphQLQuery(name = "agePerson",description = "A age person")
    private Integer age;

}
