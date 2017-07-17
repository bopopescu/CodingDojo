import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  anumber: number = 10;
  name: string = "Sushma Mangalapally"
  title = 'app works';
  user = {
    firstName: "Beyonce",
    lastName: "Knowles"
  }
  amount = 1.20;
  today = new Date();
  loggedIn = true;
  numbers = [1,2,3,4,5]
  color  ='blue'
  switch: boolean = true;

}
