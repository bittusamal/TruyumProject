import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private authenticationUrl = environment.baseUrl + "/authentication-service/truyum/authenticate";
  private token: string;
  userRole: string = "anoymous";
  guardStatus: boolean = false;
  constructor(private httpClient: HttpClient) { }

  authenticate(user: string, password: string): Observable<any> {
    let credentials = btoa(user + ":" + password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credentials);
    return this.httpClient.get(this.authenticationUrl, { headers });
  }

  public getToken(): string {
    return this.token;
  }

  public setToken(token: string): void {
    this.token = token;
  }

  login(userrole) {
    this.guardStatus = true;
    this.userRole = userrole;
  }
  logout() {
    this.guardStatus = false;
    this.userRole = "anoymous";
  }
  getUserRole() {
    return this.userRole;
  }
}
