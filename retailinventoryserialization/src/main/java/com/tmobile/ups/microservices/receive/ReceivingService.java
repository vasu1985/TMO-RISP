package com.tmobile.ups.microservices.receive;

import java.util.List;

public interface ReceivingService {

	List<Stock> getStores();

	Stock getStoreDetails(String stockinLocId);

	Device validateSerialNumber(String serialNumber);

}
