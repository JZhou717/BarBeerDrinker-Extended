import { Component, OnInit } from '@angular/core';
import {DrinkersService} from '../drinkers.service';
@Component({
  selector: 'app-drinkers',
  templateUrl: './drinkers.component.html',
  styleUrls: ['./drinkers.component.css']
})
export class DrinkersComponent implements OnInit {
  drinkers: any[];

  constructor(private drinkerService: DrinkersService) { 
    this.drinkerService.getDrinkers().subscribe(
      data => {
        this.drinkers = data;
      }
    );
  }

  ngOnInit() {
  }

}
