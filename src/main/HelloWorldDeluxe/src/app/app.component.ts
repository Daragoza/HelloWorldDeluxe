import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})

export class AppComponent implements OnInit {
  title = 'HelloWorldDeluxe';

  ngOnInit(): void {
    console.log('Angular has been loaded and has served the correct HTML page');
  }



}
