import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {HttpModule} from "@angular/http";
import {NotesService} from './notes.service'
import {OrderModule} from 'ngx-order-pipe';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { ChildComponent } from './child/child.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    ChildComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    OrderModule
  ],
  providers: [NotesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
