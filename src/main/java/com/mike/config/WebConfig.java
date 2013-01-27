package com.mike.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides java-based web configurations to the project
 *
 * User: mike
 * Date: 1/2/13
 * Time: 2:31 PM
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.mike.controller", "com.mike.service", "com.mike.dao"})
@ImportResource(value = "classpath:spring-security.xml")
public class WebConfig extends WebMvcConfigurerAdapter
{
    @Bean
    public TilesViewResolver configureTilesViewResolver()
    {
        return new TilesViewResolver();
    }

    @Bean
    public TilesConfigurer configureTilesConfigurer()
    {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/layouts/layouts.xml", "/WEB-INF/views/**/views.xml"});

        return tilesConfigurer;
    }

    /**
     * Use a UrlFilenameViewController to map a simple login url to the appropriate view
     *
     * @return an instance of a configured SimpleUrlHandlerMapping
     */
    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping()
    {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();

        UrlFilenameViewController urlFilenameViewController = new UrlFilenameViewController();

        Map<String, Controller> maps = new HashMap<String, Controller>();
        maps.put("/login", urlFilenameViewController);

        mapping.setUrlMap(maps);

        return mapping;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
