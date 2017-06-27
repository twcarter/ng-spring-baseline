import { Injectable } from '@angular/core';
import { Http, Jsonp } from '@angular/http';

import { Hello } from './hello'

import 'rxjs/add/operator/toPromise';

@Injectable()
export class HelloService {

    constructor(private http: Http, private jsonp: Jsonp) { }
    
    greet(): Promise<Hello> {

        return this.http.get("http://localhost:8080/ng-baseline/hello")
            .toPromise()
            .then(response => this.handleResponse(response))
            // .then(response => response.json() as Hello)
            .catch(this.handleError);
    }

    greet_jsonp(): Promise<Hello> {

        return this.jsonp.get("http://localhost:8080/ng-baseline/hello?callback=JSONP_CALLBACK")
            .toPromise()
            .then(response => this.handleResponse(response))
            .catch(this.handleError);
    }

    private handleResponse(response): Hello {
        console.log("got  => ", JSON.stringify(response.json()));
        return response.json() as Hello
    }

    private handleError(error: any): Promise<any> {
            console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }

}