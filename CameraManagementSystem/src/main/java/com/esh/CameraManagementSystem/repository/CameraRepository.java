package com.esh.CameraManagementSystem.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.esh.CameraManagementSystem.model.Camera;
@Repository
public interface CameraRepository extends MongoRepository<Camera, String>{
	

	
}
