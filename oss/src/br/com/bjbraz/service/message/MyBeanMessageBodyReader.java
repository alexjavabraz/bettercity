package br.com.bjbraz.service.message;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import br.com.bjbraz.pojo.Estabelecimento;

public class MyBeanMessageBodyReader implements MessageBodyReader<Estabelecimento> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == Estabelecimento.class;
    }

    @Override
    public Estabelecimento readFrom(Class<Estabelecimento> type, Type genericType, Annotation[] annotations, MediaType mediaType,
        MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException,
        WebApplicationException {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Estabelecimento.class);
            Estabelecimento myBean = (Estabelecimento) jaxbContext.createUnmarshaller().unmarshal(entityStream);
            return myBean;
        }
        catch (JAXBException jaxbException) {
            throw new ProcessingException("Error deserializing a MyBean.", jaxbException);
        }
    }
}
