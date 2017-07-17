import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  each = [
    {
      email: 'bill@gates.com',
      importance: true,
      subject: 'New Windows',
      content: 'Windows XI will launch in year 2019'
    },
    {
      email: 'nikki@mail.com',
      importance: false,
      subject: 'Hello!',
      content: 'Bye'
    },
    {
      email: 'steph@mail.com',
      importance: true,
      subject: 'Important!',
      content: 'ICE CREAM NATIONAL DAY!'      
    },
    {
      email: 'joe@mail.com',
      importance: false,
      subject: 'Not important',
      content: 'Nothing to see here'
    }
  ]
}
