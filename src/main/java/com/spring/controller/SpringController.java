package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.SpringService;
import com.spring.util.common.CommonConstants;
import com.spring.util.success.response.ResponseJson;

@RestController
@RequestMapping(CommonConstants.BASE_URL)
public class SpringController {

	@Autowired
	private ResponseJson responseJson;
	@Autowired
	private SpringService service;
	
	@PostMapping("vehicleEntry")
	public ResponseJson entryVehicle(@RequestParam("vehicleNo") String vehicleNo)
	{
		responseJson.setResponseDescription("Name Added Successfully");
		responseJson.setResponse(service.entryVehicle(vehicleNo));
		return responseJson;
	}
	
	@PostMapping("vehicleExit")
	public ResponseJson exitVehicle(@RequestParam("vehicleNo") String vehicleNo)
	{
		//ResponseJson responseJson = StaticContextHolder.getBean(ResponseJson.class);
		responseJson.setResponseDescription("Your Parking Charge");
		responseJson.setResponse(service.exitVehicle(vehicleNo));
		return responseJson;
	}
}
