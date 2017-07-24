import { Component, OnInit } from '@angular/core';
import {Player} from '../../player'
import {HttpService} from '../../http.service'
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-addingplayer',
  templateUrl: './addingplayer.component.html',
  styleUrls: ['./addingplayer.component.css']
})
export class AddingplayerComponent implements OnInit {
  title = "Add Player"
  player: Player = new Player();
  moreplayers = [];
  constructor(private _httpService: HttpService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(){
    console.log("in addingplayer.comp.ts submitting players")
    console.log("the note: ", this.player)
    this._httpService.creatingThePlayer(this.player)
    .then(player => {this.moreplayers.push(player)})
    .catch(err=> {console.log(err)})
    this.player = new Player();
    this.router.navigate(['/']);
  }

}
