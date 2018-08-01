package com.spring.model;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class UserDataForm {
	
	private String name;
	private List<MultipartFile> file;
	private Map<String,String> map;
	
	public Map<String, String> getMap() {
		return map;
	}
	
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "UserDataForm [name=" + name + ", file=" + file + ", map=" + map + "]";
	}

	

}
