
package com.tmobile.retailinventoryserialization.query.device;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmobile.retailinventoryserialization.query.device.domain.shared.Device;
import com.tmobile.retailinventoryserialization.query.device.service.DeviceQueryService;

@Component
public class Consumer {
	/** The log. */
    private static Logger      log                   = LoggerFactory.getLogger(Consumer.class);

	private CountDownLatch latch = new CountDownLatch(1);
	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private DeviceQueryService deviceQueryService;

	public void consumeMessage(String message) {
		log.info("Consumed <" + message + ">");
		try {
			Device updatedDevice = mapper.readValue(message, Device.class);
			log.info(
					"imei-> " + updatedDevice.getmImei() + "\nnew state-> " + updatedDevice.getmState());
			Device deviceToPersist = deviceQueryService.getDeviceDetails(updatedDevice.getmImei());
			deviceToPersist.setmReason(updatedDevice.getmReason());
			deviceToPersist.setmState(updatedDevice.getmState());
			deviceToPersist.setmRepId(updatedDevice.getmRepId());
			deviceQueryService.updateDevice(deviceToPersist);
		} catch (JsonParseException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} catch (JsonMappingException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
