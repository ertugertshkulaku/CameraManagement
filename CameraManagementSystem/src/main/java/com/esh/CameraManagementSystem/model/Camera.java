package com.esh.CameraManagementSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "camera")
public class Camera {
	
	
	@Id
	private String id;
	private String name;
	private String model;
	private String resolution;
	private String ip;
	
	//**Default Constructor
	public Camera() {
	}
	
	//**Constructor with parameter
	public Camera(String id, String name, String model, String resolution, String ip) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.resolution = resolution;
		this.ip = ip;
	}

	//**Getter and Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Camera [id=" + id + ", name=" + name + ", model=" + model + ", resolution=" + resolution + ", ip=" + ip
				+ "]";
	}
	
	
	
	
	
	
	

}
