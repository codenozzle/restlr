package com.codenozzle.api;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.codenozzle.db.AppStorage;
import com.codenozzle.db.OrderStorage;
import com.codenozzle.model.Order;

@Path("order")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class OrderResource extends EntityResource<Order> {
    
	@Override
	public OrderStorage getStorage() {
		return AppStorage.ORDER;
	}
    
    @PUT
    @Path("{id: \\d+}")
    public Order update(
    	@PathParam("id") Integer id,
    	Order updates, 
    	@Context HttpServletResponse servletResponse) throws IOException {
    	
    	Order resource = getStorage().get(id);
    	if (resource != null) {
    		if (updates.getUserId() != null) {
        		resource.setUserId(updates.getUserId());
        	}
        	if (updates.getShippingAddressId() != null) {
        		resource.setShippingAddressId(updates.getShippingAddressId());
        	}
        	if (updates.getBillingAddressId() != null) {
        		resource.setBillingAddressId(updates.getBillingAddressId());
        	}
    	}
    	
    	return storeAndReturn(resource);
    }
    
}
