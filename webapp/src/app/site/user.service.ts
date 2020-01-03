import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userList: any;
  signUpStatus: boolean = false;
  constructor(private httpClient: HttpClient) {}
  addUser(signUp) {
    this.signUpStatus = true;
    let signUpUser: any = {
      userName: signUp.value.userName,
      password: signUp.value.password,
      firstName : signUp.value.firstName,
      lastName : signUp.value.lastName
    };

    return this.httpClient.post(environment.baseUrl + "/signup-service/truyum/users", signUpUser)
  }
  getUserList() {
    return this.userList;
  }
  getSignUpUser(password) {
    for (let i = 0; i < this.userList.length; i++) {
      if (password == this.userList[i].password) {
        return this.userList[i];
      }
    }
  }
}

