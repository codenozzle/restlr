package com.codenozzle.messagewriter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class IntegerMessageBodyWriter implements MessageBodyWriter<Integer> {
 
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == Integer.class;
    }

	@Override
	public long getSize(Integer t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return 0;
	}

	@Override
	public void writeTo(Integer t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {
		
		try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Integer.class);
            jaxbContext.createMarshaller().marshal(t, entityStream);
        } catch (JAXBException jaxbException) {
            throw new ProcessingException("Error serializing a Integer to the output stream", jaxbException);
        }
	}
}
