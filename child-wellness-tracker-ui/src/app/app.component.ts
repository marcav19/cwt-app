import { Component } from '@angular/core';
import { HomeComponent } from "./home/home.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HomeComponent],
  template: `
  <main>
    <header class="image=header">
      <img src="/assets/image1.jpg" alt="raccoon with sunglasses" aria-hidden="true" />
    </header>
    <section class="content">
      <app-home></app-home>
    </section>
  </main>
  `,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'child-wellness-tracker-ui';
}
