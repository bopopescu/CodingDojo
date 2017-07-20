import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';


@Component({
  selector: 'app-form-and-score',
  templateUrl: './form-and-score.component.html',
  styleUrls: ['./form-and-score.component.css']
})
export class FormAndScoreComponent implements OnInit {
  title = "GitHub Score"
  ghusername = ""

  //constructor() { }

  ngOnInit() {
  }

    something;
  tasks;
  constructor(private _httpService: HttpService){
    this.something = "something";
  }

  onSubmit(){
    this._httpService.retrieveTasks(this.ghusername)
      .then( (tasks) => { 
        console.log(tasks.followers)
        console.log(tasks.public_repos)
        tasks = tasks.followers + tasks.public_repos
        this.tasks = tasks;
      })
      .catch( (err) => { 
        console.log(err); 
      })
  }

}
