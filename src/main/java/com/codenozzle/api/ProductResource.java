package com.codenozzle.api;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codenozzle.db.AppStorage;
import com.codenozzle.db.ProductStorage;
import com.codenozzle.model.Product;

@Path("product")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ProductResource extends EntityResource<Product> {
    
	@Override
	public ProductStorage getStorage() {
		return AppStorage.PRODUCT;
	}
	
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response create(
    	@FormParam("productSku") String productSku,
        @FormParam("productName") String productName,
        @FormParam("description") String description,
        @FormParam("price") BigDecimal price,
        @FormParam("active") Boolean active,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	getStorage().store(new Product(productSku, productName, description, price, active));
    	//return Response.ok("schweet!", MediaType.APPLICATION_JSON_TYPE).build();
    	return Response.ok().build();
    }
    
    @PUT
    @Path("{id: \\d+}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response update(
    	@PathParam("id") final int id,
    	@FormParam("productSku") String productSku,
        @FormParam("productName") String productName,
        @FormParam("description") String description,
        @FormParam("price") BigDecimal price,
        @FormParam("active") Boolean active,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	Product resource = getStorage().get(id);
    	if (resource != null) {
    		if (productSku != null) {
        		resource.setProductSku(productSku);
        	}
        	if (productName != null) {
        		resource.setProductName(productName);
        	}
        	if (description != null) {
        		resource.setDescription(description);
        	}
        	if (price != null) {
        		resource.setPrice(price);
        	}
        	if (active != null) {
        		resource.setActive(active);
        	}
        	getStorage().store(resource);
    	}
    	
    	return Response.ok().build();
    }
    
}
