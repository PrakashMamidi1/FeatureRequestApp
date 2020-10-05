import { Component, OnInit } from '@angular/core';
import { FeatureService } from 'src/app/services/feature.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Feature } from 'src/app/model/feature';

@Component({
  selector: 'app-feature-details',
  templateUrl: './feature-details.component.html',
  styleUrls: ['./feature-details.component.css']
})
export class FeatureDetailsComponent implements OnInit {
  currentFeature : Feature;
  message = 'Click Update';

  constructor(
    private featureService: FeatureService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getFeature(this.route.snapshot.paramMap.get('id'));
  }

  getFeature(id): void {
    this.featureService.get(id)
      .subscribe(
        data => {
          this.currentFeature = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }



  updateFeature(): void {
    this.featureService.update(this.currentFeature.id, this.currentFeature)
      .subscribe(
        response => {
          console.log(response);
          this.message = 'The feature was updated successfully!';
        },
        error => {
          this.message = 'Unable to update due an internal error!';

          console.log(error);
        });
  }

  deleteFeature(): void {
    this.featureService.delete(this.currentFeature.id)
      .subscribe(
        response => {
          this.message = 'The feature was deleted successfully!';

          console.log(response);
          this.router.navigate(['/features']);
        },
        error => {
          this.message = 'Unable to delete due an internal error!';

          console.log(error);
        });
  }
}
 