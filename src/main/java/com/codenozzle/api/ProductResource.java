package com.codenozzle.api;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codenozzle.db.AppStorage;
import com.codenozzle.db.ProductStorage;
import com.codenozzle.model.Product;

@Path("product")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ProductResource extends EntityResource<Product> {
    
	@Override
	public ProductStorage getStorage() {
		return AppStorage.PRODUCT;
	}
	
    @POST
    public Response create(
    	@FormParam("productSku") String productSku,
        @FormParam("productName") String productName,
        @FormParam("description") String description,
        @FormParam("price") BigDecimal price,
        @FormParam("active") boolean active,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	//return storeAndReturn(servletResponse, new Product(productSku, productName, description, price, active));
    	
    	getStorage().store(new Product(productSku, productName, description, price, active));
    	//servletResponse.sendRedirect("../../order.jsp");
    	//return Response.ok("schweet!", MediaType.APPLICATION_JSON_TYPE).build();
    	return Response.ok().build();
    	//return Response.status(200).entity("sucessfully added").build();
    }
    
}
