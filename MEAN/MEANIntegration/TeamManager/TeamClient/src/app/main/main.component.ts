import { Component, OnInit } from '@angular/core';
import {Player} from '../player'
import {HttpService} from '../http.service'

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  player: Player = new Player();
  moreplayers = [];
  constructor(private _httpService: HttpService) { 
  }

  ngOnInit() {
    this._httpService.observedPlayers.subscribe(
      
      (moreplayers) => {
        this.moreplayers = moreplayers;
      }
    )
    this.getPlayers();
  }

  getPlayers(){
    console.log("in main.comp.ts getting players")
    this._httpService.gettingPlayers()
    .then(moreplayers => {
      console.log(moreplayers, "this is in then callback getNoted");
      this.moreplayers = moreplayers
    })
    .catch(err => {console.log(err)})
  }

  deletingPlayer(thatplayer, index){
    console.log("in main.comp.ts deleting the player")
    console.log(this.moreplayers.indexOf(thatplayer))
    this._httpService.deletingThePlayer(thatplayer, index);
    
    
  }


}
