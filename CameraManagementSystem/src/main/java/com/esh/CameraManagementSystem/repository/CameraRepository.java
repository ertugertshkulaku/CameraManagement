package com.esh.CameraManagementSystem.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.esh.CameraManagementSystem.model.Camera;
@Repository
public interface CameraRepository extends MongoRepository<Camera, String>{
	
	public List<Camera> findByNameLike(String name);
}
