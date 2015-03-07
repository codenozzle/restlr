package com.codenozzle.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/")
public class RestApp extends ResourceConfig {
    public RestApp() {
        // Register resources and providers using package-scanning
        packages("com.codenozzle.api");
        
        // Turn on logging
        register(LoggingFilter.class);
        
        // Turn on multipart file support
        register(MultiPartFeature.class);
        
        // Trace everything
        property(ServerProperties.TRACING, "ALL");
        
        // Load randomly generated sample data
        Randomizer.loadSampleData();
    }
}
