import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Camera } from '../camera';
import { Router } from '@angular/router';
import { CameraService } from '../camera.service';


@Component({
  selector: 'app-camera-list',
  templateUrl: './camera-list.component.html',
  styleUrls: ['./camera-list.component.css']
})

 export class CameraListComponent implements OnInit {
  cameras: Observable<Camera[]>;
  searchText;
 
  constructor(private cameraService: CameraService, private router: Router) { }

  ngOnInit(){
    this.reloadData();

  }

  reloadData(){
     this.cameras = this.cameraService.getCamerasList();
  }


  deleteCamera(id: string){
    this.cameraService.deleteCamera(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }
  cameraDetails(id: string){
    this.router.navigate(['details', id]);
  }
  updateCamera(id: string){
    this.router.navigate(['update', id]);
  }
  
}
