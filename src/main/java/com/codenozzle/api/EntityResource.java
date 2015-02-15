package com.codenozzle.api;

import java.io.IOException;
import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
	
    @DELETE
    @Path("{id: \\d+}")
    public T remove(@PathParam("id") Integer id) {
        return getStorage().remove(id);
    }

    @DELETE
    public Integer removeAll() {
    	return getStorage().removeAll();
    }

	protected abstract EntityStorage<T> getStorage();
	
	protected T storeAndReturn(T entity /*, HttpServletResponse servletResponse*/) throws IOException {
		return getStorage().store(entity);
	}
	
	protected boolean paramCompare(Object object1, Object object2) {
		if (object1 == null || object2 == null) {
			return false;
		}
		return object1.equals(object2);
	}

}
