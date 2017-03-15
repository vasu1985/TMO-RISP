
package com.tmobile.retailinventoryservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.retailinventoryservice.domain.Device;
import com.tmobile.retailinventoryservice.repository.DeviceQueryRepository;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS DeviceService
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:29:15 PM Author: SS00443175
 */
@Service
public class DeviceQueryService {
	
	/** The log. */
    private static Logger log = LoggerFactory.getLogger(DeviceQueryService.class);


	/** The device repository. */
	@Autowired
	private DeviceQueryRepository deviceQueryRepository;
	// TODO addDevices()

	/**
	 * Gets the devices.
	 *
	 * @return the devices
	 */
	public List<Device> getDevices() {
		List<Device> devices = new ArrayList<>();
		deviceQueryRepository.findAll().forEach(devices::add);
		return devices;
	}

	public String updateDevice(Device updatedDevice) {
		deviceQueryRepository.save(updatedDevice);
		return updatedDevice.getmImei() + " updated sucessfully";

	}

	/**
	 * Gets the device details.
	 *
	 * @param imei
	 *            the imei
	 * @return the device details
	 */
	public Device getDeviceDetails(String imei) {
		return deviceQueryRepository.findOne(imei);

	}

	public String addDevice(Device device) {
		deviceQueryRepository.save(device);
		log.info("IMEI-> added sucessfully");	
		return "IMEI->" + device.getmImei() + " added sucessfully";
	}

}
