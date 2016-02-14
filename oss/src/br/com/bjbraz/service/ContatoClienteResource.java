package br.com.bjbraz.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import br.com.bjbraz.entity.ContatoCliente;
import br.com.bjbraz.entity.HSQLDao;

@Path("/contato/ins")
public class ContatoClienteResource {
	
	@Context
	private HttpServletRequest request;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insert(
    		@FormParam("nome") String nome, 
    		@FormParam("email") String email,
    		@FormParam("descricao") String descricao, 
    		@FormParam("lat") String lat,
    		@FormParam("lon") String longi) {
		
		if((null != nome) && (null != descricao)){
			ContatoCliente c = new ContatoCliente();
			c.setEmail(email);
			c.setDescricao(descricao);
			c.setNome(nome);
			c.setLatitude(lat);
			c.setLongitude(longi);
					
			HSQLDao dao = new HSQLDao();
			dao.insereContatoDeCliente(c);
		}
		
        return "ok";
    }

}
