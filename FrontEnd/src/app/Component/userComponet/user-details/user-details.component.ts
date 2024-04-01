import { Component } from "@angular/core";

import { BackendService } from "../../../backend.service";
@Component({
  selector: "app-user-details",

  templateUrl: "./user-details.component.html",

  styleUrls: ["./user-details.component.css"],
})
export class UserDetailsComponent {
  userDetails: any = {};

  carFareTypes: string[] = [];

  constructor(private backendService: BackendService) {}

  submitForm(formData: any): void {
    this.backendService.submitForm(formData).subscribe(
      (response) => {
        console.log("Form submitted successfully:", response);

        this.getUserDetails();
      },

      (error) => {
        console.error("Error submitting form:", error);
      }
    );
  }

  getUserDetails(): void {
    this.backendService.getUserDetails().subscribe(
      (response) => {
        this.userDetails = response;
      },

      (error) => {
        console.error("Error fetching user details:", error);
      }
    );
  }

  getCarFareTypes(): void {
    this.backendService.getCarFareTypes().subscribe(
      (response) => {
        this.carFareTypes = response;
      },

      (error) => {
        console.error("Error fetching car fare types:", error);
      }
    );
  }
}
