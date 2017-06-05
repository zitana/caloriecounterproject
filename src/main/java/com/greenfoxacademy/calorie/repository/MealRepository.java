package com.greenfoxacademy.calorie.repository;

import com.greenfoxacademy.calorie.model.Meal;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
  public ArrayList<Meal> findAllByOrderById();

}
