import { Component, OnInit } from '@angular/core';

import { BarsService, Bar } from '../bars.service';

@Component({
  selector: 'app-bars',
  templateUrl: './bars.component.html',
  styleUrls: ['./bars.component.css']
})
export class BarsComponent implements OnInit {

  bars: Bar[];

  constructor(
    public barService: BarsService
  ) {  }

  ngOnInit() { 
    this.getBars();
  }

  getBars() {
    this.barService.getBars().subscribe(
      data => {
        this.bars = data;
      },
      error => {
        alert('Could not recieve a list of bars');
      }

    );

  }

}
