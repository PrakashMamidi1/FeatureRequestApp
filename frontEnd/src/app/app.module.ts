import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddFeatureComponent } from './components/add-feature/add-feature.component';
import { FeatureDetailsComponent } from './components/feature-details/feature-details.component';
import { FeaturesListComponent } from './components/features-list/features-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    AddFeatureComponent,
    FeatureDetailsComponent,
    FeaturesListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,   
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
