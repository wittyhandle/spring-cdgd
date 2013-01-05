package com.mike.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Contains the configurations for properties files
 *
 * User: mike
 * Date: 1/5/13
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class PropertiesConfig
{

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer()
    {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("/persistence.properties"));
        return ppc;
    }

}
