import { Component, OnInit } from '@angular/core';
import { Camera } from '../camera';
import { CameraService } from '../camera.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-camera',
  templateUrl: './create-camera.component.html',
  styleUrls: ['./create-camera.component.css']
})
export class CreateCameraComponent implements OnInit {
 
  createCameraForm: FormGroup;
  camera: Camera = new Camera();
  submitted = false;
  

  constructor(private cameraService: CameraService, private router: Router) { }

  ngOnInit() {
    this.createCameraForm = new FormGroup({
      name: new FormControl(null, Validators.required),
      model: new FormControl(null, Validators.required),
      resolution: new FormControl(null, Validators.required),
      ip: new FormControl(null, Validators.required)
    });
  }

  newCamera(): void {
    this.submitted = false;
    this.camera = new Camera();
  }
  save(){
    this.cameraService.createCamera(this.camera)
      .subscribe(data => console.log(data), error => console.log(error));
      this.camera = new Camera();
      this.gotoList();
  }
  onSubmit(){
    if(this.createCameraForm.valid){
      this.submitted = true;
      this.save();
    }
  }
  gotoList(){
    this.router.navigate(['/cameras']);
  }

}
