import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/shopping/cart.service';
import { Router } from '@angular/router';
import { MenuItemService } from 'src/app/menu-item.service';
import { AuthenticationService } from 'src/app/authentication.service';

@Component({
  selector: 'app-food-menu',
  templateUrl: './food-menu.component.html',
  styleUrls: ['./food-menu.component.css']
})
export class FoodMenuComponent implements OnInit {
  menuItem: any;
  customerMenuItem: any;
  filteredMenuItem: any;
  customerFilteredMenuItem: any;
  oneItem: any;
  userRole: string = '';
  loggedIn: any = false;
  id: number = 0;
  constructor(
    private cartService: CartService,
    private route: Router,
    private menuItemService: MenuItemService,
    private authService: AuthenticationService) { }
  ngOnInit() {

    this.menuItemService.getMenuItemList().subscribe((response) => {
      this.customerMenuItem = response;
      this.menuItem = response;
      this.filteredMenuItem = this.menuItem;
      this.customerFilteredMenuItem = this.customerMenuItem;
      this.userRole = this.authService.getUserRole();
    })
  }
  filterMenuItems($event) {
    this.filteredMenuItem = this.menuItemService.getFilteredItems(this.menuItem, $event);
  }

  customerFilterMenuItems($event) {
    this.customerFilteredMenuItem = this.menuItemService.getFilteredItems(this.customerMenuItem, $event);
  }

  addToCart($event) {
    if (this.userRole != "anoymous") {
      this.id = $event;
      this.cartService.addCartItem(this.id).subscribe((response) => {
        this.loggedIn = response;
      });
    }
    else {
      this.route.navigate(['login', true]);
    }

  }
  editItem($event) {
    this.route.navigate(['edit-item', $event])
  }
}
