import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import {BarDetailsComponent} from './bar-details/bar-details.component';
import {BeersComponent} from './beers/beers.component';
import {BeerDetailsComponent} from './beer-details/beer-details.component'
import {BarsComponent} from './bars/bars.component';
import {DrinkersComponent} from './drinkers/drinkers.component';
import {DrinkerDetailsComponent} from './drinker-details/drinker-details.component'
const routes: Routes = [
  {
    path:'',
    pathMatch: 'full',
    component: WelcomeComponent
  },
  {
    path:'welcome',
    pathMatch: 'full',
    component: WelcomeComponent

  },
  {
    path: 'bars',
    pathMatch: 'full',
    component: BarsComponent

  },
  {
    path: 'bars/:bar',
    pathMatch: 'full',
    component: BarDetailsComponent
  },
  {
    path: "beers",
    pathMatch: "full",
    component: BeersComponent
  },
  {
    path: "beers/:beer",
    pathMatch: "full",
    component: BeerDetailsComponent
  },
  {
    path: "drinkers",
    pathMatch: "full",
    component: DrinkersComponent
  },
  {
    path: "drinkers/:drinker",
    pathMatch: "full",
    component: DrinkerDetailsComponent
  },
  {
    path: "topbeers/:drinker",
    pathMatch: "full",
    component: DrinkerDetailsComponent
  },
  {
    path: "beertopbars/:beer",
    pathMatch: "full",
    component: BeerDetailsComponent
  },
  {
    path: "drinkertransactions/:drinker",
    pathMatch: "full",
    component: DrinkerDetailsComponent
  },
  {
    path: "drinkerspending/:drinker",
    pathMatch: "full",
    component: DrinkerDetailsComponent
  },
  {
    path: "beertopdrinkers/:beer",
    pathMatch: "full",
    component: BeerDetailsComponent
  },
  {
    path: "beertimedist/:beer",
    pathMatch: "full",
    component: BeerDetailsComponent
  },
  {
    path: "bartopdrinkers/:bar",
    pathMatch: "full",
    component: BarDetailsComponent
  },
  {
    path: "bartopbeers/:bar",
    pathMatch: "full",
    component: BarDetailsComponent
  },
  {
    path: "bartopmanf/:bar",
    pathMatch: "full",
    component: BarDetailsComponent
  },
  {
    path: "updateitems/:name",
    pathMatch: "full",
    component: WelcomeComponent
  },
  {
    path: "api/updatebilledto",
    pathMatch: "full",
    redirectTo: "../welcome"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }