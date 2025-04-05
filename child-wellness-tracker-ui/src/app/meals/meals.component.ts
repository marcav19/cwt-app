import { Component, inject } from '@angular/core';
import { Meal } from '../meal';
import { CommonModule } from '@angular/common';
import { MealService } from '../meal.service';

@Component({
  selector: 'app-meals',
  standalone: true,
  imports: [CommonModule],
  template: `
    <table>
      <thead>
        <tr>
          <th>Date</th>
          <th>Description</th>
          <th>Note</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let meal of meals">
          <td>{{ meal.date }}</td>
          <td>{{ meal.description }}</td>
          <td>{{ meal.note }}</td>
        </tr>
      </tbody>
    </table>
  `,
  styleUrl: './meals.component.css'
})
export class MealsComponent {
  meals: Meal[] = [];
  mealService: MealService = inject(MealService);

  constructor() {
    this.mealService.getAllMeals().then((meals: Meal[]) => {
      this.meals = meals;
    });
  }
}
