import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {BarsService, Bar} from '../bars.service';
import {HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-bar-details',
  templateUrl: './bar-details.component.html',
  styleUrls: ['./bar-details.component.css']
})
export class BarDetailsComponent implements OnInit {
  barName: string;
  barDetails: Bar;
  barDrinkers: any[];
  barBeers: any[];
  barManfs: any[];
  barTime: any[];
  constructor(
    private barService: BarsService,
    private route: ActivatedRoute
  ) {
    route.paramMap.subscribe(paramMap => {
      this.barName = paramMap.get('bar');
      barService.getBar(this.barName).subscribe(
        data => {
          this.barDetails = data;
        },
        (error: HttpResponse<any>) => {
          if (error.status === 404){
            alert('Bar not found');
          }else{
            console.error(error.status + '-' + error.body);
            alert('Error on the server');
          }
        }

      );
    });
    this.barService.getBarTopDrinkers(this.barName).subscribe(
      data => {
        this.barDrinkers = data;
      }
    )
    this.barService.getBarTopBeers(this.barName).subscribe(
      data => {
        this.barBeers = data;
      }
    )
    this.barService.getBarTopManufacturers(this.barName).subscribe(
      data => {
        this.barManfs = data;
      }
    )
    this.barService.getBarTimeDist(this.barName).subscribe(
      data => {
        this.barTime = data;
      }
    )
   }

  ngOnInit() {
  }

}
