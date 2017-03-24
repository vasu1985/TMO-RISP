
package com.tmobile.retailinventoryserialization.command.device.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.tmobile.retailinventoryserialization.base.domain.shared.BaseServiceResponse;
import com.tmobile.retailinventoryserialization.base.service.BaseService;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.Device;
import com.tmobile.retailinventoryserialization.command.device.repository.DeviceCommandRepository;

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
@Validated
@Service
public class DeviceCommandService extends BaseService {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(DeviceCommandService.class);

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
	public BaseServiceResponse<String> addDevice(@Valid Device device) {
		deviceCommandRepository.save(device);
		log.info("addDevice IMEI->" + device.getImei());
		BaseServiceResponse<String> brr = new BaseServiceResponse<String>();
		// BaseServiceResponse<AddDeviceResponse> brr = new
		// BaseServiceResponse<AddDeviceResponse>();
		// AddDeviceResponse dr = new AddDeviceResponse();
		// dr.setMessage(device.getImei() + " updated sucessfully");
		// brr.setResult(dr);
		brr.setResult(device.getImei() + " updated sucessfully");
		return brr;
	}

	// TODO addDevices()

	/**
	 * Delete device.
	 *
	 * @param imei
	 *            the imei
	 * @return the string
	 */
	public String deleteDevice(String imei) {
		deviceCommandRepository.delete(imei);
		log.info("deleteDevice IMEI->" + imei);
		return "device with imei-> " + imei + "deleted successfully";
	}

	public BaseServiceResponse<Device> getDeviceDetails(String imei) {
		BaseServiceResponse<Device> brr = new BaseServiceResponse<Device>();
		// BaseServiceResponse<GetDeviceResponse> brr = new
		// BaseServiceResponse<GetDeviceResponse>();
		// GetDeviceResponse gdr = new GetDeviceResponse();
		// gdr.setDevice(deviceCommandRepository.findOne(imei));
		// brr.setResult(gdr);
		brr.setResult(deviceCommandRepository.findOne(imei));

		return brr;
	}

	/**
	 * Update device.
	 *
	 * @param imei
	 *            the imei
	 * @param updatedDevice
	 *            the updated device
	 * @return the string
	 */
	public BaseServiceResponse<String> updateDevice(String imei, @Valid Device updatedDevice) {
		deviceCommandRepository.save(updatedDevice);
		log.info("updatedDevice IMEI->" + updatedDevice.getImei());
		BaseServiceResponse<String> brr = new BaseServiceResponse<String>();
		// UpdateDeviceResponse dr = new UpdateDeviceResponse();
		// dr.setMessage(updatedDevice.getImei() + " updated sucessfully");
		// brr.setResult(dr);
		brr.setResult(updatedDevice.getImei() + " updated sucessfully");
		return brr;

	}

}
