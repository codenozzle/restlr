package com.codenozzle.api.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import com.codenozzle.core.AppStorage;
import com.codenozzle.core.EntityResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.PATCH;

@Path("products")
@Api(value = "products", tags = {"Products"})
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ProductResource extends EntityResource<Product> {

	// Route descriptions
	private static final String GET_ALL_DESC = "Returns all products";
	private static final String GET_BY_ID_DESC = "Returns a Product";
	private static final String POST_DESC = "Creates a Product";
	private static final String PUT_DESC = "Overwrites a Product";
	private static final String PATCH_DESC = "Updates a Product";
	private static final String DELETE_DESC = "Deletes a Product";
	private static final String DELETE_ALL_DESC = "Deletes all Products";
	private static final String SEARCH_DESC = "Searches for Products";
	
	// Parameter descriptions
	private static final String PRODUCT_ID_PARAM = "Product ID";
	private static final String PRODUCT_PARAM = "Product Entity";
	private static final String PRODUCT_SKU = "Product Sku";
	private static final String PRODUCT_NAME = "Product Name";
	private static final String PRODUCT_DESC = "Product Description";
	private static final String PRODUCT_PRICE = "Product Price";
	private static final String PRODUCT_ACTIVE = "Product Active";
    
	@GET
	@ApiOperation(httpMethod = HTTP_GET, value = GET_ALL_DESC, response = Product.class)
    public Collection<Product> getAll() {
        return getStorage().getAllAsList();
    }
	
	@GET
    @Path("{id: \\d+}")
	@ApiOperation(httpMethod = HTTP_GET, value = GET_BY_ID_DESC, response = Product.class)
    public Product get(@ApiParam(value = PRODUCT_ID_PARAM, required = true) @PathParam("id") Integer id) {
        return getStorage().get(id);
    }

	@POST
	@ApiOperation(httpMethod = HTTP_POST, value = POST_DESC, response = Product.class)
    public Product post(Product entity) throws IOException {
    	return storeAndReturn(entity);
    }
	
	@PUT
    @Path("{id: \\d+}")
	@ApiOperation(httpMethod = HTTP_PUT, value = PUT_DESC, response = Product.class)
    public Product put(
    	@ApiParam(value = PRODUCT_ID_PARAM, required = true) @PathParam("id") Integer id,
    	@ApiParam(value = PRODUCT_PARAM, required = true) Product updates, 
    	@Context HttpServletResponse servletResponse) throws IOException {

    	return update(id, updates);
    }
	
	@PATCH
    @Path("{id: \\d+}")
	@ApiOperation(httpMethod = HTTP_PATCH, value = PATCH_DESC, response = Product.class)
    public Product patch(
    	@ApiParam(value = PRODUCT_ID_PARAM, required = true) @PathParam("id") Integer id,
    	@ApiParam(value = PRODUCT_PARAM, required = true) Product updates, 
    	@Context HttpServletResponse servletResponse) throws IOException {

    	return update(id, updates);
    }

	@DELETE
    @Path("{id: \\d+}")
	@ApiOperation(httpMethod = HTTP_DELETE, value = DELETE_DESC, response = Product.class)
    public Product remove(@ApiParam(value = PRODUCT_ID_PARAM, required = true) @PathParam("id") Integer id) {
        return getStorage().remove(id);
    }

    @DELETE
    @ApiOperation(httpMethod = HTTP_DELETE, value = DELETE_ALL_DESC, response = Product.class)
    public Response removeAll() {
    	getStorage().removeAll();
    	return Response.ok().build();
    }
    
    @GET
    @Path("/search")
    @ApiOperation(httpMethod = HTTP_GET, value = SEARCH_DESC, response = Product.class)
    public Collection<Product> search(
    	@ApiParam(value = PRODUCT_ID_PARAM) @QueryParam("id") Integer id,
    	@ApiParam(value = PRODUCT_SKU) @QueryParam("productSku") String productSku,
    	@ApiParam(value = PRODUCT_NAME) @QueryParam("productName") String productName,
    	@ApiParam(value = PRODUCT_DESC) @QueryParam("description") String description,
    	@ApiParam(value = PRODUCT_PRICE) @QueryParam("price") BigDecimal price,
    	@ApiParam(value = PRODUCT_ACTIVE) @QueryParam("active") Boolean active,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	Predicate<Product> filters = new Predicate<Product>() {
    	    public boolean apply(Product product) {
    	    	if (paramCompare(id, product.getId())) {
            		return true;
            	}
    	    	if (paramCompare(productSku, product.getProductSku())) {
            		return true;
            	}
            	if (paramCompare(productName, product.getProductName())) {
            		return true;
            	}
            	if (paramCompare(description, product.getDescription())) {
            		return true;
            	}
            	if (paramCompare(price, product.getPrice())) {
            		return true;
            	}
            	if (paramCompare(active, product.isActive())) {
            		return true;
            	}
    	        return false;
    	    }
    	};
    	
    	return Maps.filterValues(getStorage().getAll(), filters).values();
    }
    
    @Override
	public ProductStorage getStorage() {
		return AppStorage.PRODUCT;
	}
    
}

