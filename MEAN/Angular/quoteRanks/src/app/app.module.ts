import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { QuoteComponent } from './quote/quote.component';
import { AddingAQuoteComponent } from './quote/adding-aquote/adding-aquote.component';
import { QuoteListComponent } from './quote/adding-aquote/quote-list/quote-list.component';

@NgModule({
  declarations: [
    AppComponent,
    QuoteComponent,
    AddingAQuoteComponent,
    QuoteListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
