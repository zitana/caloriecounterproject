package com.greenfoxacademy.calorie.controller;

import com.greenfoxacademy.calorie.model.Meal;
import com.greenfoxacademy.calorie.model.Response;
import com.greenfoxacademy.calorie.model.Statistics;
import com.greenfoxacademy.calorie.repository.MealRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

  @Autowired
  MealRepository mealRepository;

  @RequestMapping(value = "/getmeal" , method = RequestMethod.GET)
  public List<Meal> getmMeals() {
    return mealRepository.findAllByOrderById();
  }

  @RequestMapping(value = "/getstats" , method = RequestMethod.GET)
  public Statistics getStats() {
    return new Statistics(mealRepository.findAllByOrderById());
  }

  @RequestMapping(value = "/meal" , method = RequestMethod.POST)
  public Meal postMeal(@RequestBody Meal meal) {
    mealRepository.save(meal);
    return meal;
  }

  @RequestMapping(value = "/meal" , method = RequestMethod.PUT)
  public Response updateMeal(@RequestBody Meal meal) {
    try {
      Meal myMeal = mealRepository.findOne(meal.getId());
      myMeal.updateMeal(meal);
      mealRepository.save(myMeal);
      return new Response("ok");
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return new Response("bad");
    }
  }

  @RequestMapping(value = "/meal" , method = RequestMethod.DELETE)
  public Response deleteMeal(@RequestBody Meal meal) {
    String status = "";
    try {
      mealRepository.delete(meal.getId());
      if (mealRepository.findAllByOrderById().contains(mealRepository.findOne(meal.getId()))) {
        status = "bad";
      } else {
        status = "ok";
      }
    } catch (NullPointerException ex) {
        System.out.println("No meal with this ID");
      }
      return new Response(status);
    }

}
