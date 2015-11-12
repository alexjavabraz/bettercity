package br.com.bjbraz.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/map")
public class MapResource {

	@GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
	@Produces(MediaType.TEXT_PLAIN)
    public String getClichedMessage() {
        return  new MapJson().toString();
    }
	
	@POST
	@Consumes("text/plain")
	public void postClichedMessage(String message) {
	    // Store the message
	}
	
}
