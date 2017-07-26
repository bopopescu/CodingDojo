import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import { Router, RouterModule } from '@angular/router';
import {BehaviorSubject} from 'rxjs/BehaviorSubject'
import 'rxjs';
@Injectable()
export class Http1Service {

  constructor(public _http: Http) { }
  findingtheUser(thatuser){
    console.log("we're finding user for logging in from http.service.ts")
    return this._http.post('/findinguser', {thatuser: thatuser}).map(data=>data.json()).toPromise();
  }

  creatingtheUser(thisuser){
    console.log("we're creating user for logging in from http.service.ts")

    console.log(thisuser)
    return this._http.post('/addinguser', thisuser)
    .map(data=>data.json())
    .toPromise();
    
  }
}
