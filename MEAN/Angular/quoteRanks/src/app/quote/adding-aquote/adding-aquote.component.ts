import { Component, OnInit } from '@angular/core';
import { Quote } from '../quote';

@Component({
  selector: 'app-adding-aquote',
  templateUrl: './adding-aquote.component.html',
  styleUrls: ['./adding-aquote.component.css']
})
export class AddingAQuoteComponent implements OnInit {
  title = "Add a Quote"
  quote = new Quote();
  morequotes = [];
  constructor() { };
  

  ngOnInit() {
  }

  onSubmit(){
    console.log(this.quote);
    this.morequotes.push(this.quote);
    this.quote = new Quote();
  }
  

}
