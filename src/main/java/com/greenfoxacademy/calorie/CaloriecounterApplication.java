package com.greenfoxacademy.calorie;

import com.greenfoxacademy.calorie.model.Meal;
import com.greenfoxacademy.calorie.model.Type;
import com.greenfoxacademy.calorie.repository.MealRepository;
import com.greenfoxacademy.calorie.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaloriecounterApplication implements CommandLineRunner{

	@Autowired
	TypeRepository typeRepository;

	@Autowired
	MealRepository mealRepository;

	public static void main(String[] args) {
		SpringApplication.run(CaloriecounterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		typeRepository.save(new Type("Breakfast"));
		typeRepository.save(new Type("Elevenses"));
		typeRepository.save(new Type("Lunch"));
		typeRepository.save(new Type("Snack"));
		typeRepository.save(new Type("Dinner"));
		typeRepository.save(new Type("Midnight Snack"));

		mealRepository.save(new Meal("Breakfast", "bacon", 200));
		mealRepository.save(new Meal("Breakfast", "eggs", 150));
		mealRepository.save(new Meal("Lunch", "pasta", 650));
		mealRepository.save(new Meal("Midnight Snack", "beer", 200));
	}

}
