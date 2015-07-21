package com.codenozzle.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.codenozzle.core.Randomizer;

@ApplicationPath("/")
public class App extends ResourceConfig {
    public App() {
        // Register resources and providers using package-scanning
        packages("com.codenozzle.api");
        
        // Turn on logging
        register(LoggingFilter.class);
        
        // Turn on multipart file support
        register(MultiPartFeature.class);
        
        // Turn on Declarative Linking
        register(DeclarativeLinkingFeature.class);
        
        // Trace everything
        property(ServerProperties.TRACING, "ALL");
        
        // Load randomly generated sample data
        Randomizer.loadSampleData();
    }
}
