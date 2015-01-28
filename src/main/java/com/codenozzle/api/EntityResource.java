package com.codenozzle.api;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codenozzle.db.EntityStorage;
import com.codenozzle.model.Entity;

//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public abstract class EntityResource<T extends Entity> {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<T> getAll() {
        return getStorage().getAllAsList();
    }
	
	@GET
    @Path("{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public T get(@PathParam("id") final int id) {
        return getStorage().get(id);
    }

    @DELETE
    @Path("{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public T remove(@PathParam("id") final int id) {
        return getStorage().remove(id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public int removeAll() {
    	return getStorage().removeAll();
    }
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public Collection<T> getXml() {
		return getStorage().getAllAsList();
	}
	
	@GET
    @Path("/xml/{id: \\d+}")
    @Produces(MediaType.APPLICATION_XML)
    public T getXmlById(@PathParam("id") final int id) {
        return getStorage().get(id);
    }
	
	@GET
	@Path("/text")
	@Produces(MediaType.TEXT_PLAIN)
	public Collection<T> getXml2() {
		return getStorage().getAllAsList();
	}
	
	@GET
    @Path("/text/{id: \\d+}")
    @Produces(MediaType.TEXT_PLAIN)
    public T getXmlById2(@PathParam("id") final int id) {
        return getStorage().get(id);
    }

	protected abstract EntityStorage<T> getStorage();
	
	protected Response storeAndReturn(HttpServletResponse servletResponse, T entity) throws IOException {
		return Response.ok(getStorage().store(entity)).build();
	}

}
