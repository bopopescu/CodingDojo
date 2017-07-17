import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
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

  constructor() {
    
   }

  ngOnInit() {

  }
      

}
