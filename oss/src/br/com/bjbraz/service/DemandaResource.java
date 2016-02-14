package br.com.bjbraz.service;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import br.com.bjbraz.entity.Demanda;
import br.com.bjbraz.entity.HSQLDao;
import br.com.bjbraz.util.UtilFunction;


@Path("/demanda/ins")
public class DemandaResource {
	
	@Context
	private HttpServletRequest request;	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insert(
    		@FormParam("titulo") String titulo, 
    		@FormParam("descricao") String descricao,
    		@FormParam("endereco") String endereco, 
    		@FormParam("latitude") String latitude, 
    		@FormParam("longitude") String longitude) {
		
		if(validarInformacoesBasicasAberturaDaDemanda(titulo, descricao, endereco, latitude, longitude)){
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
		
		
        return "nok";
    }
	
	private boolean validarInformacoesBasicasAberturaDaDemanda(String titulo, String descricao, String endereco,
			String latitude, String longitude) {
		
		if(UtilFunction.isBlankOrNull(titulo)){
			return false;
		}
		
		if(UtilFunction.isBlankOrNull(descricao)){
			return false;
		}
		
		if(UtilFunction.isBlankOrNull(endereco)){
			return false;
		}
		
		if(UtilFunction.isBlankOrNull(latitude)){
			return false;
		}
		
		if(UtilFunction.isBlankOrNull(longitude)){
			return false;
		}		
		
		return true;
	}

	/**
	 * 
	 * @param lon
	 * @param lat
	 * @param id
	 * @param descricao
	 * @param titulo
	 * @param in
	 * @return
	 */
	@POST
	@Path("/nova/{id}/{lat}/{lon}/{descricao}/{titulo}/{endereco}")
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	public String uploadFoto(@PathParam("lat") String lat, @PathParam("lon") String lon, @PathParam("id") String id, @PathParam("descricao") String descricao, @PathParam("titulo") String titulo, @PathParam("endereco") String endereco, final InputStream in){
		String idDemanda = "";
		
		if(lat!= null && lon != null){
			idDemanda = salvarDemandaNoBancoDeDados(titulo, id, lat, lon, descricao, endereco);
		}
		
		return idDemanda;
	}

	/**
	 * 
	 * @param titulo
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param descricao
	 * @return
	 */
	private String salvarDemandaNoBancoDeDados(String titulo, String id, String latitude, String longitude, String descricao, String endereco) {
		Demanda d = new Demanda();
		d.setDescricao(descricao);
		d.setTitulo(titulo);
		d.setEndereco(endereco);
		d.setLatitude(latitude);
		d.setLongitude(longitude);
		HSQLDao dao = new HSQLDao();
		Integer idGerado = dao.adicionaDemanda(d);
		
		return String.valueOf(idGerado);
	}
	
	
	@GET
	@Path("insTest/{latitude}/{longitude}/{descricao}/{titulo}/{endereco}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insTest(
    		@PathParam("latitude") String latitude, 
    		@PathParam("longitude") String longitude,
    		@PathParam("descricao") String descricao,
    		@PathParam("titulo") String titulo,
    		@PathParam("endereco") String endereco
    		) {
		
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