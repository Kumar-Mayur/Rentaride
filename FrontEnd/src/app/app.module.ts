import { NgModule } from "@angular/core";
import {
  BrowserModule,
  provideClientHydration,
} from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { provideAnimationsAsync } from "@angular/platform-browser/animations/async";
import { DashboardComponent } from "./Component/adminComponent/dashboard/dashboard.component";
import { NavbarComponent } from "./Component/userComponet/navbar/navbar.component";
import { HomeComponent } from "./Component/userComponet/home/home.component";
import { FooterComponent } from "./Component/userComponet/footer/footer.component";
import { CarComponent } from "./Component/userComponet/car/car.component";
import { BikeComponent } from "./Component/userComponet/bike/bike.component";
import { AirportServiceComponent } from "./Component/userComponet/airport-service/airport-service.component";
import { FormsComponent } from "./Component/userComponet/forms/forms.component";
import { ContactComponent } from "./Component/userComponet/contact/contact.component";
import { HomeMidComponent } from "./Component/userComponet/home-mid/home-mid.component";
import { UserloginComponent } from "./Component/loginComponent/userlogin/userlogin.component";
import { AdminloginComponent } from "./Component/loginComponent/adminlogin/adminlogin.component";
import { UserSignUpComponent } from "./Component/loginComponent/user-sign-up/user-sign-up.component";
import { FirstpageComponent } from "./Component/loginComponent/firstpage/firstpage.component";
import { RouterModule, Routes } from "@angular/router";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { UserDetailsComponent } from "./Component/userComponet/user-details/user-details.component";
import { BackendService } from "./backend.service";
import { ToastrModule } from "ngx-toastr";
import { ExitComponent } from './Component/userComponet/exit/exit.component';
import { DataTablesModule } from "angular-datatables";
import { ApprovedComponent } from './Component/adminComponent/approved/approved.component';
import { RejectedComponent } from './Component/adminComponent/rejected/rejected.component';

const routes: Routes = [
  {
    path: "",
    component: FirstpageComponent,
  },
];

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    NavbarComponent,
    HomeComponent,
    FooterComponent,
    CarComponent,
    BikeComponent,
    AirportServiceComponent,
    FormsComponent,
    ContactComponent,
    HomeMidComponent,
    UserloginComponent,
    AdminloginComponent,
    UserSignUpComponent,
    FirstpageComponent,
    UserDetailsComponent,
    ExitComponent,
    ApprovedComponent,
    RejectedComponent,
   
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule,ToastrModule.forRoot()
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
    BackendService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
