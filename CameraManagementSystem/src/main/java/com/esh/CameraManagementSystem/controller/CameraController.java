//ErtugertShkulaku
package com.esh.CameraManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.esh.CameraManagementSystem.model.Camera;
import com.esh.CameraManagementSystem.service.CameraServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CameraController {

	@Autowired
	CameraServices cameraService;


	@PostMapping(value="/cameras")
	public String addCamera(@RequestBody Camera camera) {
		cameraService.createCamera(camera);
		return "Camera with name "+camera.getName()+" created succesfuly";
	}
	
	@GetMapping(value="/cameras")
	public List<Camera> findAllCameras(){
		return cameraService.getAllCameras();
	}
	
	@GetMapping(value="/cameras/{id}")
	public ResponseEntity<Camera> findCameraById(@PathVariable String id) {
		
		Optional<Camera> camera = cameraService.getCameraById(id);
		return camera.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	
	}
	@DeleteMapping(value="/cameras/{id}")
	public ResponseEntity<String> deleteCameraById(@PathVariable("id") String id)  {
		String result = "";
		if(id != null) {
			Camera camera = cameraService.getCameraById(id).get();
			if(camera != null) {
				cameraService.deleteCameraById(id);
				result = "Succesfuly deleted";
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
		}else {
			result = "Specify id";
		}
		return new ResponseEntity<>(result, HttpStatus.OK);

	}
	@PutMapping(value = "cameras/{id}")
	public ResponseEntity<String> updateCamera(@Validated @RequestBody Camera camera) {
		cameraService.updateCamera(camera);
		return new ResponseEntity<>("Update Succesful", HttpStatus.OK);
	}
	
	

}
