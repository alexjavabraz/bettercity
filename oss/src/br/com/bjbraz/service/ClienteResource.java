package br.com.bjbraz.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bjbraz.entity.Cliente;
import br.com.bjbraz.entity.HSQLDao;

@Path("/cliente/ins")
public class ClienteResource {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insert(
    		@FormParam("nome") String nome, 
    		@FormParam("email") String email,
    		@FormParam("endereco") String endereco, 
    		@FormParam("telefone") String telefone,
    		@FormParam("senha") String senha) {
		
		Cliente c = new Cliente();
		c.setEmail(email);
		c.setEndereco(endereco);
		c.setNome(nome);
		c.setSenha(senha);
		c.setTelefone(telefone);
				
		HSQLDao dao = new HSQLDao();
		
		dao.adicionaCliente(c);
		
        return "ok";
    }

}
