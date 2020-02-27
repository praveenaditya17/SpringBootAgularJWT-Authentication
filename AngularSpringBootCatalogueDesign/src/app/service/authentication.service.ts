import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import {map} from 'rxjs/operators';

export class User{
  constructor(public status:string){

  }
}
export class JwtResponse{
  constructor(public jwrtocken:string){

  }
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  object:any;
  constructor(private httpClient:HttpClient) { }

    authenticate(username, password) {
     return  this.httpClient.post<any>('http://localhost:8080/authenticate',{username,password});
    }
  
    isUserLoggedIn() {
      let user = sessionStorage.getItem('username');
      return !(user === null);
    }
    logOut() {
      sessionStorage.removeItem('username');
    }


}
