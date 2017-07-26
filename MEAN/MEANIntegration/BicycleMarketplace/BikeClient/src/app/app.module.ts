import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app.routing'; // <--- Routing rules imported

import {Http1Service} from './http1.service'
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { BrowsedashboardComponent } from './browsedashboard/browsedashboard.component';
import { MylistingsdashboardComponent } from './mylistingsdashboard/mylistingsdashboard.component';
import { RegisterComponent } from './main/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    BrowsedashboardComponent,
    MylistingsdashboardComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,  
    AppRoutingModule,
    FormsModule,
    HttpModule
  ],
  providers: [Http1Service],
  bootstrap: [AppComponent]
})
export class AppModule { }
