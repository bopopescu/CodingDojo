import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { SeattleComponent } from './seattle/seattle.component';
import { SanJoseComponent } from './san-jose/san-jose.component';
import { LosAngelesComponent } from './los-angeles/los-angeles.component';
import { DallasComponent } from './dallas/dallas.component';
import { ChicagoComponent } from './chicago/chicago.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
    {path: "", component: HomeComponent},
    {path: 'seattle', component: SeattleComponent},
    {path: 'sanjose', component: SanJoseComponent},
    {path: 'losangeles', component: LosAngelesComponent},
    {path: 'dallas', component: DallasComponent},
    {path: 'chicago', component: ChicagoComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
