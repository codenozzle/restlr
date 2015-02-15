package com.codenozzle.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

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
    
    @PUT
    @Path("{id: \\d+}")
    public Product update(
    	@PathParam("id") Integer id,
    	Product updates, 
    	@Context HttpServletResponse servletResponse) throws IOException {

    	Product resource = getStorage().get(id);
    	if (resource != null) {
    		if (updates.getProductSku() != null) {
        		resource.setProductSku(updates.getProductSku());
        	}
        	if (updates.getProductName() != null) {
        		resource.setProductName(updates.getProductName());
        	}
        	if (updates.getDescription() != null) {
        		resource.setDescription(updates.getDescription());
        	}
        	if (updates.getPrice() != null) {
        		resource.setPrice(updates.getPrice());
        	}
        	if (updates.isActive() != null) {
        		resource.setActive(updates.isActive());
        	}
    	}
    	
    	return storeAndReturn(resource);
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

