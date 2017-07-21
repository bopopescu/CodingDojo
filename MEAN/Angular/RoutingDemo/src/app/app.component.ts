import { Component } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { CommunicateService } from './communicate.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  users = [
    {email: 'a@a.com'},
    {email: 'b@b.com'}
  ]
  constructor(private _communicateService: CommunicateService){
    _communicateService.updateUsers(this.users)
  }

  updateUsers(){
    this._communicateService.updateUsers(this.users)
  }
}
