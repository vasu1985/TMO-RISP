package com.tmobile.retailinventoryserialization.query.device;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.gemstone.gemfire.cache.GemFireCache;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.tmobile.retailinventoryserialization.query.device.domain.shared.Device;


@Configuration
@EnableGemfireRepositories
public class GeodeConfig {

	@Resource
	GemFireCache gemfireCache;
	
	@Bean
	ClientCacheFactoryBean clientCache() throws Exception {
		ClientCacheFactoryBean clientCacheFactory = new ClientCacheFactoryBean();
        clientCacheFactory.setCacheXml(new ClassPathResource("client-cache.xml"));
        clientCacheFactory.afterPropertiesSet();
        return clientCacheFactory;
	}

	@Bean
	ClientRegionFactoryBean<String, Device> region(ClientCache cache)  throws Exception{
		ClientRegionFactoryBean<String, Device> clientRegionFactory = new ClientRegionFactoryBean<>();
		clientRegionFactory.setCache (cache);
        clientRegionFactory.setRegionName("queryDevice");
        clientRegionFactory.afterPropertiesSet();
		return clientRegionFactory;
	}
}