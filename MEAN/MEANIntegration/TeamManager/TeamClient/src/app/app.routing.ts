import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './main/main.component';
import { AddingplayerComponent } from './main/addingplayer/addingplayer.component';
import { PlayerstatusComponent } from './main/playerstatus/playerstatus.component';
const routes: Routes = [
  { path: '', pathMatch: 'full', component: MainComponent },

  { path: 'players/addplayer', component: AddingplayerComponent },
  { path: 'status/game/:id', component: PlayerstatusComponent },
  { path: 'gohome', redirectTo: '/' }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }