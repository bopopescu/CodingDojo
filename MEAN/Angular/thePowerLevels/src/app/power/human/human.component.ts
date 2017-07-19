import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-human',
  templateUrl: './human.component.html',
  styleUrls: ['./human.component.css']
})
export class HumanComponent implements OnInit {
  @Input() thatpowerlevel;
  constructor(
  ) { }

  ngOnChanges(){
    this.thatpowerlevel = this.thatpowerlevel*1
  }

  ngOnInit() {
  }

}
