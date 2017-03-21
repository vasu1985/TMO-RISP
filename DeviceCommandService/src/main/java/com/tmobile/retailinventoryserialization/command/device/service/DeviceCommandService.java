
package com.tmobile.retailinventoryserialization.command.device.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
public class DeviceCommandService {

    /** The log. */
    private static Logger           log = LoggerFactory.getLogger(DeviceCommandService.class);

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
    public String addDevice( Device device) {
        deviceCommandRepository.save(device);
        log.info("addDevice IMEI->" + device.getImei());
        return "IMEI->" + device.getImei() + " added sucessfully";
    }

    // TODO addDevices()

    /**
     * Delete device.
     *
     * @param imei
     *            the imei
     * @return the string
     */
    public String deleteDevice( String imei) {
        deviceCommandRepository.delete(imei);
        log.info("deleteDevice IMEI->" + imei);
        return "device with imei-> " + imei + "deleted successfully";
    }

    public Device getDeviceDetails( String imei) {
        return deviceCommandRepository.findOne(imei);
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
    public String updateDevice( @Valid Device updatedDevice) {
        deviceCommandRepository.save(updatedDevice);
        log.info("updatedDevice IMEI->" + updatedDevice.getImei());
        return updatedDevice.getImei() + " updated sucessfully";

    }

}
