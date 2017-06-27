import { Component } from '@angular/core';
import { HelloService } from "./hello.service";
import {Hello} from "./hello";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    providers: [ HelloService ]
})


export class AppComponent {
    title = 'app';
    greeting: Hello ;

    constructor(private helloService: HelloService) { }

    getGreeting():void {
        this.helloService.greet_jsonp().then(h => this.greeting = h);
    }

    ngOnInit() {
        this.getGreeting();
    }
}
