import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { HttpClient } from "@angular/common/http";
import { Services } from "../../Services";
import { ToastrService } from "ngx-toastr";
import { Form } from "../../Entity/form";
import { User } from "../../Entity/user";
 
@Component({
  selector: "app-forms",
  templateUrl: "./forms.component.html",
  styleUrls: ["./forms.component.css"],
})
export class FormsComponent implements OnInit {
  fullname!: string;
  phonenumber!: string;
  address!: string;
  dlnumber!: string;
  totalDays!: string;
  carType!: string;
  form: Form = new Form();
  user: User = new User();
 
  constructor(
    private router: Router,
    private http: HttpClient,
    private services: Services,
    private toastr: ToastrService
  ) {}
 
  ngOnInit(): void {}
 
  onSubmit(): void {
    // Populate the User object with form data
    this.user.fullname = this.fullname;
    this.user.phonenumber = this.phonenumber;
    this.user.address = this.address;
    this.user.dlnumber = this.dlnumber;
    this.user.totalDays = this.totalDays;
    this.user.carType = this.carType;
 
    // Call the service method to register the user
    this.services.registerUser(this.user).subscribe(
      (response) => {
        // Response contains the generated booking ID
        console.log(response);
 
        // Optionally, display the booking ID to the user
        this.toastr.success("Your booking ID: " + response.bookingId);
        // Navigate to the exit page
        this.router.navigateByUrl("/exit");
        alert("Thank You, your request has been submitted to us!");
      },
      (error) => {
        console.error("Error registering user:", error);
        // Handle error
      }
    );
  }
}