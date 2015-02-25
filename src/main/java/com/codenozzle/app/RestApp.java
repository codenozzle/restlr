package com.codenozzle.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/")
public class RestApp extends ResourceConfig {
    public RestApp() {
        // Register resources and providers using package-scanning
        packages("com.codenozzle.api");
        register(LoggingFilter.class);
        property(ServerProperties.TRACING, "ALL");
        //register(IntegerMessageBodyWriter.class);
        Randomizer.loadSampleData();
    }
}
