package com.greenfoxacademy.calorie.controller;

import com.greenfoxacademy.calorie.model.Meal;
import com.greenfoxacademy.calorie.model.Statistics;
import com.greenfoxacademy.calorie.repository.MealRepository;
import com.greenfoxacademy.calorie.repository.TypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  MealRepository mealRepository;

  @Autowired
  TypeRepository typeRepository;

  @RequestMapping("/")
  public String index(Model model) {
    List<Meal> meals = mealRepository.findAllByOrderById();
    model.addAttribute("meals" , meals);
    model.addAttribute("statistics" , new Statistics(meals));
    return "index";
  }

  @RequestMapping("/addoredit")
  public String addoredit(Model model) {
    model.addAttribute("meals" , mealRepository.findAll());
    model.addAttribute("types" , typeRepository.findAll());
    return "addoredit";
  }

  @RequestMapping("/edit")
  public String edit(
      @RequestParam(name = "id") long id,
      @RequestParam(name = "date") String date,
      @RequestParam(name = "type") String type,
      @RequestParam(name = "description") String description,
      @RequestParam(name = "calories") int calories) {
    Meal meal = mealRepository.findOne(id);
    meal.updateMeal(new Meal(0, date, type, description, calories));
    mealRepository.save(meal);
    return "redirect:/";
  }

  @RequestMapping("/add")
  public String add(
      @RequestParam(name = "date") String date,
      @RequestParam(name = "type") String type,
      @RequestParam(name = "description") String description,
      @RequestParam(name = "calories") int calories) {
    mealRepository.save(new Meal(date,type,description,calories));
    return "redirect:/";
  }

  @RequestMapping("/delete")
  public String delete(@RequestParam("id") long id) {
    mealRepository.delete(id);
    return "redirect:/";
  }

}
