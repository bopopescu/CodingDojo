import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { CommunicateService } from '../communicate.service';
import { Subscription } from "rxjs/Subscription";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  users = [];
  subscription: Subscription;
  constructor(private _communicateService: CommunicateService) { 
    this.subscription = _communicateService.observedUsers.subscribe(
			(updatedUsers) => {  this.users = updatedUsers; },
			(err) => { },
			() => { }
		)
  }

  updateUsers(){
    this._communicateService.updateUsers(this.users);
  }

  ngOnInit() {
  }

}
