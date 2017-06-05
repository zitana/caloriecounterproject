package com.greenfoxacademy.calorie.model;

import com.greenfoxacademy.calorie.repository.MealRepository;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistics {
  private int numberOfMeals;
  private int calories;

  public Statistics() {
  }

  public Statistics(List<Meal> meals) {
    this.numberOfMeals = meals.size();
    this.calories = countCalories(meals);
  }

  public int countCalories(List<Meal> meals) {
    int calories = 0;
    for (Meal meal : meals) {
      calories += meal.getCalories();
    }
    return calories;
  }
}
