package br.com.bjbraz.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bjbraz.entity.HSQLDao;


@Path("/detalhe")
public class DetalheResource {
	
    @GET
	@Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(
    		@PathParam("id") String id) {
    	
    	 HSQLDao dao = new HSQLDao();
         
    	return dao.listarDemanda(id).toString();
    } 

}