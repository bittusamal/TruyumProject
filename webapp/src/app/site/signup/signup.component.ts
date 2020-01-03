import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signUp: FormGroup;
  signupStatus: string = "false";
  error: any;
  constructor(private userService: UserService, private route: Router, private router: ActivatedRoute) { }

  ngOnInit() {
    this.router.paramMap.subscribe(params => {
      this.signupStatus = params.get('error');
    })
    this.signUp = new FormGroup({
      'userName': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'firstName': new FormControl('', [Validators.required]),
      'lastName': new FormControl('', [Validators.required]),
      'password': new FormControl('', [Validators.required]),
      'confirmPassword': new FormControl('', [Validators.required])
    })

  }
  signup(signUp) {
    this.userService.addUser(signUp).subscribe((response) => {
      this.route.navigate(['login']);
    }, (responseError) => {
      this.error = responseError.error.message;
      if (responseError.error.message == "User Already Exist") {
        this.route.navigate(['login', "true", "abc"]);
      }
      console.log(this.error);
    });

  }
}


