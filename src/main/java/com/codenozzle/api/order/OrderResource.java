package com.codenozzle.api.order;

import java.math.BigDecimal;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codenozzle.api.address.Address;
import com.codenozzle.core.AppStorage;
import com.codenozzle.core.EntityResource;

@Path("/order")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class OrderResource extends EntityResource<Order> {
    
	@Override
	public OrderStorage getStorage() {
		return AppStorage.ORDER;
	}
	
	@GET
    @Path("{id: \\d+}/billingaddress")
    public Address getBillingAddress(@PathParam("id") Integer id) {
        return getStorage().get(id).getBillingAddress();
    }
	
	@GET
    @Path("{id: \\d+}/shippingaddress")
    public Address getShippingAddress(@PathParam("id") Integer id) {
        return getStorage().get(id).getShippingAddress();
    }
	
	@GET
    @Path("{id: \\d+}/lineitems")
    public Collection<OrderLineItem> getLineItems(@PathParam("id") Integer id) {
        return getStorage().get(id).getLineItems();
    }
	
	@GET
    @Path("{id: \\d+}/lineitems/count")
    public int getLineItemCount(@PathParam("id") Integer id) {
        return getStorage().get(id).getLineItems().size();
    }
	
	@GET
    @Path("{id: \\d+}/grandtotal")
    public BigDecimal getGrandTotal(@PathParam("id") Integer id) {
        return getStorage().get(id).getGrandTotal();
    }
	
	@GET
    @Path("{id: \\d+}/status")
    public OrderStatus getOrderStatus(@PathParam("id") Integer id) {
        return getStorage().get(id).getOrderStatus();
    }
    
}
