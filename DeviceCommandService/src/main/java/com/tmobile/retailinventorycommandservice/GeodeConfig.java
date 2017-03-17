
package com.tmobile.retailinventorycommandservice;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.gemstone.gemfire.cache.GemFireCache;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.tmobile.retailinventorycommandservice.domain.Device;

/**
 * The Class GeodeConfig.
 */
@Configuration
@EnableGemfireRepositories
public class GeodeConfig {

    /** The gemfire cache. */
    @Resource
    GemFireCache gemfireCache;

    /**
     * Client cache.
     *
     * @return the client cache factory bean
     * @throws Exception
     *             the exception
     */
    @Bean
    ClientCacheFactoryBean clientCache() throws Exception {
        // setProxy();
        ClientCacheFactoryBean clientCacheFactory = new ClientCacheFactoryBean();
        clientCacheFactory.setCacheXml(new ClassPathResource("client-cache.xml"));
        clientCacheFactory.afterPropertiesSet();
        return clientCacheFactory;
    }

    /**
     * Region.
     *
     * @param cache
     *            the cache
     * @return the client region factory bean< string, device>
     * @throws Exception
     *             the exception
     */
    @Bean
    ClientRegionFactoryBean<String, Device> region( ClientCache cache) throws Exception {
        // setProxy();
        ClientRegionFactoryBean<String, Device> clientRegionFactory = new ClientRegionFactoryBean<>();
        clientRegionFactory.setCache(cache);
        clientRegionFactory.setRegionName("devices");
        clientRegionFactory.afterPropertiesSet();
        return clientRegionFactory;
    }

    /**
     * Sets the proxy.
     */
    /*
     * private void setProxy() { System.setProperty("http.proxyHost", "10.13.125.14"); System.setProperty("http.proxyPort", String.valueOf(8080));
     * System.setProperty("https.proxyHost", "10.13.125.14"); System.setProperty("https.proxyPort", String.valueOf(8080)); }
     */
}