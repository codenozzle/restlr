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
import com.codenozzle.db.UserStorage;
import com.codenozzle.model.User;

@Path("user")
public class UserResource extends EntityResource<User> {
	
	@Override
	public UserStorage getStorage() {
		return AppStorage.USER;
	}
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(
    	@FormParam("firstName") String firstName,
        @FormParam("lastName") String lastName,
        @FormParam("emailAddress") String emailAddress,
        @FormParam("active") boolean active,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	getStorage().store(new User(firstName, lastName, emailAddress, active));
    	servletResponse.sendRedirect("../../users.jsp");
      
    }
    
}
