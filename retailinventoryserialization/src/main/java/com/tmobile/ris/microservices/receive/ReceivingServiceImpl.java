package com.tmobile.ris.microservices.receive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.query.FunctionDomainException;
import org.apache.geode.cache.query.NameResolutionException;
import org.apache.geode.cache.query.Query;
import org.apache.geode.cache.query.QueryInvocationTargetException;
import org.apache.geode.cache.query.QueryService;
import org.apache.geode.cache.query.SelectResults;
import org.apache.geode.cache.query.TypeMismatchException;
import org.apache.geode.pdx.PdxInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.text.SimpleDateFormat;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
//import  org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@EnableGemfireRepositories
@Service
public class ReceivingServiceImpl implements ReceivingService {
	
	 ClientCacheFactory cf =  new ClientCacheFactory().addPoolServer( "localhost", 40405);
	   ClientCache cache = cf.setPdxReadSerialized( true).create();
	   ClientRegionFactory rf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
	   
	   Region region = rf.create( "stock");

	@Autowired
	private StockRepository stockRepository;

	private static Log log = LogFactory.getLog(ReceivingServiceImpl.class);

	private List<Stock> stores = Arrays.asList(new Stock(123l, "Factoria T Mobile Retail Store", "TPR", true, true),
			new Stock(456l, "Bothell T Mobile Retail Store", "TPR", true, true),
			new Stock(789l, "Redmond T Mobile Retail Store", "TPR", true, true));

	private List<Device> devices = Arrays.asList(
			new Device("98794242412313432", "IMEI", null, false, false, false, true, null),
			new Device("98794242412313432", "IMEI", null, false, false, false, true, null),
			new Device("98794242412313432", "IMEI", null, false, false, false, true, null));

	@Override
	public List<Stock> getStores() {
		List<Stock> stkList = new ArrayList<>();
		Stock stock;
		try {
			String queryString = "SELECT DISTINCT * FROM /stock";

			 // Get QueryService from client pool.
			 QueryService queryService = null;

			 // Create the Query Object.
			 Query query = queryService.newQuery(queryString);

			 // Execute Query locally. Returns results set.
			 SelectResults results = (SelectResults)query.execute();

			 // Find the Size of the ResultSet.
			 int size = results.size();

			 // Iterate through your ResultSet.
			 
			 stkList = (List<Stock>)results.asList();
			
		} catch (FunctionDomainException | TypeMismatchException | NameResolutionException
				| QueryInvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stkList;
	}

	@Override
	public Stock getStoreDetails(String stockinLocId) {
		 QueryService queryService;
		Stock stockObj =  null;
	    Object obj = null;
		try {
			obj = region.query("select * from /stock where stockingLocationId = "+stockinLocId);
		} catch (FunctionDomainException | TypeMismatchException | NameResolutionException
				| QueryInvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(obj  instanceof PdxInstance){
	     // System.out.println( "Obj is PdxInstance");
	     PdxInstance pi = (PdxInstance)obj;
	      Object obj2 = pi.getObject();
	      if(obj2  instanceof Stock){
	    	  stockObj = (Stock)obj2;
	      }
	    }
		//Stock stock = stores.stream().filter(t -> t.getStockinLocId().equals(stockinLocId)).findFirst().get();
		if (log.isInfoEnabled()) {
			log.info(stockObj);
		}
		return stockObj;
	}

	@Override
	public Device validateSerialNumber(String serialNumber) {
		Device device = devices.stream().filter(t -> t.getSerialNumber().equals(serialNumber)).findFirst().get();
		if (log.isInfoEnabled()) {
			log.info(device);
		}
		return device;
	}

	int i=1;
	@Override
	public Stock addStock(Stock stock) {
		 Map< String,  Object> stkMap =  new HashMap< String,  Object>();
		 stkMap.put(i+++"", stock);
		region.putAll(stkMap);
		
		//stockRepository.save(stock);
		return stock;

	}

}
