package com.codenozzle.api;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.codenozzle.db.EntityStorage;
import com.codenozzle.model.Entity;

public abstract class EntityResource<T extends Entity> {

	@GET
    public Collection<T> getAll() {
        return getStorage().getAllAsList();
    }
	
	@GET
    @Path("{id: \\d+}")
    public T get(@PathParam("id") Integer id) {
        return getStorage().get(id);
    }

	@POST
    public T create(T entity /*, @Context HttpServletResponse servletResponse*/) throws IOException {
    	return storeAndReturn(entity);
    }
	
	@PUT
    @Path("{id: \\d+}")
    public T update(
    	@PathParam("id") Integer id,
    	T updates, 
    	@Context HttpServletResponse servletResponse) throws IOException {

    	return update(id, updates);
    }

	@DELETE
    @Path("{id: \\d+}")
    public T remove(@PathParam("id") Integer id) {
        return getStorage().remove(id);
    }

    @DELETE
    public Response removeAll() {
    	getStorage().removeAll();
    	return Response.ok().build();
    }
    
    @GET
    @Path("/count")
    public Integer count() {
        return getStorage().size();
    }

	protected abstract EntityStorage<T> getStorage();
	
	protected T storeAndReturn(T entity /*, HttpServletResponse servletResponse*/) throws IOException {
		return getStorage().store(entity);
	}
	
	protected T update(Integer id, T updates) {
		return getStorage().update(id, updates);
	}
	
	protected boolean paramCompare(Object object1, Object object2) {
		if (object1 == null || object2 == null) {
			return false;
		}
		return object1.equals(object2);
	}

}
