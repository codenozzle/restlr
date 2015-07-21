package com.codenozzle.api.resetappdata;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codenozzle.core.Randomizer;

@Path("resetappdata")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ResetAppDataResource {
	
	@GET
    public Response resetAppData(@Context HttpServletResponse servletResponse) {
		Randomizer.reloadSampleData();
        return Response.ok().build();
    }
	
}
