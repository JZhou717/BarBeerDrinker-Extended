import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import { BeersService, Beer } from './beers.service';

export interface Drinker {
  name: string;
  address: string;

}
export interface DrinkerTop{
  beers: string;
  count: number;
}
@Injectable({
  providedIn: 'root'
})

export class DrinkersService {

  constructor(private http: HttpClient) {   }
  getDrinkers() {
    return this.http.get<any[]>('api/drinker');
  }
  getDrinkerBeers(drinker: string){
    return this.http.get<any[]>('api/topbeer/' + drinker)
  }
  getDrinker(drinker: string){
    return this.http.get<Drinker>('/api/drinker/' + drinker);
  }
  getDrinkerTransactions(drinker: string){
    return this.http.get<any[]>('api/drinkertransaction/' + drinker)
  }
}
