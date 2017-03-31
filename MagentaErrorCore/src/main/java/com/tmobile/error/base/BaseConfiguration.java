/*
 * BaseConfiguration
 */
package com.tmobile.error.base;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.gemstone.gemfire.cache.GemFireCache;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.tmobile.error.base.domain.shared.ErrorMessage;

/**
 * <p>
 * This class provides all the configurations to this project.
 * </p>
 * .
 *
 * @author vm00436370
 * @project ErrorCore
 * @updated DateTime: Mar 22, 2017 8:20:13 PM Author: vm00436370
 */
@Configuration
@ComponentScan(basePackages = {"com.tmobile.error.base"})
@EnableGemfireRepositories("com.tmobile.error.base.repository")
public class BaseConfiguration {

	/**
	 * Message source.
	 *
	 * @return the reloadable resource bundle message source
	 */
	@Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
      ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
      messageBundle.setBasename("classpath:message");
      messageBundle.setDefaultEncoding("UTF-8");
      return messageBundle;
    }
	
}