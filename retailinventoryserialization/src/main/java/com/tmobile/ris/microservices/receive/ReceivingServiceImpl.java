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
import org.springframework.boot.SpringApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.stereotype.Service;

import com.tmobile.ris.microservices.Retailinventoryserialization;

@EnableGemfireRepositories
@Service
public class ReceivingServiceImpl implements ReceivingService {
	
	Region<String, String>  region; 
	ClientCache cache;
	   public ReceivingServiceImpl() {
		super();
		cache = new ClientCacheFactory()
				.setPdxPersistent(true)
		      .addPoolLocator("locator", 10334)
		      .create();
		
		region = cache
			      .<String, String>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY)
			      .create("stock");
	}

	@Autowired
	private StockRepository stockRepository;

	private static Log log = LogFactory.getLog(ReceivingServiceImpl.class);

//	private List<Stock> stores = Arrays.asList(new Stock(123l, "Factoria T Mobile Retail Store", "TPR", true, true),
//			new Stock(456l, "Bothell T Mobile Retail Store", "TPR", true, true),
//			new Stock(789l, "Redmond T Mobile Retail Store", "TPR", true, true));

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
//		/https://geode.apache.org/docs/guide/developing/query_additional/using_query_bind_parameters.html
		String queryString = "select * from /stock s WHERE s.stockingLocationId = $1";

		QueryService queryService = cache.getQueryService();
		Query query = queryService.newQuery(queryString);

		// set query bind parameters
		Object[] params = new Object[1];
		params[0] = stockinLocId;

		// Execute the query locally. It returns the results set.
		SelectResults results = null;
		try {
			results = (SelectResults) query.execute(params);
		} catch (FunctionDomainException | TypeMismatchException | NameResolutionException
				| QueryInvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		Stock stockObj =  null;
	    Object obj  = results.iterator().next().toString();
		
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
		 
		 region.put(i+++"",stock+"") ;
		System.out.println(region.toString());
		//stockRepository.save(stock);
		return stock;

	}
	
	public static void main(String[] args) {
		ReceivingServiceImpl impl = new ReceivingServiceImpl();
		impl.addStock(new Stock("123", "Factoria T Mobile Retail Store", "TPR", true, true));
		impl.addStock(new Stock("456", "Bothell T Mobile Retail Store", "TPR", true, true));
		
		System.out.println(impl.getStoreDetails("123"));
		
		System.out.println(impl.getStores());
		
		
	}

}
