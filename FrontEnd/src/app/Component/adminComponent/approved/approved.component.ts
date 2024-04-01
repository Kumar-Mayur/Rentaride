import { Component, OnInit } from '@angular/core';
import { User } from '../../Entity/user';
import { Services } from '../../Services';
import { response } from 'express';
import { Router } from '@angular/router';

@Component({
  selector: 'app-approved',
  templateUrl: './approved.component.html',
  styleUrl: './approved.component.css'
})
export class ApprovedComponent  implements OnInit {

  regUsers: User[] = [];
  user: User = new User();
  userId: any;
  filteredUsers: User[] = [];
  filterValue: string = ''; // Initialize filterValue here

  constructor(private service: Services, private router: Router) {}

  ngOnInit():void{
    this.fetchAllUsers();
  }

  fetchAllUsers(): void {
    this.service.getRegisteredUsers().subscribe(
      (response) => {
        this.regUsers = response;
        this.filteredUsers = [...this.regUsers]; // Initialize filteredUsers with all users
        console.log(this.regUsers);
      },
      (error) => {
        console.error("Error fetching register users:", error);
      }
    );
  }

  fetchLoginUser(userId:number): void {
    this.service.fetchUserById(this.userId).subscribe(response => {
      this.user = response
    console.log(this.user);
    }
      );
  }

  applyFilter(): void {
    if (this.filterValue.trim() === '') {
      this.filteredUsers = [...this.regUsers]; // Reset filter and show all users
      return;
    }

    this.filteredUsers = this.regUsers.filter((user) =>
      user.carType && user.carType.toLowerCase().includes(this.filterValue.toLowerCase())||
      user.fullname && user.fullname.toLowerCase().includes(this.filterValue.toLowerCase())||
      user.status && user.status.toLowerCase().includes(this.filterValue.toLowerCase())
    );
  }
  approveUser(user:User):void{
    console.log('approveUser Trigger');

    user.status = true;
    console.log('this.user::: ',user);

    this.service.approveUser(user).subscribe(
      (data:any)=>
        this.user = data);

  }
  rejectUser(user:User):void{
    user.status = false;
    console.log('this.user::: ',user);
    this.service.approveUser(user).subscribe(
      (data:any)=>
        this.user = data);
  }

}

