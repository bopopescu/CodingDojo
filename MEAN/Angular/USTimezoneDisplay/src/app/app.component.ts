import { Component } from '@angular/core';
import * as moment from "moment";

import "moment-timezone";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'US Time Zone Display';
  switch: boolean = false;
  thisdate = new Date()
  localtime = this.thisdate.getTime();
  localOffset = this.thisdate.getTimezoneOffset()*60000;
  utc = this.localtime + this.localOffset;
  get = ""
  offset = 0;
  yep = 0
  bgc1 = "white";
  bgc2 = "white";
  bgc3 = "white";
  bgc4 = "white";

  onPST(){
     //this.thisdate = this.thisdate.getTime()
     this.bgc1 = "yellow"
     this.thisdate = new Date()
  }

  onMST(){
     this.offset = 6;
     this.bgc2 = "yellow"
     this.bgc1 = "white";
     this.bgc3 = "white";
     this.bgc4 = "white";
     this.yep = this.utc - (3600000*this.offset)
     this.thisdate = new Date(this.yep)
  }

  onCST(){
     this.offset = 5;
     this.bgc3 = "yellow"
     this.bgc1 = "white";
     this.bgc2 = "white";
     this.bgc4 = "white";
     this.yep = this.utc - (3600000*this.offset)
     this.thisdate = new Date(this.yep)
  }

  onEST(){
     this.offset = 4;
     this.bgc4 = "yellow"
     this.bgc1 = "white";
     this.bgc2 = "white";
     this.bgc3 = "white";
     this.yep = this.utc - (3600000*this.offset)
     this.thisdate = new Date(this.yep)  }

  clear(){
    this.bgc1 = "white";
    this.bgc2 = "white";
    this.bgc3 = "white";
    this.bgc4 = "white";    
    this.thisdate = null;
  }


}
