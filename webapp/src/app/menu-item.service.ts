import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MenuItemService {
  constructor(private httpClient: HttpClient,
    private authenticationService: AuthenticationService) { }

  getMenuItemList() {
    if (this.authenticationService.userRole == 'anoymous') {
      return this.httpClient.get(environment.baseUrl + "/menuitem-service/truyum/menu-items");
    } else {
      let token = 'Bearer ' + this.authenticationService.getToken();
      const httpOptions = {
        headers: new HttpHeaders({
          'content-Type': 'application/json',
          'Authorization': token
        })
      }
      return this.httpClient.get(environment.baseUrl + "/menuitem-service/truyum/menu-items", httpOptions);
    }
  }

  getEditItem(id) {
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get(environment.baseUrl + "/menuitem-service/truyum/menu-items/" + id, httpOptions);
  }

  editMenuItem(menuItem) {
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.put(environment.baseUrl + "/menuitem-service/truyum/menu-items", menuItem, httpOptions)
  }
  getFilteredItems(menuItem, $event) {
    let filter = $event.toLocaleLowerCase();
    return menuItem.filter((food) => food.name.toLocaleLowerCase().indexOf(filter) != -1);
  }
}
