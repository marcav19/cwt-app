import { Injectable } from '@angular/core';
import { Meal } from './meal';

@Injectable({
  providedIn: 'root'
})
export class MealService {
  private url = "http://localhost:8080/api/meals"

  constructor() { }

  async getAllMeals(): Promise<Meal[]> {
    const data = await fetch(this.url);
    return (await data.json()) ?? [];
  }

}
