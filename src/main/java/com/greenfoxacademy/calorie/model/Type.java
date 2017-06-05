package com.greenfoxacademy.calorie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Type {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String description;

  public Type(String description) {
    this.description = description;
  }

  public Type() {
  }
}
