import { Component, OnInit } from '@angular/core';
import {DrinkersService, Drinker, DrinkerTop} from '../drinkers.service';
import {HttpResponse} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';
declare const Highcharts: any;
@Component({
  selector: 'app-drinker-details',
  templateUrl: './drinker-details.component.html',
  styleUrls: ['./drinker-details.component.css']
})
export class DrinkerDetailsComponent implements OnInit {
  drinkerName: string;
  drinkerDetails: Drinker;
  
  constructor(private route: ActivatedRoute, private drinkerService: DrinkersService) {
    
    route.paramMap.subscribe(paramMap => {
      this.drinkerName = paramMap.get('drinker');
      drinkerService.getDrinker(this.drinkerName).subscribe(
        data => {
          this.drinkerDetails = data;
        },
        (error: HttpResponse<any>) => {
          if (error.status === 404){
            alert('Drinker not found');
          }else{
            console.error(error.status + '-' + error.body);
            alert('Error on the server');
          }
        }

      );
    });
  
  }

  ngOnInit() {
  }
  renderChart(beers: string[], counts: number[]){
    Highcharts.chart('bargraph', {
      chart: {
        type: 'column'
      },
      title: {
        text: 'Top Beers Purchased'
      },
      xAxis: {
        categories: beers,
        title: {
          text: 'Beer'
        }
      },
      yAxis: {
        min: 0,
        title: {
          text: 'Number of Beers Purchased'
        },
        labels: {
          overflow: 'justify'
        }
      },
      plotOptions: {
        drinker: {
          dataLabels: {
            enabled: true
          }
        }
      },
      legend: {
        enabled: false
      },
      credits: {
        enabled: false
      },
      series: [{
        data: counts
      }]
    });
  }
}
