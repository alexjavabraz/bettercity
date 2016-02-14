package br.com.bjbraz.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bjbraz.entity.HSQLDao;
import br.com.bjbraz.entity.Usuario;

@Path("/cliente")
public class CadastroUserResource {
	
	@POST
	@Path("/ins")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insert(
    		@FormParam("nome") String nome, 
    		@FormParam("email") String email,
    		@FormParam("gender") String gender, 
    		@FormParam("id") String id,
    		@FormParam("locale") String locale,
    		@FormParam("birthday") String birthday,
    		@FormParam("religion") String religion,
    		@FormParam("linkFoto") String linkFoto) {
		
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setEmail(email);
		user.setGender(gender);
		user.setIdSocial(id);
		user.setLocale(locale);
		user.setBirthday(birthday);
		user.setReligion(religion);
		user.setLinkFoto(linkFoto);
		HSQLDao dao = new HSQLDao();
		dao.adicionarUsuario(user);
        return "ok";
    }
	
	@POST
	@Path("/alterarCliente")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String alterarCliente(
    		@FormParam("email") String email, 
    		@FormParam("nome") String nome, 
    		@FormParam("sobreNome") String sobreNome,
    		@FormParam("dataNascimento") String dataNascimento, 
    		@FormParam("telFixo") String telFixo,
    		@FormParam("telCelular") String telCelular,
    		@FormParam("cep") String cep,
    		@FormParam("endereco") String endereco,
    		@FormParam("numero") String numero,
    		@FormParam("complemento") String complemento,
    		@FormParam("bairro") String bairro,
    		@FormParam("estado") String estado,
    		@FormParam("cidade") String cidade,
    		@FormParam("linkFoto") String linkFoto
    		) {
		
		HSQLDao dao  = new HSQLDao();
		Usuario user = dao.buscarUsuarioPorEmail(email);
		user.setNome(nome);
		user.setBirthday(dataNascimento);
		user.setSobreNome(sobreNome);
		user.setTelFixo(telFixo);
		user.setTelCelular(telCelular);
		user.setCep(cep);
		user.setEndereco(endereco);
		user.setNumero(numero);
		user.setComplemento(complemento);
		user.setBairro(bairro);
		user.setEstado(estado);
		user.setCidade(cidade);
		user.setLinkFoto(linkFoto);
		dao.salvarUsuario(user);
		
        return "ok";
    }
	
	@POST
	@Path("/retrieve")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String retrieve(
    		@FormParam("email") String email
    		) {
		
		if(null == email){
			return "";
		}
		HSQLDao dao  = new HSQLDao();
		Usuario user = dao.buscarUsuarioPorEmail(email);
        return user.generateJson();
    }	
	
}