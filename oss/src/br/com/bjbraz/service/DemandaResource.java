package br.com.bjbraz.service;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import br.com.bjbraz.entity.Demanda;
import br.com.bjbraz.entity.HSQLDao;


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
	@Path("/nova/{id}/{lat}/{long}/{descricao}/{titulo}")
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	public String uploadFoto(@PathParam("lon") String lon, @PathParam("lat") String lat, @PathParam("id") String id, @PathParam("descricao") String descricao, @PathParam("titulo") String titulo, final InputStream in){
		String idDemanda = salvarDemandaNoBancoDeDados(titulo, id, lat, lon, descricao);
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
	private String salvarDemandaNoBancoDeDados(String titulo, String id, String latitude, String longitude, String descricao) {
		Demanda d = new Demanda();
		d.setDescricao(descricao);
		d.setTitulo(titulo);
		d.setEndereco(descricao);
		d.setLatitude(latitude);
		d.setLongitude(longitude);
		HSQLDao dao = new HSQLDao();
		Integer idGerado = dao.adicionaDemanda(d);
		
		return String.valueOf(idGerado);
	}

}