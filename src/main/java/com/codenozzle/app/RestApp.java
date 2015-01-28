package com.codenozzle.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/")
public class RestApp extends ResourceConfig {

    public RestApp() {
        //packages("org.glassfish.jersey.examples.jsonp.resource");
        // Register resources and providers using package-scanning.
        packages("com.codenozzle.api");
 
        // Register my custom provider - not needed if it's in my.package.
        //register(SecurityRequestFilter.class);
        // Register an instance of LoggingFilter.
        //register(new LoggingFilter(LOGGER, true));
        register(LoggingFilter.class);
        // Enable Tracing support.
        property(ServerProperties.TRACING, "ALL");
        
        Randomizer randomizer = new Randomizer();
        randomizer.loadSampleData();
    }
}
