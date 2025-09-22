import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Api } from './core/api';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected status = signal('unknown');
  protected readonly title = signal('poker-trainer');

  constructor(private api: Api) {}

  ngOnInit() {
    this.check();
  }
  
  check() {
    this.api.health().subscribe({
      next: (txt) => this.status.set(txt),
      error: () => this.status.set('down'),
    });
  }
}
