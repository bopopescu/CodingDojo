import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-seattle',
  templateUrl: './seattle.component.html',
  styleUrls: ['./seattle.component.css']
})
export class SeattleComponent implements OnInit {

  constructor(private _httpService: HttpService){}
  gettingcitydata;
  humidity;
  avgtemp;
  temp_max;
  temp_min;
  description;
  convert(num){
    return Math.round((9/5)*(num-273)+32)
  }
  ngOnInit() {
    this._httpService.gettingWeater("seattle")
      .then((cityweather) => {
        console.log(cityweather)
        this.humidity = cityweather.main.humidity
        this.avgtemp = this.convert(cityweather.main.temp)
        this.temp_max = this.convert(cityweather.main.temp_max)
        this.temp_min = this.convert(cityweather.main.temp_min)
        this.description = cityweather.weather[0].description
        this.gettingcitydata = cityweather;
      })
      .catch((err) => {
        console.log(err)
      })
  }

}
