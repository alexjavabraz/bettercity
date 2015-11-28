package br.com.teste;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class ReqTest {


	private static final String AMBIENTE = "http://localhost:8080"; // "http://homologacao.hipprint.com.br:8080";//

	public static void main(String[] args) {

		requisicaoPost();

	}

	private static void requisicaoPost() {
		Client c = ClientBuilder.newClient();
		Configuration newConfiguration = c.getConfiguration();
		WebTarget webTarget = c.target("http://localhost:8080/oss/rest/demanda/ins");
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/oss").path("/rest").path("/demanda").path("/ins");
		 
		Form form = new Form();
		form.param("titulo", "foo");
		form.param("descricao", "bar");
		 
		String s =
		target.request(MediaType.TEXT_PLAIN)
		    .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),
		        String.class);
		
		System.out.println(s);
		
	}
//
//	private static void recuperarSenha(String key) {
//		String retorno = null;
//		Client c = ClientBuilder.newClient();
//		Configuration newConfiguration = c.getConfiguration();
//		WebTarget webTarget = c.target("http://54.221.213.172:8080/hipservices/auth/cliente/recuperarSenha");
//
//		Response response = webTarget.queryParam("key", key).queryParam("email", "alexjavabraz@gmail.com").request()
//				.post(Entity.entity("key", MediaType.TEXT_PLAIN_TYPE).entity("email", MediaType.TEXT_PLAIN_TYPE));
//
//		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
//
//		System.out.println(response.getStatus());
//
//		retorno = response.readEntity(String.class);
//
//		System.out.println(retorno);
//	}
//
//	private static void salvarCliente(String key) {
//		String retorno = null;
//		Client c = ClientBuilder.newClient();
//		Configuration newConfiguration = c.getConfiguration();
//		WebTarget webTarget = c.target(AMBIENTE + "/hipservices/consulta/cliente/0/salvar");
//
//		Response response = webTarget.queryParam("key", key).queryParam("nome", "nome_valor_1")
//				.queryParam("password", "password_valor_1").queryParam("email", "windsor@metaslt.com.br").request()
//				.post(Entity.entity("key", MediaType.TEXT_PLAIN_TYPE).entity("nome", MediaType.TEXT_PLAIN_TYPE)
//						.entity("password", MediaType.TEXT_PLAIN_TYPE).entity("email", MediaType.TEXT_PLAIN_TYPE));
//
//		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
//
//		System.out.println(response.getStatus());
//
//		retorno = response.readEntity(String.class);
//
//		System.out.println(retorno);
//	}
//
//	private static void login(String key) {
//		String retorno = null;
//		Client c = ClientBuilder.newClient();
//		Configuration newConfiguration = c.getConfiguration();
//		WebTarget webTarget = c.target("http://localhost:8080/hipservices/auth/cliente/login");
//
//		Response response = webTarget.queryParam("key", key).queryParam("password", "ZGVsdGFzcDVr")
//				.queryParam("email", "alexjavabraz@gmail.com").request()
//				.post(Entity.entity("key", MediaType.TEXT_PLAIN_TYPE).entity("password", MediaType.TEXT_PLAIN_TYPE)
//						.entity("email", MediaType.TEXT_PLAIN_TYPE));
//
//		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
//
//		System.out.println(response.getStatus());
//
//		retorno = response.readEntity(String.class);
//
//		System.out.println(retorno);
//	}
//
//	private static String autentica() {
//		String retorno = null;
//		Client c = ClientBuilder.newClient();
//		Configuration newConfiguration = c.getConfiguration();
//		WebTarget webTarget = c.target(AMBIENTE + "/hipservices/auth/login/getKey");
//
//		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
//
//		// retorno = webTarget.queryParam("nome", "alex").queryParam("pass",
//		// "pass").request().get().readEntity(String.class);
//
//		retorno = webTarget.queryParam("nome", "hipprint_ios").queryParam("pass", "hp781421").request()
//				.post(Entity.entity("nome", MediaType.TEXT_PLAIN_TYPE).entity("pass", MediaType.TEXT_PLAIN_TYPE))
//				.readEntity(String.class);
//
//		System.out.println(retorno);
//
//		return retorno;
//	}
//
//	private static void upload(String key) {
//		Client c = ClientBuilder.newClient();
//		Configuration newConfiguration = c.getConfiguration();
//		WebTarget webTarget = c
//				.target(AMBIENTE + "/hipservices/consulta/cliente/1/nome do arquivo.png/" + key + "/fotoupload");
//
//		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_OCTET_STREAM);
//
//		File f = new File("c:\\temp\\Frame.closeIcons.png");
//
//		Response response = invocationBuilder
//				.post(Entity.entity(key, MediaType.TEXT_PLAIN_TYPE).entity(1, MediaType.TEXT_PLAIN_TYPE)
//						.entity("arquivo.png", MediaType.TEXT_PLAIN).entity(f, MediaType.APPLICATION_OCTET_STREAM));
//		System.out.println(response.getStatus());
//		System.out.println(response.readEntity(String.class));
//
//	}
 

}
