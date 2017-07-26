import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';

import {HttpService} from './http.service'

import {BikeService} from './bike.service'
import { Routes, RouterModule } from '@angular/router';
import { LandingComponent } from './landing/landing.component';
import { RegisterComponent } from './landing/register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BrowsingComponent } from './dashboard/browsing/browsing.component';
import { ListingsComponent } from './dashboard/listings/listings.component';


const routes: Routes = [
  {path: "", pathMatch: 'full', component: LandingComponent},
  {path: "dashboard", component: DashboardComponent},
  {path: "browse", component: BrowsingComponent},
  {path: "listings", component: ListingsComponent}
  
];

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    RegisterComponent,
    DashboardComponent,
    BrowsingComponent,
    ListingsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(routes)
  ],
  providers: [HttpService, BikeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
