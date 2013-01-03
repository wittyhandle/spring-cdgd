package com.mike.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 1/2/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.mike.controller")
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


}
