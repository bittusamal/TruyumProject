import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CartService } from '../cart.service';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/authentication.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  @Output() deleteEmitter: any;
  cart: any;
  total: number;
  status: boolean = false;
  error: any;
  deleteStatus: boolean = false;
  userRole: string = '';
  constructor(private cartService: CartService,
    private route: Router,
    private authService: AuthenticationService) {
    this.deleteEmitter = new EventEmitter();
  }

  ngOnInit() {
    this.cartService.getAllCartItems().subscribe((response) => {
      this.cart = response;
      this.total = this.cartService.getTotal(this.cart);
      this.userRole = this.authService.getUserRole();
    }, (responseError) => this.error = responseError.error.message);
  }

  delete(id) {
    this.deleteStatus = true;
    this.cartService.deleteCart(id).subscribe((response) => {
      this.cart = response;
      this.total = this.cartService.getTotal(this.cart);
      if (this.total == 0) {
        this.status = true;
      }
    });
  }


}
