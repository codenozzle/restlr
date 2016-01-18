package com.codenozzle.core;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.ApiOperation;

public abstract class EntityResource<T extends Entity> {

	// HTTP Status Codes
	protected static final String HTTP_GET = "GET";
	protected static final String HTTP_POST = "POST";
	protected static final String HTTP_PUT = "PUT";
	protected static final String HTTP_PATCH = "PATCH";
	protected static final String HTTP_DELETE = "DELETE";
	
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
