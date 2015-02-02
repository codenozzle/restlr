package com.codenozzle.api;

import java.io.IOException;
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
    
    @PUT
    @Path("{id: \\d+}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response update(
    	@PathParam("id") Integer id,
    	@FormParam("address1") String address1,
        @FormParam("address2") String address2,
        @FormParam("city") String city,
        @FormParam("state") String state,
        @FormParam("zip") String zip,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	Address resource = getStorage().get(id);
    	if (resource != null) {
    		if (address1 != null) {
        		resource.setAddress1(address1);
        	}
        	if (address2 != null) {
        		resource.setAddress2(address2);
        	}
        	if (city != null) {
        		resource.setCity(city);
        	}
        	if (state != null) {
        		resource.setState(state);
        	}
        	if (zip != null) {
        		resource.setZip(zip);
        	}
        	getStorage().store(resource);
    	}
    	
    	return Response.ok().build();
    }
    
    @GET
    @Path("/search")
    public Collection<Address> search(
		@QueryParam("id") Integer id,
		@QueryParam("address1") String address1,
		@QueryParam("address2") String address2,
		@QueryParam("city") String city,
		@QueryParam("state") String state,
		@QueryParam("zip") String zip,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	Predicate<Address> filters = new Predicate<Address>() {
    	    public boolean apply(Address address) {
    	    	if (paramCompare(id, address.getId())) {
            		return true;
            	}
    	    	if (paramCompare(address1, address.getAddress1())) {
            		return true;
            	}
            	if (paramCompare(address2, address.getAddress2())) {
            		return true;
            	}
            	if (paramCompare(city, address.getCity())) {
            		return true;
            	}
            	if (paramCompare(state, address.getState())) {
            		return true;
            	}
            	if (paramCompare(zip, address.getZip())) {
            		return true;
            	}
    	        return false;
    	    }
    	};
    	
    	return Maps.filterValues(getStorage().getAll(), filters).values();
    }
    
}
