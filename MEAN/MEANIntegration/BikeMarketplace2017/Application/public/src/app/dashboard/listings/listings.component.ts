import { Component, OnInit } from '@angular/core';
import {User} from "../../user"
import {HttpService} from '../../http.service'
import {BikeService} from '../../bike.service'

import { Router, RouterModule, ActivatedRoute } from '@angular/router';
import {Bike} from "../../bike"

@Component({
  selector: 'app-listings',
  templateUrl: './listings.component.html',
  styleUrls: ['./listings.component.css']
})
export class ListingsComponent implements OnInit {
  createtitle = "Create Listing"
  user: User;
  gettinguserid;
  bikes: Bike[] = []
  bike: Bike =  new Bike();
  constructor(public _http: HttpService, public _bike: BikeService, private router: Router, private _route: ActivatedRoute) { 
    this.user = _http.currentUser;
    // this._route.params.subscribe((params) => {

    // })
   }


  ngOnInit() {
    console.log("hkhk")
    console.log("in listings of listings ", this.user)
    if(this.user){
      this._http.findingtheUser(this.user).then(
        (data) => {
          console.log(data, "in callback dashboard method")
          console.log(data.first_name)
          this.gettinguserid = data._id;
        }
      )        
    }

    this._bike.findUsersBike(this.user)
    .then(
      (data) => {
        console.log("this is calllback for error", data)
        this.bikes = data;      
      }
    )
    .catch((err) => {
      console.log("error retrieving bikes", err)

    })
  }

  CreatingBike(){
    console.log("Creating bike", this.bike)
    console.log("the user of bike", this.gettinguserid)
    this.bike.userId = this.gettinguserid
    this._bike.create(this.bike)
      .then((data) => {
        console.log("calling in component data", data)
        console.log(data.bike, "dsdsdsd")
        console.log("bikes array", this.bikes)
        this.bikes.push(data.bike)
        this.bike = new Bike();
      })
  }



}
