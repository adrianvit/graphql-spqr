package com.example.graphqlspqr;

import com.google.common.collect.ImmutableMap;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class QueryService {

  public QueryService(){}

  private static Map<String, Author> authors = ImmutableMap.of(
      "author-1", new Author("author-1", "FirstName1", "LastName1"),
      "author-2", new Author("author-2", "FirstName2", "LastName2"),
      "author-3", new Author("author-3", "FirstName3", "LastName3")
  );

  private static List<Book> books = Arrays.asList(
      new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, ZonedDateTime.now().plusHours(1), authors.get("author-1")),
      new Book("book-2", "Moby Dick", 635, ZonedDateTime.now().plusHours(2), authors.get("author-2")),
      new Book("book-3", "Interview with the vampire", 371, ZonedDateTime.now().plusHours(3), authors.get("author-3")));

  @GraphQLQuery(name = "bookById")
  public Book getBookById(@GraphQLArgument(name = "id") String id) {
    return books
        .stream()
        .filter(book -> book.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  @GraphQLQuery(name = "bookByFilter")
  public Book getBookByFilter(@GraphQLArgument(name = "filter") Filter filter) {
    return books
        .stream()
        .filter(book -> book.getId().equals(filter.getId()) || book.getAuthor().getId().equals(filter.getAuthorId()))
        .findFirst()
        .orElse(null);
  }
}
