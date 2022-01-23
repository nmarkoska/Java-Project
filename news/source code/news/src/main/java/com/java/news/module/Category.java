package com.java.news.module;

import javax.persistence.*;

@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String categoryName;

  public Integer getId() {
    return id;
  }

  public String getCategoryName() {
    return categoryName;
  }
}
