/**
 * 
 */
package com.codenozzle.tests;

import java.math.BigDecimal;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import com.codenozzle.api.product.Product;
import com.codenozzle.api.product.ProductResource;
import com.codenozzle.core.Randomizer;

public class ProductTest extends JerseyTest {

    @Test
    public void testPost() throws Exception {
    	// Create variables
    	String productName = "Product name";
    	String productSku = "product sku";
    	String productDescription = "description";
    	BigDecimal productPrice = new BigDecimal("19.99");
    	Boolean isActive = Boolean.TRUE;
    	
    	// Load entity
    	Product product = new Product();
	        product.setProductName(productName);
	        product.setProductSku(productSku);
	        product.setDescription(productDescription);
	        product.setPrice(productPrice);
	        product.setActive(isActive);
	    
	    // POST the Product and get the Response
        Entity<Product> productEntity = Entity.entity(product, MediaType.APPLICATION_JSON);
        Response response = target("products").request().accept(MediaType.APPLICATION_JSON).post(productEntity);
        Product productResponse = response.readEntity(Product.class);
        
        // Perform assertions
        Assert.assertEquals(productName, productResponse.getProductName());
        Assert.assertEquals(productSku, productResponse.getProductSku());
        Assert.assertEquals(productDescription, productResponse.getDescription());
        Assert.assertEquals(productPrice, productResponse.getPrice());
        Assert.assertEquals(isActive, productResponse.isActive());
    }
	/*@Test
    public void test_query() throws Exception {
        String actual = target("echo")
                .queryParam("text", "x")
                .request()
                .get(String.class);

        assertThat(actual, is("x"));
    }*/

    private Matcher is(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Test
    public void test_form() throws Exception {
        Form form = new Form().param("text", "y");

        Entity<Form> entity = Entity.form(form);

        String actual = target("echo")
                .request()
                .post(entity, String.class);

        assertThat(actual, is("y"));
    }*/

    /*@Test
    public void test_plain_text_entity() throws Exception {
        Entity<String> entity = Entity.text("z");

        String actual = target("echo")
                .request()
                .put(entity, String.class);

        assertThat(actual, is("z"));
    }*/

    /*@Test
    public void test_async() throws Exception {
        Entity<String> entity = Entity.text("a");

        Future<String> future = target("echo")
                .request()
                .async()
                .put(entity, String.class);

        assertThat(future.get(), is("a"));
    }*/

    @Override
    protected Application configure() {
        set(TestProperties.LOG_TRAFFIC, true);
        set(TestProperties.DUMP_ENTITY, true);
        return new ResourceConfig(ProductResource.class);
    }
    
    @Override
    protected void configureClient(ClientConfig config) {
    	// Register resources and providers using package-scanning
    	//packages("com.codenozzle.api");
        
        // Turn on logging
        config.register(LoggingFilter.class);
        
        // Turn on multipart file support
        config.register(MultiPartFeature.class);
        
        // Turn on Declarative Linking
        config.register(DeclarativeLinkingFeature.class);
        //packages("com.fasterxml.jackson.jaxrs.json");
        
        // Trace everything
        config.property(ServerProperties.TRACING, "ALL");
        
        // Load randomly generated sample data
        Randomizer.loadSampleData();
    }
}
