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
  timeTypes = ["PST", "MST", "CST", "EST", "Clear"];
  activeTime;
  getcolor;

  updateTime(gettime){
    if(gettime == "MST"){
      this.offset = 6;
      this.yep = this.utc - (3600000*this.offset)
      this.thisdate = new Date(this.yep)
      this.getcolor = "yellow"
    }
    else if(gettime == "PST"){
      this.thisdate = new Date()
      this.getcolor = "yellow"
    }
    else if(gettime == "CST"){
      this.offset = 5;
      this.yep = this.utc - (3600000*this.offset)
      this.thisdate = new Date(this.yep)
      this.getcolor = "yellow"
    }
    else if(gettime == "EST"){
      this.offset = 4;
      this.yep = this.utc - (3600000*this.offset)
      this.thisdate = new Date(this.yep)
      this.getcolor = "yellow"
    }
    else if(gettime == "Clear"){
      this.thisdate = null;
      this.getcolor = "grey"
    }

    this.activeTime = gettime;
    
  }




}
