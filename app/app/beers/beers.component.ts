import { Component, OnInit } from '@angular/core';
import {BeersService} from '../beers.service';
@Component({
  selector: 'app-beers',
  templateUrl: './beers.component.html',
  styleUrls: ['./beers.component.css']
})
export class BeersComponent implements OnInit {
  beers: any[];

  constructor(private beerService: BeersService) { 
    this.beerService.getBeers().subscribe(
      data => {
        this.beers = data;
      }
    );
  }

  ngOnInit() {
  }

}
