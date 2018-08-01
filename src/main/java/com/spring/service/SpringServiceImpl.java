package com.spring.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Vehicle;
import com.spring.util.common.CommonConstants;
import com.spring.util.error.response.ErrorCodeHelper;
import com.spring.util.error.response.ErrorInfo;
import com.spring.util.error.response.ServiceException;

@Service
public class SpringServiceImpl implements SpringService {

	private static final Map<String, Vehicle> map = new HashMap<String, Vehicle>();

	@Autowired
	private Vehicle vehicle;

	@Autowired
	private ErrorCodeHelper errorCodeHelper;

	@Override
	public Map<String, Vehicle> entryVehicle(String vehicleNo) {
		Vehicle vehiclecheck = map.get(vehicleNo);
		if (vehiclecheck != null) {
			ErrorInfo errorInfo = errorCodeHelper.getErrorInfo(CommonConstants.E1004_ERROR_CODE,
					CommonConstants.E1004_ERROR_DESCRIPTION);
			throw new ServiceException(errorInfo);
		}
		vehicle.setVehicleNo(vehicleNo);
		vehicle.setEntry_time(new Date());
		map.put(vehicleNo, vehicle);
		return map;
	}

	@Override
	public Map<String, Object> exitVehicle(String vehicleNo) {
		Vehicle vehiclecheck = map.get(vehicleNo);
		if (vehiclecheck == null) {
			ErrorInfo errorInfo = errorCodeHelper.getErrorInfo(CommonConstants.E1005_ERROR_CODE,
					CommonConstants.E1005_ERROR_DESCRIPTION);
			throw new ServiceException(errorInfo);
		}
		Map<String, Object> mapCalculate = new HashMap<String, Object>();
		mapCalculate.put("Charged", getCharge(vehiclecheck.getEntry_time()));
		map.remove(vehicleNo);
		return mapCalculate;
	}

	private Long getCharge(Date date) {
		long diffInMillies = Math.abs(date.getTime() - new Date().getTime());
		long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		if (diff <= 2) {
			if (isWeakend(date))
				return 5l;
			else
				return 7l;
		} else if (diff > 2 && diff <= 5) {
			if (isWeakend(date))
				return 8l;
			else
				return 10l;
		} else if (diff > 5 && diff <= 10) {
			if (isWeakend(date))
				return 12l;
			else
				return 15l;
		} else if (diff > 10 && diff <= 15) {
			if (isWeakend(date))
				return 18l;
			else
				return 22l;
		} else if (diff > 15 && diff <= 24) {
			if (isWeakend(date))
				return 25l;
			else
				return 30l;
		} else {
			ErrorInfo errorInfo = errorCodeHelper.getErrorInfo(CommonConstants.E1006_ERROR_CODE,
					CommonConstants.E1006_ERROR_DESCRIPTION);
			throw new ServiceException(errorInfo);
		}
	}

	private boolean isWeakend(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		return day == Calendar.SUNDAY || day == Calendar.SATURDAY;
	}

}
