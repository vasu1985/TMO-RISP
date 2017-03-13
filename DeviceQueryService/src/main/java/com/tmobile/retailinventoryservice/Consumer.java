
package com.tmobile.retailinventoryservice;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmobile.retailinventoryservice.domain.Device;
import com.tmobile.retailinventoryservice.service.DeviceQueryService;

@Component
public class Consumer {

	private CountDownLatch latch = new CountDownLatch(1);
	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private DeviceQueryService deviceQueryService;

	public void consumeMessage(String message) {
		System.out.println("Consumed <" + message + ">");
		try {
			Device device = mapper.readValue(message, Device.class);
			System.out.println("imei-> " + device.getmImei() + "\nnew state-> " + device.getmCurrentState());
			deviceQueryService.updateDevice(device);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
