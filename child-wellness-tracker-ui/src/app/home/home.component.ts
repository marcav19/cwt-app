import { Component } from '@angular/core';
import { MealsComponent } from "../meals/meals.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MealsComponent],
  template: `
    <section>
      <app-meals></app-meals>
    </section>
  `,
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
