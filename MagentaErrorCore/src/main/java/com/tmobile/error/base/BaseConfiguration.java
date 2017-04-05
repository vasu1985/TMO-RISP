
package com.tmobile.error.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

/**
 * <p>
 * This class provides all the configurations to this project.
 * </p>
 * .
 *
 * @author vm00436370
 * @project magenta-error-core
 * @updated DateTime: Mar 22, 2017 8:20:13 PM Author: vm00436370
 */
@Configuration
@ComponentScan( basePackages = { "com.tmobile.error.base" })
@EnableGemfireRepositories( "com.tmobile.error.base.repository")
public class BaseConfiguration {

    /**
     * Message source.
     *
     * @return the reloadable resource bundle message source
     */
    @Bean( name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasename("classpath:message");
        messageBundle.setDefaultEncoding("UTF-8");
        return messageBundle;
    }

}