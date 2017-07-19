import { Component, OnInit, Input, Output } from '@angular/core';

@Component({
  selector: 'app-quote-list',
  templateUrl: './quote-list.component.html',
  styleUrls: ['./quote-list.component.css']
})
export class QuoteListComponent implements OnInit {
  @Input() morequotes;
  constructor() { }

  ngOnInit() {
  }

  title = "Quotes List"

  voteup(that){
    that.votes = 1 + that.votes;
  }

  votedown(that){
    that.votes = that.votes-1;
  }

  delete(that){
    var gettheindex = this.morequotes.indexOf(that)
    if(gettheindex > -1){
      this.morequotes.splice(gettheindex, 1)
    }
  }

  greater(that){
    if(that > 0){
      return true;
    }
  }

  lesser(that){
    if(that <= 0){
      return true;
    }
  }

}
