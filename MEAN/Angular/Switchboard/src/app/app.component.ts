import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Switchboard';
  onoroff = [
    false, false, false, false, false, false, false, false, false, false, false
  ]

  onandoff(color){
    this.onoroff[color] = !this.onoroff[color]
  }
}
