package br.com.bjbraz.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bjbraz.pojo.MapJson;

@Path("/map")
public class MapResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getClichedMessage() {
        return new MapJson().toString();
    }

    @POST
    @Consumes("text/plain")
    public void postClichedMessage(String message) {
    }
    
}