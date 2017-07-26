import { Injectable } from '@angular/core';
import {Bike} from "./bike";
import 'rxjs/Rx'
import {Http} from '@angular/http';
@Injectable()
export class BikeService {

  constructor(public _http: Http) { }

  create(bike){
    console.log(bike, "this is create method for bike")
    return this._http.post('/creatingbike', bike)
    .map(data => data.json())
    .toPromise();
  }

  findUsersBike(theuser){
    console.log("finding the list of bike of the user's  in bike.service.ts")
    console.log("the suer", theuser)
    return this._http.post('/usersbikeslist', {theuser: theuser})
    .map(data => data.json())
    .toPromise();
  }

  allBikes(){
    return this._http.get('/allbikes')
    .map(data => data.json())
    .toPromise();    
  }

  findBike(filter_bike){
    console.log("finding bike in bike.service")
    return this._http.post('/searchbike', {filter_bike: filter_bike})
    .map(data => data.json())
    .toPromise();    
  }

}
