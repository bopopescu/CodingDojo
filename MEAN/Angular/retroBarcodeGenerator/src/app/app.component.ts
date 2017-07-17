import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Retro Barcode Generator';
  arrayofColorsHEX = [
    "#e6ffff", "#ccffff", "#b3ffff",
    "#66ffff", "#33ffff", "#00e6e6",
    "#00b3b3", "#009999", "#008080",
    "#006666", "#004d4d"
  ]

  getthatcolor = function(){
    return (Math.floor(Math.random()*10));
  }
}
