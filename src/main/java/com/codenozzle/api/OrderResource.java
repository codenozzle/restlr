package com.codenozzle.api;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.codenozzle.db.AppStorage;
import com.codenozzle.db.OrderStorage;
import com.codenozzle.model.Order;

@Path("order")
public class OrderResource extends EntityResource<Order> {
    
	@Override
	public OrderStorage getStorage() {
		return AppStorage.ORDER;
	}
	
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(
    	@FormParam("userId") Integer userId,
        @FormParam("shippingAddressId") Integer shippingAddressId,
        @FormParam("billingAddressId") Integer billingAddressId,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	getStorage().store(new Order(userId, shippingAddressId, billingAddressId));
    	servletResponse.sendRedirect("../../order.jsp");
    }
    
}
