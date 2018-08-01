package com.spring.model;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.util.common.CommonConstants;
@Component
@Scope(CommonConstants.PROPTYPE)
public class Vehicle {
	
	private String vehicleNo;
	private Date entry_time;
	private Date exit_time;
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public Date getExit_time() {
		return exit_time;
	}
	public void setExit_time(Date exit_time) {
		this.exit_time = exit_time;
	}
	
	

}
