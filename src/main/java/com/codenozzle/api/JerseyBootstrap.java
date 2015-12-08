package com.codenozzle.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.codenozzle.core.JacksonContextResolver;
import com.codenozzle.core.PrettyFilter;
import com.codenozzle.core.Randomizer;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * @author the_rob
 *
 */
@ApplicationPath("/")
public class JerseyBootstrap extends ResourceConfig {
    public JerseyBootstrap() {
    	super(
                //EmptyArrayResource.class,
                //NonJaxbBeanResource.class,
                //CombinedAnnotationResource.class,
                // register Jackson ObjectMapper resolver
    			JacksonContextResolver.class,
                JacksonFeatures.class
        );
        //register(MultiPartFeature.class);
        //register(JacksonContextResolver.class);
        //register(PrettyFilter.class);
        //register(JacksonFeatures.class);
        //register(JacksonJsonProvider.class);
        //register(new JacksonJsonProvider(myObjectMapper));
        //register(JacksonJaxbJsonProvider.class);
        property(ServerProperties.TRACING, "ALL");
        //property(ServerProperties.TRACING_THRESHOLD, "SUMMARY");
        //property(ServerProperties.PROVIDER_PACKAGES, "VERBOSE");
        Randomizer.loadSampleData();
    }
}
