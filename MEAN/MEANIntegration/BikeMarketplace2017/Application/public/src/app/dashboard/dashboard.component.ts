import { Component, OnInit } from '@angular/core';
import {User} from "../user"
import {HttpService} from '../http.service'
import { Router, RouterModule, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  user: User;
  gettinguser;
  constructor(public _http: HttpService, private router: Router, private _route: ActivatedRoute) { 
    this.user = _http.currentUser;
    // this._route.params.subscribe((params) => {

    // })
   }

  ngOnInit() {
    console.log("hkhk")
    console.log("ing ng", this.user)
    if(this.user){
      this.gettinguser = this.user;
      console.log(this.gettinguser)
      // this._http.findingtheUser(this.user).then(
      //   (data) => {
      //     console.log(data, "in callback dashboard method")
      //     console.log(data.first_name)
      //     this.gettinguser = data.first_name;
      //   }
      // )        
    }

  }

}
