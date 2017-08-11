import { Component, OnInit } from '@angular/core';
import {User} from '../user'
import {HttpService} from '../http.service'
import { Router, RouterModule, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  logintitle = "Login!"
  registertitle = "Register!"
  user: User = new User();
  errorslogin = "";
  constructor(private _httpService: HttpService, private router: Router, private _route: ActivatedRoute) { }

  ngOnInit() {
  }

  LoggingIn(){
    console.log("in main.comp.ts logging in user")
    console.log("the note: ", this.user)
    this._httpService.findingtheUser(this.user)
    .then(
      user => {
      console.log(user, "this is in then callback getNoted");
      this.user = user
      this.router.navigate(['dashboard']);
      })
    .catch((err)=> {
    
      if(err.status == "401"){
        this.errorslogin = "You need to register!"
      }
      else if(err.status == "402"){
        this.errorslogin = "Wrong password!"
      }
    }
    )

    
  }

}
