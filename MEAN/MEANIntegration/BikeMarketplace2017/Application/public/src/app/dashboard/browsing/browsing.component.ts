import { Component, OnInit } from '@angular/core';
import {User} from "../../user"
import {HttpService} from '../../http.service'
import {BikeService} from '../../bike.service'

import { Router, RouterModule, ActivatedRoute } from '@angular/router';
import {Bike} from "../../bike"

@Component({
  selector: 'app-browsing',
  templateUrl: './browsing.component.html',
  styleUrls: ['./browsing.component.css']
})
export class BrowsingComponent implements OnInit {
  bike: Bike;
  user: User;
  gettinguserid;
  allbikes: Bike[] = []
  
constructor(public _http: HttpService, public _bike: BikeService, private router: Router, private _route: ActivatedRoute) { 
    this.user = _http.currentUser;
    // this._route.params.subscribe((params) => {

    // })
   }
  ngOnInit() {
    if(this.user){
      this._http.findingtheUser(this.user).then(
        (data) => {
          console.log(data, "in callback browsing method")
          console.log(data.first_name)
          this.gettinguserid = data._id;
        }
      )        
    }
    this._bike.allBikes()
    .then(
      (data) => {
        console.log("this is calllback for error", data)
        this.allbikes = data;  

   
         
      }
    )
    .catch((err) => {
      console.log("error retrieving bikes", err)

    })
  }
  filter_bike;
  Search(){
    console.log(this.filter_bike)
    return this._bike.findBike(this.filter_bike)
    .then(
      (data) => {
        console.log("this is calllback for error", data)
        this.allbikes = data;  

   
         
      }
    )
    .catch((err) => {
      console.log("error retrieving bikes", err)

    })    
  }

}
