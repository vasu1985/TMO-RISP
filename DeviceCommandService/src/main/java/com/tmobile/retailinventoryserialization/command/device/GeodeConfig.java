
package com.tmobile.retailinventoryserialization.command.device;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.gemstone.gemfire.cache.GemFireCache;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.tmobile.error.base.BaseConfiguration;
import com.tmobile.error.base.domain.shared.ErrorMessage;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.Device;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.Transaction;

@Configuration
@EnableGemfireRepositories
@Import({BaseConfiguration.class})
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
    ClientRegionFactoryBean<String, Device> region( ClientCache cache) throws Exception {
        ClientRegionFactoryBean<String, Device> clientRegionFactory = new ClientRegionFactoryBean<>();
        clientRegionFactory.setCache(cache);
        clientRegionFactory.setRegionName("devices");
        clientRegionFactory.afterPropertiesSet();
        return clientRegionFactory;
    }

    @Bean
    ClientRegionFactoryBean<String, Transaction> region_1( ClientCache cache) throws Exception {
        ClientRegionFactoryBean<String, Transaction> clientRegionFactory = new ClientRegionFactoryBean<>();
        clientRegionFactory.setCache(cache);
        clientRegionFactory.setRegionName("transactions");
        clientRegionFactory.afterPropertiesSet();
        return clientRegionFactory;
    }
    
    @Bean
    ClientRegionFactoryBean<String, ErrorMessage> error_region(ClientCache cache) throws Exception {
        ClientRegionFactoryBean<String, ErrorMessage> clientRegionFactory = new ClientRegionFactoryBean<>();
        clientRegionFactory.setCache(cache);
        clientRegionFactory.setRegionName("errorRegion");
        clientRegionFactory.afterPropertiesSet();
        
        return clientRegionFactory;
    }
    
   
}