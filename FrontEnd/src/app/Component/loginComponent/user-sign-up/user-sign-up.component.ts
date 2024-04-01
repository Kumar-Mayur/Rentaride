import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { provideHttpClient } from '@angular/common/http';
@Component({
  selector: 'app-user-sign-up',
  templateUrl: './user-sign-up.component.html',
  styleUrls: ['./user-sign-up.component.css'] // Corrected property name to styleUrls
})
export class UserSignUpComponent {
  employeename: string ="";
  email: string ="";
  password: string ="";
  constructor(private http: HttpClient) {
  }
 
  save() {
    let bodyData = {
      "employeename": this.employeename,
      "email": this.email,
      "password": this.password
    };
 
    this.http.post("http://localhost:5001/registration/api/v1/employee/save", bodyData, { responseType: 'text' }).subscribe(
      (resultData: any) => {
        console.log(resultData);
        alert("Employee Registered Successfully");
      },
      (error) => {
        console.error("Error occurred while registering employee:", error);
        alert("Failed to register employee. Please try again.");
      }
    );
  }
}