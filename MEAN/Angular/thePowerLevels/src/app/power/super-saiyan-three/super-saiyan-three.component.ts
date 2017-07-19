import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-super-saiyan-three',
  templateUrl: './super-saiyan-three.component.html',
  styleUrls: ['./super-saiyan-three.component.css']
})
export class SuperSaiyanThreeComponent implements OnInit {
  @Input() thatpowerlevel;
  constructor() { }

  ngOnChanges(){
    this.thatpowerlevel = this.thatpowerlevel*250;
  }

  ngOnInit() {
  }

}
