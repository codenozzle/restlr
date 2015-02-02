package com.codenozzle.api;

import java.io.IOException;

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
	
    @POST
    public Response create(
    	@FormParam("userId") Integer userId,
        @FormParam("shippingAddressId") Integer shippingAddressId,
        @FormParam("billingAddressId") Integer billingAddressId,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	getStorage().store(new Order(userId, shippingAddressId, billingAddressId));
    	return Response.ok().build();
    }
    
    @PUT
    @Path("{id: \\d+}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response update(
    	@PathParam("id") Integer id,
    	@FormParam("userId") Integer userId,
        @FormParam("shippingAddressId") Integer shippingAddressId,
        @FormParam("billingAddressId") Integer billingAddressId,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	Order resource = getStorage().get(id);
    	if (resource != null) {
    		if (userId != null) {
        		resource.setUserId(userId);
        	}
        	if (shippingAddressId != null) {
        		resource.setShippingAddressId(shippingAddressId);
        	}
        	if (billingAddressId != null) {
        		resource.setBillingAddressId(billingAddressId);
        	}
        	getStorage().store(resource);
    	}
    	
    	return Response.ok().build();
    }
    
}
