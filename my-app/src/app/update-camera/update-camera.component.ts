import { Component, OnInit } from '@angular/core';
import { Camera } from '../camera';
import { ActivatedRoute, Router } from '@angular/router';
import { CameraService } from '../camera.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-update-camera',
  templateUrl: './update-camera.component.html',
  styleUrls: ['./update-camera.component.css']
})
export class UpdateCameraComponent implements OnInit {
  
  id: string;
  camera: Camera;
  updateCameraForm: FormGroup;

  constructor(private route: ActivatedRoute, private router: Router,
    private cameraService: CameraService) { }

  ngOnInit() {
    this.camera = new Camera();

    this.id = this.route.snapshot.params['id'];

    this.cameraService.getCamera(this.id)
      .subscribe(data => {
        console.log(data)
        this.camera = data;
      }, error => console.log(error));

      this.updateCameraForm = new FormGroup({
        name: new FormControl(null, Validators.required),
        model: new FormControl(null, Validators.required),
        resolution: new FormControl(null, Validators.required),
        ip: new FormControl(null, Validators.required)
      });
  }
  updateCamera(){
    this.cameraService.updateCamera(this.id, this.camera)
      .subscribe(data => console.log(data), error => console.log(error));
      this.camera = new Camera();
      this.gotoList();
  }
  onSubmit(){

    if(this.updateCameraForm.valid){
      this.updateCamera();
    }
  }
  gotoList(){
    this.router.navigate(['/cameras']);
  }

}
