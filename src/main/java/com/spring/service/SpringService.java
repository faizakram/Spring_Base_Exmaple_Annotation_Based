package com.spring.service;

import java.util.Map;

import com.spring.model.Vehicle;

public interface SpringService {

	Map<String,Vehicle> entryVehicle(String vehicleNo);

	Map<String, Object> exitVehicle(String vehicleNo);

}
