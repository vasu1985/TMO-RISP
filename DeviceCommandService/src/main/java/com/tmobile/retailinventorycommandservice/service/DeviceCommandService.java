
package com.tmobile.retailinventorycommandservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.retailinventorycommandservice.domain.Device;
import com.tmobile.retailinventorycommandservice.repository.DeviceCommandRepository;

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
public class DeviceCommandService {

	/** The device repository. */
	@Autowired
	private DeviceCommandRepository deviceCommandRepository;

	/**
	 * Adds the device.
	 *
	 * @param device
	 *            the device
	 * @return the string
	 */
	public String addDevice(Device device) {
		deviceCommandRepository.save(device);
		return "IMEI->" + device.getmImei() + " added sucessfully";
	}

	// TODO addDevices()

	/**
	 * Update device.
	 *
	 * @param imei
	 *            the imei
	 * @param updatedDevice
	 *            the updated device
	 * @return the string
	 */
	public String updateDevice(Device updatedDevice) {
		deviceCommandRepository.save(updatedDevice);
		return updatedDevice.getmImei() + " updated sucessfully";

	}

	/**
	 * Delete device.
	 *
	 * @param imei
	 *            the imei
	 * @return the string
	 */
	public String deleteDevice(String imei) {
		deviceCommandRepository.delete(imei);
		return "device with imei-> " + imei + "deleted successfully";
	}

	public Device getDeviceDetails(String imei) {
		return deviceCommandRepository.findOne(imei);
	}

}
