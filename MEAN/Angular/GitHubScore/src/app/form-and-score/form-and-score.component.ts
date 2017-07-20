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
  gettinguserscore;
  constructor(private _httpService: HttpService){
    this.something = "something";
  }

  onSubmit(){
    this._httpService.retrieveUserData(this.ghusername)
      .then( (userscore) => { 
        console.log(userscore.followers)
        console.log(userscore.public_repos)
        userscore = userscore.followers + userscore.public_repos
        this.gettinguserscore = userscore;
      })
      .catch( (err) => { 
        console.log(err); 
      })
  }

}
