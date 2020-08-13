package com.esh.CameraManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
public class CameraController {

	@Autowired
	CameraServices cameraService;


	@PostMapping(value="/addCamera")
	public String addCamera(@RequestBody Camera camera) {
		cameraService.createCamera(camera);
		return "Camera with name "+camera.getName()+" created succesfuly";
	}
	@GetMapping(value="/allCameras")
	public List<Camera> findAllCameras(){
		return cameraService.getAllCameras();
	}
	@GetMapping(value="/cameraById/{id}")
	public Camera findCameraById(@PathVariable Long id) {
		Camera camera = null;
		if(id != null) {
			camera = cameraService.getCameraById(id);
		}
		return camera;
	}
	@DeleteMapping(value="/deleteCameraById/{id}")
	public String deleteCameraById(@PathVariable Long id) {
		String result = "";
		if(id != null) {
			Camera camera = cameraService.getCameraById(id);
			if(camera != null) {
				cameraService.deleteCameraById(id);
				result = "Succesfuly deleted";
			}else {
				result = "Not exist camera with id " +id;
			}
		}else {
			result = "Specify id";
		}
		return result;

	}
	@PutMapping(value = "updateCamera/{id}")
	public String updateCamera(@Validated @RequestBody Camera camera) {
		cameraService.updateCamera(camera);
		return "Sucessfuly update";
	}

}
