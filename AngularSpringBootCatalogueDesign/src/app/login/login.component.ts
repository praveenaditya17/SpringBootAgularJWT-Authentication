import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  username='';
  password='';
  invalidLogin=false;
  constructor(private router:Router,private loginService:AuthenticationService) { }
  ngOnInit() { }

  checkLogin(){ 
    this.loginService.authenticate(this.username,this.password).subscribe(
      data=>{
        sessionStorage.setItem('username',this.username);
        let tokenStr= 'Bearer '+data.token;
        sessionStorage.setItem('token', tokenStr);
        this.router.navigate(['/addcatalogue']);
        this.invalidLogin=false;
      },
      error=>{
        this.invalidLogin=true;
        this.router.navigate(['/pagenotfound']);
      }
    );
  }
}
