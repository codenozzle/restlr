package com.codenozzle.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.codenozzle.db.AppStorage;
import com.codenozzle.db.FileDataStorage;
import com.codenozzle.model.FileData;

@Path("/image")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class ImageResource {
    
	@Context
    UriInfo uriInfo;
	
	public FileDataStorage getStorage() {
		return AppStorage.IMAGES;
	}
	
	@GET
    public Collection<FileData> getAll() {
        return getStorage().getAllAsList();
    }
	
	@GET
    @Path("{id: \\d+}")
    public FileData get(@PathParam("id") Integer id) {
        return getStorage().get(id);
    }
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public FileData create(
		@FormDataParam("file") InputStream fileInputStream,
		@FormDataParam("file") FormDataContentDisposition contentDispositionHeader) {
		
		FileData entity = null;
		try {
			byte[] fileInBytes = IOUtils.toByteArray(fileInputStream);
			entity = new FileData();
			entity.setName(contentDispositionHeader.getFileName());
			entity.setType(getFileType(contentDispositionHeader.getFileName()));
			entity.setByteArray(fileInBytes);
			entity.setSize(Long.valueOf(fileInBytes.length));
			getStorage().store(entity);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return entity;
	}
	
	@DELETE
    @Path("{id: \\d+}")
    public FileData remove(@PathParam("id") Integer id) {
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
	
	@GET
	@Path("{id: \\d+}/download")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadImage(@PathParam("id") Integer id) {
		return getFileData(id);
	}

	@GET
	@Path("{id: \\d+}/view")
	@Produces("image/*")
	public Response viewImage(@PathParam("id") Integer id) {
		return getFileData(id);
	}
	
	private Response getFileData(Integer id) {
		if (!getStorage().exists(id)) {
			throw new WebApplicationException(404);
		}
		
		FileData fileData = getStorage().get(id);

		return Response
            .ok(fileData.getByteArray())
            .header("Content-Disposition","filename = " + fileData.getName())
            .build();
	}
	
	private String getFileType(String fileName) {
		return fileName.substring(fileName.indexOf(".")+1);
	}

}
