import { Component, OnInit } from '@angular/core';
import {Player} from '../../player'
import {HttpService} from '../../http.service'
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-playerstatus',
  templateUrl: './playerstatus.component.html',
  styleUrls: ['./playerstatus.component.css']
})
export class PlayerstatusComponent implements OnInit {

    moreplayers = [];
    gamenumber;
    title;
  constructor(private _httpService: HttpService, private router: Router, private _route: ActivatedRoute) { 
    this._route.params.subscribe((param)=>{
      console.log(param.id);
      this.gamenumber = param.id
    }) 
   }

   

  ngOnInit() {
    this.getPlayers();
    if(this.gamenumber == 1){
      this.title = "1"
   }
    else if(this.gamenumber == 2){
      this.title = "2"
    }
    else if(this.gamenumber == 3){
      this.title = "3"
    }
  }
  

  getPlayers(){
    console.log("in main.comp.ts getting players")
    console.log(this.gamenumber);
    this._httpService.gettingPlayers()
    .then(moreplayers => {
      console.log(moreplayers, "this is in then callback getNoted");
      this.moreplayers = moreplayers
    })
    .catch(err => {console.log(err)})

  }

  updatethatPlayer(player, game, status){
    console.log("in main.comp.ts updating players status")
    console.log(status)
    console.log("game", game)
    this._httpService.updatingthePlayer(player, game, status);
  }

}
