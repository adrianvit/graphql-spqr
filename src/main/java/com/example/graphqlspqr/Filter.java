package com.example.graphqlspqr;

import io.leangen.graphql.annotations.types.GraphQLType;

public class Filter {

  private String id;
  private String name;
  private String authorId;

  public Filter(){

  }

  public Filter(String id, String name, String authorId) {
    this.id = id;
    this.name = name;
    this.authorId = authorId;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAuthorId() {
    return authorId;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAuthorId(String authorId) {
    this.authorId = authorId;
  }

}
