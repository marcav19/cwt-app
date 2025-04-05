package com.child_wellness_tracker.controller;

import org.springframework.web.bind.annotation.RestController;
import com.child_wellness_tracker.model.Meal;
import com.child_wellness_tracker.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class MealController {

    @Autowired
    MealRepository mealDbRepo;
    
    @GetMapping("/api/meals")
    public List<Meal> getAllMeals() {
        
            return mealDbRepo.findAll();

    }

    @GetMapping("/api/meals/{mealId}")
    public Meal getMealById(@PathVariable("mealId") Integer id) {

        return mealDbRepo.findById(id).get();

    }

    @PostMapping("/api/meals")
    public Meal createMeal(@RequestBody Map<String, String> body) {

        String dateTimeStr = body.get("date_time");
        Timestamp dateTime = Timestamp.valueOf(dateTimeStr);

        String name = body.get("name");
        String note = body.get("note");
        
        Meal newMeal = new Meal(dateTime, name, note);

        return mealDbRepo.save(newMeal);

    }
    
    @PutMapping("/api/meals/{mealId}")
    public Meal updateMeal(@PathVariable("mealId") Integer id, @RequestBody Map<String, String> body) {

        Meal current = mealDbRepo.findById(id).get();
        current.setName(body.get("name"));
        current.setNote(body.get("note"));

        return mealDbRepo.save(current);
        
    }

    @DeleteMapping("/api/meals/{mealId}")
    public String deleteMeal(@PathVariable("mealId") Integer id) {
        
        if (!mealDbRepo.findById(id).equals(Optional.empty())) {

            mealDbRepo.deleteById(id);
            return "Entry deleted.";

        } else { return "Entry not found"; }

    }

}
