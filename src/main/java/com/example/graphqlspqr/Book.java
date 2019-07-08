package com.example.graphqlspqr;

import java.time.ZonedDateTime;

public class Book {

  private String id;
  private String name;
  private Integer pageCount;
  private ZonedDateTime publishedDate;
  private Author author;

  public Book(String id, String name, Integer pageCount, ZonedDateTime publishedDate, Author author) {
    this.id = id;
    this.name = name;
    this.pageCount = pageCount;
    this.publishedDate = publishedDate;
    this.author = author;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getPageCount() {
    return pageCount;
  }

  public Author getAuthor() {
    return author;
  }

  public ZonedDateTime getPublishedDate() {
    return publishedDate;
  }
}
