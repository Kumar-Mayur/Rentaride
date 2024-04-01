import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import path from 'path';
import { FirstpageComponent } from './Component/loginComponent/firstpage/firstpage.component';
import { AdminloginComponent } from './Component/loginComponent/adminlogin/adminlogin.component';
import { HomeComponent } from './Component/userComponet/home/home.component';
import { UserloginComponent } from './Component/loginComponent/userlogin/userlogin.component';
import { UserSignUpComponent } from './Component/loginComponent/user-sign-up/user-sign-up.component';
import { DashboardComponent } from './Component/adminComponent/dashboard/dashboard.component';
import { CarComponent } from './Component/userComponet/car/car.component';
import { ContactComponent } from './Component/userComponet/contact/contact.component';
import { FormsComponent } from './Component/userComponet/forms/forms.component';
import { UserDetailsComponent } from './Component/userComponet/user-details/user-details.component';
import { ExitComponent } from './Component/userComponet/exit/exit.component';
import { ApprovedComponent } from './Component/adminComponent/approved/approved.component';
import { RejectedComponent } from './Component/adminComponent/rejected/rejected.component';

const routes: Routes = [
{
  path:'',
  component:FirstpageComponent,
  pathMatch:'full'

},
{
  path:'adminlogin',
  component:AdminloginComponent,
  pathMatch:'full'
},
{
  path:'userlogin',
  component:UserloginComponent,
  pathMatch:'full'
},
{
  path:'home',
  component:HomeComponent,
  pathMatch:'full'
},
{
  path:'user-sign-up',
  component:UserSignUpComponent,
  pathMatch:'full'
},
{
  path:'dashboard',
  component:DashboardComponent,
  pathMatch:'full'
},
{
  path:'car',
  component:CarComponent,
  pathMatch:'full'
},
{
  path:'contact',
  component:ContactComponent,
  pathMatch:'full'
},
{
  path:'forms',
  component:FormsComponent,
  pathMatch:'full'
},
{
path:'user-details',
component:UserDetailsComponent,
pathMatch:'full'
},
{
  path:'exit',
  component:ExitComponent,
  pathMatch:'full'
},
{
  path:'approved',
  component:ApprovedComponent,
  pathMatch:'full'
},
{
  path:'rejected',
  component:RejectedComponent,
  pathMatch:'full'
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
