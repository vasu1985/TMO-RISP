package com.tmobile.returns.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.returns.domain.Device;
import com.tmobile.returns.repository.DeviceRepository;

@Service
public class DeviceService {
	@Autowired
	private DeviceRepository deviceRepository;
	private List<Device> devices = null;

	public String addDevice(Device device) {
		deviceRepository.save(device);
		return "IMEI->" + device.getImei() + " added sucessfully";
	}

	// TODO addDevices()

	public List<Device> getDevices() {
		devices = new ArrayList<>();
		deviceRepository.findAll().forEach(devices::add);
		return devices;
	}

	public Device getDeviceDetails(String imei) {
		/*
		 * Device device = null; if (null != devices) { device =
		 * devices.stream().filter(t ->
		 * t.getImei().equals(imei)).findFirst().get(); } return device;
		 */
		return deviceRepository.findOne(imei);

	}

	public String updateDevice(String imei, Device updatedDevice) {
		/*
		 * for(Device device : getDevices()){ if(null != device &&
		 * device.getImei().equals(updatedDevice.getImei())){
		 * 
		 * } }
		 */

		/*for (int i = 0; i < getDevices().size(); i++) {
			Device d = getDevices().get(i);
			if (d.getImei().equals(imei)) {

			}
		}*/
		deviceRepository.save(updatedDevice);
		return updatedDevice.getImei()+" updated sucessfully";
		
	}
	public String deleteDevice(String imei){
		deviceRepository.delete(imei);
		return "device with imei-> "+imei+"deleted successfully";
	}

}
