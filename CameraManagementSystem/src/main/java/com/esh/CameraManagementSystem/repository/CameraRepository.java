package com.esh.CameraManagementSystem.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.esh.CameraManagementSystem.model.Camera;
@Repository
public interface CameraRepository extends MongoRepository<Camera, String>{
	
	public List<Camera> findByNameLike(String name);
	public List<Camera> findByModelLike(String model);
	public List<Camera> findByNameLikeAndModelLike(String name, String Model);
	
//	{$or:[{'name':{$regex:/192.168.1.12/i}},{'model':{$regex: /192.168.1.12/i}},{'resolution':{$regex: /192.168.1.12/i}},{'ip':{$regex: /192.168.1.12/i}}]}
	@Query(value="{$or:[{'name':{$regex:/?0/i}},{'model':{$regex: /?0/i}}{'resolution':{$regex: /?0/i}},{'ip':{$regex: /?0/i}}]}")
	public List<Camera> searchCameras(String name);
	
}
