import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  userRole: string = '';
  constructor(
    private route: Router,
    private authService: AuthenticationService) { }

  ngOnInit() {

  }
  getUserRole() {
    this.userRole = this.authService.getUserRole();
    return this.userRole;
  }
  logout() {
    this.authService.logout();
    this.route.navigate(['']);
  }

}
