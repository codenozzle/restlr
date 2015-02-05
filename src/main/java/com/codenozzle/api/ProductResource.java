package com.codenozzle.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jersey.repackaged.com.google.common.base.Predicate;
import jersey.repackaged.com.google.common.collect.Maps;

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
    	
    	return Response.ok().build();
    }
    
    @PUT
    @Path("{id: \\d+}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response update(
    	@PathParam("id") Integer id,
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
    
    @GET
    @Path("/search")
    public Collection<Product> search(
    	@QueryParam("id") Integer id,
    	@QueryParam("productSku") String productSku,
    	@QueryParam("productName") String productName,
    	@QueryParam("description") String description,
    	@QueryParam("price") BigDecimal price,
    	@QueryParam("active") Boolean active,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	Predicate<Product> filters = new Predicate<Product>() {
    	    public boolean apply(Product product) {
    	    	if (paramCompare(id, product.getId())) {
            		return true;
            	}
    	    	if (paramCompare(productSku, product.getProductSku())) {
            		return true;
            	}
            	if (paramCompare(productName, product.getProductName())) {
            		return true;
            	}
            	if (paramCompare(description, product.getDescription())) {
            		return true;
            	}
            	if (paramCompare(price, product.getPrice())) {
            		return true;
            	}
            	if (paramCompare(active, product.isActive())) {
            		return true;
            	}
    	        return false;
    	    }
    	};
    	
    	return Maps.filterValues(getStorage().getAll(), filters).values();
    }
    
}

