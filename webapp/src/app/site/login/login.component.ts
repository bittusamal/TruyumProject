import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/authentication.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  signUpUser: any;
  errorStatus: boolean = false;
  loginStatus: string = "false";
  signedStatus: any = false;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private userService : UserService) { }

  ngOnInit() {
    
    this.route.paramMap.subscribe(params => {
      this.signedStatus = params.get('pass');
      this.loginStatus = params.get('err');
    })
    this.loginForm = new FormGroup({
      'userName': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'password': new FormControl('', [Validators.required])
    })
  }
  login(loginForm) {
    this.authenticationService.authenticate(loginForm.value.userName, loginForm.value.password).subscribe((response) => {
      this.authenticationService.setToken(response.token);
      this.authenticationService.login(response.user);
      this.router.navigate(['foodMenu']);
    }, (error) => {
      if (error.status == 401) {
        this.errorStatus = true;
      }
    });
  }

}
