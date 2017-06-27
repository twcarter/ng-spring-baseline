import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule, JsonpModule  }    from '@angular/http';

import { HelloService } from './hello.service'
import { AppComponent } from './app.component';

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        HttpModule,
        JsonpModule
    ],
    providers: [HelloService],
    bootstrap: [AppComponent]
})
export class AppModule { }
