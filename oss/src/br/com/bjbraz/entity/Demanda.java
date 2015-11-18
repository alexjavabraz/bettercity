package br.com.bjbraz.entity;

import br.com.bjbraz.pojo.Coordenada;
import br.com.bjbraz.pojo.Ponto;

public class Demanda {
	
	//ID IDENTITY,
	private Integer id;
	
	//DESCRICAO(500) VARCHAR,
	private String descricao;
	
	//TITULO VARCHAR(500),
	private String titulo;
	
	//ENDERECO VARCHAR(500),
	private String endereco;
	
	//LATITUDE VARCHAR(500),
	private String latitude;
	
	//LONGITUDE VARCHAR(500)
	private String longitude;
	
	//TIPO VARCHAR(500)
	private String tipo = "problema";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Ponto toPonto(){
		Ponto p = new Ponto();
		p.setCoordenada(new Coordenada(Double.parseDouble(getLatitude()), Double.parseDouble(getLongitude())));
		p.setDetalhe(getDescricao());
		p.setPlace(getEndereco());
		p.setTitle(getTitulo());
		p.setType(getTipo());
		return p;
	}
	
}
