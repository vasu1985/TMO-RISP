package com.tmobile.ups.microservices.receive;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class ReceivingServiceImpl implements ReceivingService {

	private static Log log = LogFactory.getLog(ReceivingServiceImpl.class);

	private List<Stock> stores = Arrays.asList(new Stock("xyz", "Factoria T Mobile Retail Store", "TPR", true, true),
			new Stock("abc", "Bothell T Mobile Retail Store", "TPR", true, true),
			new Stock("123", "Redmond T Mobile Retail Store", "TPR", true, true));

	private List<Device> devices = Arrays.asList(
			new Device("98794242412313432", "IMEI", null, false, false, false, true, null),
			new Device("98794242412313432", "IMEI", null, false, false, false, true, null),
			new Device("98794242412313432", "IMEI", null, false, false, false, true, null));

	@Override
	public List<Stock> getStores() {
		return Arrays.asList(new Stock("xyz", "Factoria T Mobile Retail Store", "TPR", true, true),
				new Stock("abc", "Bothell T Mobile Retail Store", "TPR", true, true),
				new Stock("123", "Redmond T Mobile Retail Store", "TPR", true, true));
	}

	@Override
	public Stock getStoreDetails(String stockinLocId) {
		Stock stock = stores.stream().filter(t -> t.getStockinLocId().equals(stockinLocId)).findFirst().get();
		if (log.isInfoEnabled()) {
			log.info(stock);
		}
		return stock;
		// return new Stock("123", "Redmond T Mobile Retail Store", "TPR", true,
		// true);
	}

	@Override
	public Device validateSerialNumber(String serialNumber) {
		Device device = devices.stream().filter(t -> t.getSerialNumber().equals(serialNumber)).findFirst().get();
		if (log.isInfoEnabled()) {
			log.info(device);
		}
		return device;
	}

}
