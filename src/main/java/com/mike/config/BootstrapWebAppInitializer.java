package com.mike.config;

import com.tacitknowledge.util.migration.jdbc.WebAppMigrationLauncher;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 1/2/13
 * Time: 6:08 PM
 *
 * This is where the magic starts.
 *
 */
public class BootstrapWebAppInitializer implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        // A web context implementation that gets its configurations through annotations
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("com.mike.config");

        FilterRegistration.Dynamic securityFilter = servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"));
        securityFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        servletContext.addListener(new ContextLoaderListener(context));

        servletContext.setInitParameter("migration.systemname", "carl");
        servletContext.addListener(new WebAppMigrationLauncher());

        ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet",
                new DispatcherServlet(context));

        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}
