package com.mike.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

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

        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet",
                new DispatcherServlet(context));

        appServlet.setLoadOnStartup(1);
        Set<String> conflicts = appServlet.addMapping("/");

        if (!conflicts.isEmpty())
        {
            System.out.println("woops, conflicts!!!!!!!!");
        }
        else
        {
            System.out.println("No conflicts");
        }

    }
}
