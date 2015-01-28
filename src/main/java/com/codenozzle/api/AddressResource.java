package com.codenozzle.api;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.codenozzle.db.AddressStorage;
import com.codenozzle.db.AppStorage;
import com.codenozzle.model.Address;

public class AddressResource extends EntityResource<Address> {

	@Override
	public AddressStorage getStorage() {
		return AppStorage.ADDRESS;
	}
	
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(
    	@FormParam("address1") String address1,
        @FormParam("address2") String address2,
        @FormParam("city") String city,
        @FormParam("state") String state,
        @FormParam("zip") String zip,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	getStorage().store(new Address(address1, address2, city, state, zip));
    	servletResponse.sendRedirect("../../address.jsp");
    }
    
}
