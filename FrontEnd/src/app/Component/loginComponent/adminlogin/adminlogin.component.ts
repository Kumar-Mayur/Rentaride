import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
  selector: "app-adminlogin",
  templateUrl: "./adminlogin.component.html",
  styleUrls: ["./adminlogin.component.css"],
})
export class AdminloginComponent {
  username: string;
  password: string;
  errorMessage: string;

  constructor(private router: Router) {}

  login() {
    // Replace this logic with actual authentication logic
    if (this.username === "admin" && this.password === "password") {
      // Successful login
      this.router.navigate(["/dashboard"]);
    } else {
      // Failed login
      this.errorMessage = "Invalid username or password";
    }
  }
}
