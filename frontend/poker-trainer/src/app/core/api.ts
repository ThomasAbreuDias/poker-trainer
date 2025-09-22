import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class Api {
  private http = inject(HttpClient);

  health() {
    return this.http.get('/api/health', { responseType: 'text' });
  }
}

