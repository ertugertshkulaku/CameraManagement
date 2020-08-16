import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CameraListComponent } from './camera-list/camera-list.component';
import { CreateCameraComponent } from './create-camera/create-camera.component';
import { UpdateCameraComponent } from './update-camera/update-camera.component';
import { CameraDetailsComponent } from './camera-details/camera-details.component';


const routes: Routes = [
  {path: '', redirectTo: 'cameras', pathMatch: 'full'},
  {path: 'cameras', component: CameraListComponent},
  {path: 'add', component: CreateCameraComponent},
  {path: 'update/:id', component: UpdateCameraComponent},
  {path: 'details/:id', component: CameraDetailsComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
