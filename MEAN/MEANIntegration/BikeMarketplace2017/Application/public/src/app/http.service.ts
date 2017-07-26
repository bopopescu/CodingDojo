import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import { Router, RouterModule } from '@angular/router';
import {BehaviorSubject} from 'rxjs/BehaviorSubject'
import {User} from "./user";
import 'rxjs';
@Injectable()
export class HttpService {
  currentUser: User = null;
  constructor(public _http: Http) { }
  findingtheUser(thatuser){
    console.log("we're finding user for logging in from http.service.ts")
    this.currentUser = thatuser;
    return this._http.post('/findinguser', {thatuser: thatuser}).map(data=>data.json()).toPromise();
  }

  creatingtheUser(thisuser){
    console.log("we're creating user for logging in from http.service.ts")
    if(this.currentUser == null){
      this.currentUser = thisuser;
    }
    console.log(thisuser)
    return this._http.post('/addinguser', thisuser)
    .map(data=>data.json())
    .toPromise();
    
  }
}
