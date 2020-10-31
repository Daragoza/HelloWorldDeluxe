import { Component, OnInit } from '@angular/core';
import {UserService} from "../user.service";
import {User} from "../user";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.sass']
})
export class UserListComponent implements OnInit {

  users: User[] = [];

  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'email', 'password'];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUsers();
    this.userService.addUserSource$.asObservable().subscribe(_ => this.getUsers());
  }

  getUsers(): void {
    this.userService.getUsers()
      .subscribe(users => this.users = users);
  }

}
