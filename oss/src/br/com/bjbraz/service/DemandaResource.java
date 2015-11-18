package br.com.bjbraz.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bjbraz.entity.Demanda;
import br.com.bjbraz.entity.HSQLDao;


@Path("/demanda/ins")
public class DemandaResource {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insert(
    		@FormParam("titulo") String titulo, 
    		@FormParam("descricao") String descricao,
    		@FormParam("endereco") String endereco, 
    		@FormParam("latitude") String latitude, 
    		@FormParam("longitude") String longitude) {
		
		Demanda d = new Demanda();
		d.setDescricao(descricao);
		d.setTitulo(titulo);
		d.setEndereco(endereco);
		d.setLatitude(latitude);
		d.setLongitude(longitude);
		
		HSQLDao dao = new HSQLDao();
		
		
		dao.adicionaDemanda(d);
		
        return "ok";
    }

}