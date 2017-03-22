
package com.tmobile.retailinventoryserialization.command.device.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.tmobile.retailinventoryserialization.base.domain.shared.BaseResponse;
import com.tmobile.retailinventoryserialization.base.domain.shared.BaseRestResponse;
import com.tmobile.retailinventoryserialization.base.service.BaseService;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.AddDeviceResponse;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.Device;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.GetDeviceResponse;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.UpdateDeviceResponse;
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
	public BaseResponse addDevice(Device device) {
		deviceCommandRepository.save(device);
		log.info("addDevice IMEI->" + device.getImei());
		BaseRestResponse<AddDeviceResponse> brr = new BaseRestResponse<AddDeviceResponse>();
		AddDeviceResponse dr = new AddDeviceResponse();
		dr.setMessage(device.getImei() + " updated sucessfully");
		brr.setResult(dr);
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

	public BaseResponse getDeviceDetails(String imei) {
		BaseRestResponse<GetDeviceResponse> brr = new BaseRestResponse<GetDeviceResponse>();
		GetDeviceResponse gdr = new GetDeviceResponse();
		gdr.setDevice(deviceCommandRepository.findOne(imei));
		brr.setResult(gdr);

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
	public BaseResponse updateDevice(String imei, @Valid Device updatedDevice) {
		deviceCommandRepository.save(updatedDevice);
		log.info("updatedDevice IMEI->" + updatedDevice.getImei());
		BaseRestResponse<UpdateDeviceResponse> brr = new BaseRestResponse<UpdateDeviceResponse>();
		UpdateDeviceResponse dr = new UpdateDeviceResponse();
		dr.setMessage(updatedDevice.getImei() + " updated sucessfully");
		brr.setResult(dr);
		return brr;

	}

}
