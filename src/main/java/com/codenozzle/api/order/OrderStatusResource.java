package com.codenozzle.api.order;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/orderstatus")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class OrderStatusResource {
	
	@GET
    public List<OrderStatus> getAll() {
        return OrderStatus.getAll();
    }
	
	@GET
    @Path("{id: \\d+}")
    public OrderStatus get(@PathParam("id") Integer id) {
        return OrderStatus.get(id);
    }
	
	@GET
    @Path("/count")
    public Integer count() {
        return OrderStatus.size();
    }
}
