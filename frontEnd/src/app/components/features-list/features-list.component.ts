import { Component, OnInit } from '@angular/core';
import { FeatureService } from 'src/app/services/feature.service';
import { Feature } from 'src/app/model/feature';

@Component({
  selector: 'app-features-list',
  templateUrl: './features-list.component.html',
  styleUrls: ['./features-list.component.css']
})
export class FeaturesListComponent implements OnInit {

  features: Feature[];
  currentFeature = null;
  currentIndex = -1;
  title = '';

  constructor(private featureService: FeatureService) { }

  ngOnInit(): void {
    this.retrieveFeatures();
  }

  retrieveFeatures(): void {
    this.featureService.getAll()
      .subscribe(
        data => {
          this.features = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveFeatures();
    this.currentFeature = null;
    this.currentIndex = -1;
  }

  setActiveFeature(feature, index): void {
    this.currentFeature = feature;
    this.currentIndex = index;
  }

  removeAllFeatures(): void {
    this.featureService.deleteAll()
      .subscribe(
        response => {
          console.log(response);
          this.retrieveFeatures();
        },
        error => {
          console.log(error);
        });
  }

  searchTitle(): void {
    this.featureService.findByTitle(this.title)
      .subscribe(
        data => {
          this.features = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}