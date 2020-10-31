import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroupDirective, NgForm, Validators} from "@angular/forms";
import {forbiddenNameValidator} from "../validators/firstname.validator";
import {User} from "../user";
import {UserService} from "../user.service";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.sass']
})
export class AddUserComponent implements OnInit {

  addUserForm = this.fb.group({});

  @ViewChild(FormGroupDirective) formGroupDirective: FormGroupDirective;

  constructor(private fb: FormBuilder,
              private userService: UserService) { }

  ngOnInit(): void {
    this.addUserForm = this.fb.group({
      firstName: ['',[
        Validators.required,
        Validators.minLength(2),
        forbiddenNameValidator(/koen/i)]
      ],
      lastName: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['',  [Validators.minLength(8)]]
    }, {updateOn: "blur"});
  }

  onSubmit() {
    this.userService.addUser(this.addUserForm.value)
      .subscribe(user => this.userService.addUserSource$.next(user));
    setTimeout(() =>
      this.formGroupDirective.resetForm(), 0);
  }

  get firstName() { return this.addUserForm.get('firstName'); }

  get lastName() { return this.addUserForm.get('lastName'); }

  get email() { return this.addUserForm.get('email'); }

  get password() { return this.addUserForm.get('password'); }

}
