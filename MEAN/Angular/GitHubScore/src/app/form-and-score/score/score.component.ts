import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-score',
  templateUrl: './score.component.html',
  styleUrls: ['./score.component.css']
})
export class ScoreComponent implements OnInit {
  @Input() gettinguserscore;
  whattosay = "";
  wordcolor = ""
  constructor() { }

  ngOnInit() {
  }

  scoring(number){
    if(number < 20){
      console.log("sdsds", number)
      this.whattosay = "Needs Work!"
      this.wordcolor = "red"
      console.log(this.whattosay)
    }
    else if(number >= 20 && number < 50){
      this.whattosay = "A decent start!"
      this.wordcolor = "orange"
    }
    else if(number >= 50 && number < 100){
      this.whattosay = "Doing good!"
      this.wordcolor = "black"
    }
    else if(number >= 100 && number < 200){
      this.whattosay = "Great Job!"
      this.wordcolor = "green"
    }
    else if(number >= 200){
      this.whattosay = "Github Elite!"
      this.wordcolor = "blue"
    }
    return true;
  }

}
