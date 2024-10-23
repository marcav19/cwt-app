package com.child_wellness_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.child_wellness_tracker.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Integer> { }
