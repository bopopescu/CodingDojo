import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-power',
  templateUrl: './power.component.html',
  styleUrls: ['./power.component.css']
})
export class PowerComponent implements OnInit {
  thatpowerlevel: number;

  constructor(
    
  ) {  }

  ngOnInit() {
    this.thatpowerlevel = 1;
  }

}
