import { Component, OnInit } from '@angular/core';
import { FeatureService } from 'src/app/services/feature.service';
import { Feature } from 'src/app/model/feature';

@Component({
  selector: 'app-add-feature',
  templateUrl: './add-feature.component.html',
  styleUrls: ['./add-feature.component.css']
})
export class AddFeatureComponent implements OnInit {
  feature: Feature =  this.getAutoFilledFeature() ;
  submitted = false;

  constructor(private featureService: FeatureService) { }

  ngOnInit(): void {
  }

  saveFeature(): void {
 

    this.featureService.create(this.feature)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newFeature(): void {
    this.submitted = false;
    this. feature =  this.getAutoFilledFeature() ;
  }

  getAutoFilledFeature(): Feature {
    var oneYearFromNow = new Date();
    oneYearFromNow.setFullYear(oneYearFromNow.getFullYear() + 1);
    var oneYearFromNowstr = this.formatDate(oneYearFromNow);
    console.log(oneYearFromNowstr);

    let f =  new Feature( "" , "", "ClientA", 10,  oneYearFromNowstr, "Reports")  ;
    return f;
  }

   formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
}

}