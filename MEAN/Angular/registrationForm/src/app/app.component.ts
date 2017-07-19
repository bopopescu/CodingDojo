import { Component } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Registration';
  right: boolean = true;
  what: boolean = false;
  user = new User();
  disuser = [];
  onSubmit(){
    this.disuser.push(this.user)
    this.right = false;
    this.what = true;
  }


}
