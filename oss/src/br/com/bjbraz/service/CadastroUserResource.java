package br.com.bjbraz.service;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bjbraz.entity.HSQLDao;
import br.com.bjbraz.entity.Usuario;

@Path("/cliente/ins")
public class CadastroUserResource {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insert(
    		@FormParam("nome") String nome, 
    		@FormParam("email") String email,
    		@FormParam("gender") String gender, 
    		@FormParam("id") String id,
    		@FormParam("locale") String locale,
    		@FormParam("birthday") String birthday,
    		@FormParam("religion") String religion) {
		
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setEmail(email);
		user.setGender(gender);
		user.setId(id);
		user.setLocale(locale);
		user.setBirthday(birthday);
		user.setReligion(religion);
		 
		HSQLDao dao = new HSQLDao();
		dao.adicionarUsuario(user);
		
		
        return "ok";
    }	

}
