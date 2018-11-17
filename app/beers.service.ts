import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
export interface Beer{
  beer: string;
  manufacturer: string;
}
export interface BeerLocation {
  bar: string;
  price: number;
  
}
@Injectable({
  providedIn: 'root'
})
export class BeersService {

  constructor(private http: HttpClient) {   }
  getBeers() {
    return this.http.get<any[]>('api/beer');
  }
  getBarsSelling(beer: string){
    return this.http.get<BeerLocation[]>('/api/bars-selling');
  }
  getBeer(beer: string){
    return this.http.get<Beer>('/api/beer/' + beer);
  }
  getBeerTopBars(beer: string){
    return this.http.get<any[]>('api/beertopbar/' + beer);
  }
}
