import { Component } from '@angular/core';
import { Router } from '@angular/router'; // Don't forget this import
import { HttpClient } from '@angular/common/http'; // Don't forget this import
 
@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css'] 
})
export class UserloginComponent {
  email: string ="";
  password: string ="";
 
  constructor(private router: Router, private http: HttpClient) {}
 
  login() { 
    console.log(this.email);
    console.log(this.password);
 
    let bodyData = {
      email: this.email,
      password: this.password,
    };
 
    this.http.post("http://localhost:5001/registration/api/v1/employee/login", bodyData).subscribe(
      (resultData: any) => {
        console.log(resultData);
 
        if (resultData.message == "Email not exists") { 
          alert("Email does not exist");
        } else if (resultData.message == "Login Success") {
          this.router.navigateByUrl('/home');
        } else {
          alert("Incorrect Email or Password. Please try again."); 
        }
      },
      (error) => {
        console.error("Error occurred during login:", error);
        alert("Failed to login. Please try again later.");
      }
    );
  }
}