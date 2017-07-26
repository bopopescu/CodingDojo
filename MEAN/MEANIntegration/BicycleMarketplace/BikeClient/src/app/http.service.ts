import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import { Router, RouterModule } from '@angular/router';
import {BehaviorSubject} from 'rxjs/BehaviorSubject'
import 'rxjs';
@Injectable()
export class HttpService {
  // moreplayers = [];
  // moreusers = [];

  // observedPlayers = new BehaviorSubject(this.moreplayers);

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

  // gettingPlayers(){
  //   console.log("we're getting players!")
  //   return this._http.get('/players/list').map(data=>data.json()).toPromise();
    
  // }

  // deletingThePlayer(thatplayer, index){
  //   console.log("we're deleting players!")
  //   console.log(thatplayer._id)
  //   console.log(index)
  //   console.log("Players list", this.moreplayers)
  //   var prom  = this._http.post('/deleteplayers/'+thatplayer._id, {thatplayer: thatplayer}).map(data=>data.json()).toPromise();
  //   prom.then(
  //     (data)=>{this.moreplayers.splice(index, 1)}
  //   )
  //   return prom;
  // }

  // creatingThePlayer(thisplayer){
  //   console.log("we're creating players!")
  //   console.log(thisplayer.id)
  //   return this._http.post('/addingplayer', thisplayer).map(data=>data.json())
  //   .toPromise();
  // }

  // updatingthePlayer(thisplayer, game, newstatus){
  //   console.log("updating player! in http")
  //   console.log(newstatus)
  //   status = newstatus
  //   return this._http.post('/updateplayers/'+thisplayer._id, {newstatus:newstatus, game: game})
  //   .map(data=>data.json())
  //   .toPromise();
    
  // }

}
