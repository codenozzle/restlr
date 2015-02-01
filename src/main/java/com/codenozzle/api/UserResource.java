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
import com.codenozzle.db.UserStorage;
import com.codenozzle.model.User;

@Path("user")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UserResource extends EntityResource<User> {
	
	@Override
	public UserStorage getStorage() {
		return AppStorage.USER;
	}
    
    @POST
    public Response create(
    	@FormParam("firstName") String firstName,
        @FormParam("lastName") String lastName,
        @FormParam("emailAddress") String emailAddress,
        @FormParam("active") Boolean active,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	getStorage().store(new User(firstName, lastName, emailAddress, active));
    	return Response.ok().build();
    }
    
    @PUT
    @Path("{id: \\d+}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response update(
    	@PathParam("id") final int id,
    	@FormParam("firstName") String firstName,
        @FormParam("lastName") String lastName,
        @FormParam("emailAddress") String emailAddress,
        @FormParam("active") Boolean active,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	User resource = getStorage().get(id);
    	if (resource != null) {
    		if (firstName != null) {
        		resource.setFirstName(firstName);
        	}
        	if (lastName != null) {
        		resource.setLastName(lastName);
        	}
        	if (emailAddress != null) {
        		resource.setEmailAddress(emailAddress);
        	}
        	if (active != null) {
        		resource.setActive(active);
        	}
        	getStorage().store(resource);
    	}
    	
    	return Response.ok().build();
    }
    
}
