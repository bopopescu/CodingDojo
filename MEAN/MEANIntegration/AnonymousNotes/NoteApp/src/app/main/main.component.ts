import { Component, OnInit } from '@angular/core';
import {Note} from '../note'
import {NotesService} from '../notes.service'
import {OrderModule} from 'ngx-order-pipe';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  title = "Anonymous Notes"
  note: Note = new Note();
  morenotes = [];

 constructor(private _notesService: NotesService){

  }

  ngOnInit() {
    this.getNotes();
  }  

  onSubmit(){
    console.log("in main.comp.ts submitting notes")
    console.log("the note: ", this.note.text)
    this._notesService.postNotes(this.note)
    .then(note => {this.morenotes.push(note)})
    .catch(err=> {console.log(err)})
    this.note = new Note();
  }



  getNotes(){
    console.log("in main.comp.ts getting notes")
    this._notesService.retrieveTasks()
    .then(morenotes => {
      console.log(morenotes, "this is in then callback getNoted");
      // var sortable = [];
      // for (var vehicle in morenotes) {
      //   sortable.push([vehicle, morenotes['createdAt']]);
      // }
      // sortable.sort(function(a, b) {
      //     return a[1] - b[1];
      // });    
      // console.log(sortable)  
    this.morenotes = morenotes
    })
    .catch(err => {console.log(err)})
  }

}

 