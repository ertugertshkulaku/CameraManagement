import { Component, OnInit } from '@angular/core';
import { Camera } from '../camera';
import { ActivatedRoute, Router } from '@angular/router';
import { CameraService } from '../camera.service';

@Component({
  selector: 'app-camera-details',
  templateUrl: './camera-details.component.html',
  styleUrls: ['./camera-details.component.css']
})
export class CameraDetailsComponent implements OnInit {
  id: string;
  camera: Camera;

  constructor(private route: ActivatedRoute, private router: Router, private cameraService: CameraService) { }

  ngOnInit(): void {
    this.camera = new Camera();
    this.id = this.route.snapshot.params['id'];
    this.cameraService.getCamera(this.id)
      .subscribe(data => {
        console.log(data)
        this.camera = data;
      },error => console.log(error));
  }
  list(){
    this.router.navigate(['cameras']);
  }

}
