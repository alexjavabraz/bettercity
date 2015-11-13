package br.com.bjbraz.pojo;

public class Ponto {

	private String place;
	private String time;
	private String updated;
	private String url = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/nn00517535.geojsonp";
	private String zIndex;
	private String descricaoDoProblema;
	private String status = "automatic";
	private String type;
	private String title;
	private Coordenada coordenada;
	

	/*
	 * {'type':'Feature','properties':{'mag':3, 'place':'Rua alga marinha,
	 * problema na cal&ccedil;ada. Existe um enorme buraco na cal&ccedil;ada na
	 * altura do n&#250;mero 100', 'time':1446559068660,
	 * 'updated':1446559263142, 'tz':-480,
	 * 'url':'http://earthquake.usgs.gov/earthquakes/eventpage/nn00517535',
	 * 'detail':'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/nn00517535.geojsonp',
	 * 'felt':0, 'cdi':1, 'mmi':null, 'alert':null, 'status':'automatic',
	 * 'tsunami':0,'sig':96,'net':'nn',
	 * 'code':'00517535','ids':',nn00517535,','sources':',nn,','types':',dyfi,general-link,general-link,geoserve,nearby-cities,origin,phase-data,','nst':17,'dmin':0.562,'rms':null,'gap':275.49,'magType':'ml',
	 * 'type':'problema', 'title':'Buraco na cal&ccedil;ada'},
	 * 'geometry':{'type':'Point','coordinates':[-23.6069171,-46.9195135,0.2]},'id':'nn00517535'},
	 */

	

	@Override
	public String toString() {
		//return 	 "{'type':'Feature','properties':{'mag':"+zIndex+",'place':'"+descricaoDoProblema+"','time':1446559068660,'updated':1446559263142,'tz':-480,"+"'url':'"+url+"','detail':'"+url+"','felt':0,'cdi':1,'mmi':null,'alert':null,'status':'"+status+"','tsunami':0,'sig':96,'net':'nn','code':'00517535','ids':',nn00517535,','sources':',nn,','types':',dyfi,general-link,general-link,geoserve,nearby-cities,origin,phase-data,','nst':17,'dmin':0.562,'rms':null,'gap':275.49,'magType':'ml',"+ "'type':'"+type+"','title':'"+title+"'},"+ "'geometry':{'type':'Point','coordinates':["+coordenada.getLatitudeAsString()+","+coordenada.getLongitudeAsString()+"]},'id':'nn00517535'}";
		
		return "{'type':'Feature','properties':{'mag':"+zIndex+",'place':'Rua alga marinha, problema na cal&ccedil;ada. Existe um enorme buraco na cal&ccedil;ada na altura do n&#250;mero 100','time':1446559068660,'updated':1446559263142,'tz':-480, 'url':'','detail':'','felt':0,'cdi':1,'mmi':null,'alert':null,      'status':'automatic','tsunami':0,'sig':96,'net':'nn','code':'00517535', 'ids':',nn00517535,','sources':',nn,','types':',dyfi,general-link,general-link,geoserve,nearby-cities,origin,phase-data,','nst':17,'dmin':0.562,'rms':null,'gap':275.49,'magType':'ml',     'type':'"+type+"',  'title':'Buraco na cal&ccedil;ada'},          'geometry':{'type':'Point','coordinates':["+coordenada.getLatitudeAsString()+","+coordenada.getLongitudeAsString()+",0.2]},'id':'nn00517535'}";
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getzIndex() {
		return zIndex;
	}

	public void setzIndex(String zIndex) {
		this.zIndex = zIndex;
	}

	public String getDetalhe() {
		return descricaoDoProblema;
	}

	public void setDetalhe(String detalhe) {
		this.descricaoDoProblema = detalhe;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordenada == null) ? 0 : coordenada.hashCode());
		result = prime * result + ((descricaoDoProblema == null) ? 0 : descricaoDoProblema.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((zIndex == null) ? 0 : zIndex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ponto other = (Ponto) obj;
		if (coordenada == null) {
			if (other.coordenada != null)
				return false;
		} else if (!coordenada.equals(other.coordenada))
			return false;
		if (descricaoDoProblema == null) {
			if (other.descricaoDoProblema != null)
				return false;
		} else if (!descricaoDoProblema.equals(other.descricaoDoProblema))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (zIndex == null) {
			if (other.zIndex != null)
				return false;
		} else if (!zIndex.equals(other.zIndex))
			return false;
		return true;
	}
	

}
