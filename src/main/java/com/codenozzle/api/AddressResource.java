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
import javax.ws.rs.core.Response;

import com.codenozzle.db.AddressStorage;
import com.codenozzle.db.AppStorage;
import com.codenozzle.model.Address;

@Path("address")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AddressResource extends EntityResource<Address> {

	@Override
	public AddressStorage getStorage() {
		return AppStorage.ADDRESS;
	}
	
    @POST
    public Response create(
    	@FormParam("address1") String address1,
        @FormParam("address2") String address2,
        @FormParam("city") String city,
        @FormParam("state") String state,
        @FormParam("zip") String zip,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	getStorage().store(new Address(address1, address2, city, state, zip));
    	return Response.ok().build();
    }
    
}
