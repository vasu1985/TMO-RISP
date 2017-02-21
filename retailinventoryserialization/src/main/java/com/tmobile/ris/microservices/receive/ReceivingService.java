package com.tmobile.ris.microservices.receive;

import java.util.List;

public interface ReceivingService {

	List<Stock> getStores();

	Stock getStoreDetails(String stockinLocId);

	Device validateSerialNumber(String serialNumber);

	Stock addStock(Stock stock);
}
