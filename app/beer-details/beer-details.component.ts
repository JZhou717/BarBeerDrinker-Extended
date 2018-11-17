import { Component, OnInit } from '@angular/core';
import {BeersService, Beer} from '../beers.service';
import {HttpResponse} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-beer-details',
  templateUrl: './beer-details.component.html',
  styleUrls: ['./beer-details.component.css']
})
export class BeerDetailsComponent implements OnInit {
  beerName: string;
  beerDetails: Beer;
  beerTopBars: any[];
  constructor(private route: ActivatedRoute, private beerService: BeersService) {
    route.paramMap.subscribe(paramMap => {
      this.beerName = paramMap.get('beer');
      beerService.getBeer(this.beerName).subscribe(
        data => {
          this.beerDetails = data;
        },
        (error: HttpResponse<any>) => {
          if (error.status === 404){
            alert('Beer not found');
          }else{
            console.error(error.status + '-' + error.body);
            alert('Error on the server');
          }
        }

      );
    });
    this.beerService.getBeerTopBars(this.beerName).subscribe(
      data => {
        console.log(data);
        this.beerTopBars = data;
      }
    )
  
  }

  ngOnInit() {
  }

}
