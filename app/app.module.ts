import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';

import { TableModule } from 'primeng/table';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { BeersComponent } from './beers/beers.component';
import { BarDetailsComponent } from './bar-details/bar-details.component';
import { BeerDetailsComponent } from './beer-details/beer-details.component';
import { BarsComponent } from './bars/bars.component';
import { DrinkersComponent } from './drinkers/drinkers.component';
import { DrinkerDetailsComponent } from './drinker-details/drinker-details.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    BeersComponent,
    BarDetailsComponent,
    BeerDetailsComponent,
    BarsComponent,
    DrinkersComponent,
    DrinkerDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    TableModule,
    AppRoutingModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
