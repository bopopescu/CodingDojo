import { Component } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // anumber: number = 10;
  // name: string = "Sushma Mangalapally"
  // title = 'app works';
  // user = {
  //   firstName: "Beyonce",
  //   lastName: "Knowles"
  // }
  // amount = 1.20;
  // today = new Date();
  // loggedIn = true;
  // numbers = [1,2,3,4,5]
  // color  ='blue'
  // switch: boolean = true;
  // num: number = 1;
  // logNum(){
  //   console.log('num is ', this.num)
  // }

  // increaseNum(){
  //   this.num = this.num +1;
  // }

  // getusers = []

  // getuser = {
  //   firstName: '',
  //   lastName: '',
  //   email: '',
  //   password: ''
  // }

  // onSubmit(){
  //   console.log("on submit!");
  //   this.getusers.push(this.getuser)
  // }
  user = new User();
  users = [];
  onSubmit(){
    this.users.push(this.user);
    this.user = new User();
  }

}
