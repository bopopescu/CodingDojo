import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import  'rxjs/Rx';

@Injectable()
export class HttpService {

  constructor(private _http: Http) { }

  gettingWeater(city: string){
    return this._http.get('http://api.openweathermap.org/data/2.5/weather?q='+city+',usa&APPID=56d04b44687f1ebdb10d724cdc52fd05')
    .map(weatherdata=>weatherdata.json())
    .toPromise()
  }

}
