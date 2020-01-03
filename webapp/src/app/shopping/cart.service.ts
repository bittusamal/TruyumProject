import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from '../authentication.service';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class CartService {
  httpOptions = {
    headers: new HttpHeaders({
      'content-Type': 'application/json'
    })
  };
  constructor(private httpClient: HttpClient,
    private authenticationService: AuthenticationService,
    private authService: AuthenticationService) {
  }
  getAllCartItems() {
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json',
        'Authorization': token
      })
    }
    let user = this.authService.userRole;
    return this.httpClient.get(environment.baseUrl + "/menuitem-service/truyum/carts/" + user, httpOptions);
  }
  addCartItem(id) {
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json',
        'Authorization': token
      })
    }
    let user = this.authService.userRole;
    return this.httpClient.post(environment.baseUrl + "/menuitem-service/truyum/carts/" + user + "/" + id, {}, httpOptions);
  }
  getTotal(cartMenuItem) {
    let total = 0;
    for (let i = 0; i < cartMenuItem.length; i++) {
      total = total + cartMenuItem[i].price;
    }
    return total;
  }
  deleteCart(id) {
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json',
        'Authorization': token
      })
    }
    let user = this.authService.userRole;
    return this.httpClient.delete(environment.baseUrl + "/menuitem-service/truyum/carts/" + user + "/" + id, httpOptions);
  }
}
