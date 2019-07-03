package br.com.pedrosa.pocgraphql.controller;

import br.com.pedrosa.pocgraphql.service.BookService;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class GraphqlController {
    private final GraphQL graphQL;

    public GraphqlController(BookService bookService){
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withResolverBuilders(
                        new AnnotatedResolverBuilder())
                .withOperationsFromSingleton(bookService)
                .withValueMapperFactory(new JacksonValueMapperFactory())
                .generate();
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    @PostMapping(value = "/graphql",consumes = APPLICATION_JSON_UTF8_VALUE,produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String,Object> graphql(@RequestBody Map<String,Object> request, HttpServletRequest raw){
        ExecutionResult executionResult = graphQL.execute(
                ExecutionInput.newExecutionInput()
                        .query(request.get("query").toString())
                        .operationName("operationName")
                        .context(raw)
                        .build());
            return executionResult.toSpecification();

    }

}
