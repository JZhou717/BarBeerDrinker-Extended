import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface Bar{
  name: string;
  location: string;
  opening_hours: string;
  closing_hours: string;
}

@Injectable({
  providedIn: 'root'
})
export class BarsService {

  constructor(
    public http: HttpClient
  ) { }

  getBars(){
    return this.http.get<Bar[]>('/api/bar');
  }
  getBar(bar: string){
    return this.http.get<Bar>('/api/bar/' + bar);
  }
}
