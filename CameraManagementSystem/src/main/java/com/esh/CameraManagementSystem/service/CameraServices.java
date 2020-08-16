package com.esh.CameraManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esh.CameraManagementSystem.model.Camera;
import com.esh.CameraManagementSystem.repository.CameraRepository;

@Service
public class CameraServices {
	
	@Autowired
	CameraRepository cameraRepository;
	//Create camera
	public void createCamera(Camera camera) {
		cameraRepository.insert(camera);
	}
	
	//Get All Cameras
	public List<Camera> getAllCameras(){
		List<Camera> result = cameraRepository.findAll();
		return result;
		
	}
	//Get Camera By Id
	public Optional<Camera> getCameraById(String id) {
		return  cameraRepository.findById(id);
		
		
	}
	//Delete Camera by id
	public void deleteCameraById(String id) {
		cameraRepository.deleteById(id);
	}
	//Update Camera by id
	public void updateCamera(Camera camera) {
		cameraRepository.save(camera);
	}
	
	// Search method
	public List<Camera> searchCameras(String name){
		return cameraRepository.findByNameLike(name);
	}
	

}
