import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class BackendService {
  private apiUrl = "http://localhost:4200"; // Assuming your backend API URL

  constructor(private http: HttpClient) {}

  submitForm(formData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/user-details`, formData);
  }

  getCarFareTypes(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/car-fare-types`);
  }

  getUserDetails(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/user-details`);
  }
}
