package br.com.bjbraz.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/u/{name1}/{name2}/")
public class SameResource {
	
	@GET
    @Produces("text/xml")
    public String getUser(@PathParam("username") String userName) {
        return "ola";
    }

}