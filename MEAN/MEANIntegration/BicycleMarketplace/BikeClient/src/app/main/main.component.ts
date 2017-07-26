import { Component, OnInit } from '@angular/core';
import {User} from '../user'
import {Http1Service} from '../http1.service'
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  logintitle = "Login!"
  registertitle = "Register!"
  user: User = new User();
  moreusers = [];
  constructor(private _httpService: Http1Service, private router: Router) { }

  ngOnInit() {
  }

  LoggingIn(){
    console.log("in main.comp.ts logging in user")
    console.log("the note: ", this.user)
    this._httpService.findingtheUser(this.user)
    .then(
      moreusers => {
      console.log(moreusers, "this is in then callback getNoted");
      this.moreusers = moreusers
      })
    .catch(err=> {console.log(err)})
    // this.router.navigate(['/dashboard']);
  }

  

}
