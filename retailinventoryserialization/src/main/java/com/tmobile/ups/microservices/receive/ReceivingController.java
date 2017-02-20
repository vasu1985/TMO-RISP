package com.tmobile.ups.microservices.receive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceivingController {

	@Autowired
	private ReceivingService receivingService;

	@RequestMapping(value = "/resources/stores/{id}", method = RequestMethod.GET)
	public Stock getStoreDetails(@PathVariable String id) {
		return receivingService.getStoreDetails(id);
	}

	@RequestMapping(value = "/resources/stores", method = RequestMethod.GET)
	public List<Stock> getStores() {
		System.out.println("###############################################################################################");
		return receivingService.getStores();
	}

	@RequestMapping(value = "/resources/serializedproduct/validate/{serialNumber}", method = RequestMethod.GET)
	public Device validateSerialNumber(@PathVariable String serialNumber) {
		return receivingService.validateSerialNumber(serialNumber);
	}

}
