package com.greenfoxacademy.calorie.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Meal {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String date;
  private String type;
  private String description;
  private int calories;

  public Meal(String type, String description, int calories) throws Exception {
    Date myDate = new Date();
    this.date = new SimpleDateFormat("yyyy-MM-dd").format(myDate);
    this.type = type;
    this.description = description;
    this.calories = calories;
  }

  public Meal(String date, String type, String description, int calories) {
    this.date = date;
    this.type = type;
    this.description = description;
    this.calories = calories;
  }

  public Meal(long id, String date, String type, String description, int calories) {
    this.id = id;
    this.date = date;
    this.type = type;
    this.description = description;
    this.calories = calories;
  }

  public Meal() {
  }

  public void updateMeal(Meal meal) {
    this.date = meal.date;
    this.type = meal.type;
    this.description = meal.description;
    this.calories = meal.calories;
  }



}
