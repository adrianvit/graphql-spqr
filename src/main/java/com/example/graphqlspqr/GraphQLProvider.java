package com.example.graphqlspqr;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GraphQLProvider {

  @Autowired
  QueryService queryService;


  @Bean
  public GraphQL graphQL() {

    GraphQLSchema schema = new GraphQLSchemaGenerator()
        .withBasePackages("com.example.graphqlspqr")
        .withOperationsFromSingleton(queryService)
        .generate();

    return new GraphQL.Builder(schema)
        .build();
  }
}
