package com.codenozzle.api;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public T get(@PathParam("id") final int id) {
        return getStorage().get(id);
    }

    @DELETE
    @Path("{id: \\d+}")
    public T remove(@PathParam("id") final int id) {
        return getStorage().remove(id);
    }

    @DELETE
    public int removeAll() {
    	return getStorage().removeAll();
    }

	protected abstract EntityStorage<T> getStorage();
	
	protected Response storeAndReturn(HttpServletResponse servletResponse, T entity) throws IOException {
		return Response.ok(getStorage().store(entity)).build();
	}

}
