import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app.routing'; // <--- Routing rules imported

import {HttpService} from './http.service'

import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { AddingplayerComponent } from './main/addingplayer/addingplayer.component';
import { PlayerstatusComponent } from './main/playerstatus/playerstatus.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    AddingplayerComponent,
    PlayerstatusComponent
  ],
  imports: [
    BrowserModule,  
    AppRoutingModule,
    FormsModule,
    HttpModule

  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
