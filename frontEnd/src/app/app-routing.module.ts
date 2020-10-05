import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FeaturesListComponent } from './components/features-list/features-list.component';
import { FeatureDetailsComponent } from './components/feature-details/feature-details.component';
import { AddFeatureComponent } from './components/add-feature/add-feature.component';

const routes: Routes = [
  { path: '', redirectTo: 'features', pathMatch: 'full' },
  { path: 'features', component: FeaturesListComponent },
  { path: 'features/:id', component: FeatureDetailsComponent },
  { path: 'add', component: AddFeatureComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
