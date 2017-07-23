import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs';
@Injectable()
export class NotesService {

  constructor(public _http: Http) { }

  

  retrieveTasks(){
    console.log("we're getting notes!")
    return this._http.get('/notes').map(data=>data.json()).toPromise();
  }

  postNotes(note){
    console.log("we're posting notes!")
    console.log(note)
    return this._http.post('/notes', note)
    .map(data=>data.json())
    .toPromise();
  }



}

