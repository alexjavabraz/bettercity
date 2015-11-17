package br.com.bjbraz.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.bjbraz.entity.Demanda;


@Path("/demanda/ins")
public class DemandaResource {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insert(
    		@QueryParam("titulo") String titulo, 
    		@QueryParam("descricao") String descricao,
    		@QueryParam("endereco") String endereco, 
    		@QueryParam("latitude") String latitude, 
    		@QueryParam("longitude") String longitude) {
		
		Demanda d = new Demanda();
		d.setDescricao(descricao);
		d.setTitulo(titulo);
		d.setEndereco(endereco);
		d.setLatitude(latitude);
		d.setLongitude(longitude);
		
        return "ola";
    }

}