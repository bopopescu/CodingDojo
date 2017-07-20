import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";

import { AppComponent } from './app.component';
import { FormAndScoreComponent } from './form-and-score/form-and-score.component';
import { ScoreComponent } from './form-and-score/score/score.component';
import { HttpService } from './http.service';

@NgModule({
  declarations: [
    AppComponent,
    FormAndScoreComponent,
    ScoreComponent,
    

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
