package com.codenozzle.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.codenozzle.core.Randomizer;

/**
 * @author the_rob
 *
 */
@ApplicationPath("/")
public class JerseyBootstrap extends ResourceConfig {
    public JerseyBootstrap() {
    	// Register resources and providers using package-scanning
    	packages("com.codenozzle.api");
        
        // Turn on logging
        register(LoggingFilter.class);
        
        // Turn on multipart file support
        register(MultiPartFeature.class);
        
        // Turn on Declarative Linking
        register(DeclarativeLinkingFeature.class);
        packages("com.fasterxml.jackson.jaxrs.json");
        
        // Trace everything
        property(ServerProperties.TRACING, "ALL");
        
        // Load randomly generated sample data
        Randomizer.loadSampleData();
        
        //register(MultiPartFeature.class);
        //register(JacksonContextResolver.class);
        //register(PrettyFilter.class);
        //register(JacksonFeatures.class);
        //register(JacksonJsonProvider.class);
        //register(new JacksonJsonProvider(myObjectMapper));
        //register(JacksonJaxbJsonProvider.class);
    }
}
