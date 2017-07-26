import { Component, OnInit } from '@angular/core';
import {User} from '../../user'
import {Http1Service} from '../../http1.service'
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registertitle = "Register!"
  user: User = new User();
  moreusers = [];
  constructor(private _httpService: Http1Service, private router: Router) { }


  ngOnInit() {
  }

  Registering(){
    console.log("in main.comp.ts registering the user")
    console.log("the note: ", this.user)
    this._httpService.creatingtheUser(this.user)
    .then(user => {this.moreusers.push(user)})
    .catch(err=> {console.log(err)})
    this.user = new User();
    // this.router.navigate(['/dashboard']);    
  }

}
