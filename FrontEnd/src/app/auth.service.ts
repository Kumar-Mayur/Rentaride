import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private http: HttpClient) {}
  canActivate(): boolean {
    const isLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
    if (isLoggedIn) {
      return true;
    } else {
      this.router.navigate(['/admin/login']);
      return false;
    }
  }
 
  login(username: string, password: string): Observable<any> {
    return this.http.post<any>('http://localhost:5001/api/v1/employee/login', { username, password });
  }
}