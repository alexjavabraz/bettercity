package br.com.bjbraz.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapJson {
	
	private String type = "a";
	private String place = "b";
	private String mag = "c";
	private String url = "d";
	private String title;
	private String lat;
	private String lon;
	private String id;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getMag() {
		return mag;
	}
	public void setMag(String mag) {
		this.mag = mag;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lon == null) ? 0 : lon.hashCode());
		result = prime * result + ((mag == null) ? 0 : mag.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		MapJson other = (MapJson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lon == null) {
			if (other.lon != null)
				return false;
		} else if (!lon.equals(other.lon))
			return false;
		if (mag == null) {
			if (other.mag != null)
				return false;
		} else if (!mag.equals(other.mag))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
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
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "eqfeed_callback("+
					"{'type':'FeatureCollection','metadata':{'generated':1446559642000,'url':'http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.geojsonp','title':'USGS Magnitude 2.5+ Earthquakes, Past Week','status':200,'api':'1.0.17','count':270},'features':["+
					"{'type':'Feature','properties':{'mag':3,'place':'Rua alga marinha, problema na cal&ccedil;ada. Existe um enorme buraco na cal&ccedil;ada na altura do n&#250;mero 100','time':1446559068660,'updated':1446559263142,'tz':-480,'url':'http://earthquake.usgs.gov/earthquakes/eventpage/nn00517535','detail':'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/nn00517535.geojsonp','felt':0,'cdi':1,'mmi':null,'alert':null,'status':'automatic','tsunami':0,'sig':96,'net':'nn','code':'00517535','ids':',nn00517535,','sources':',nn,','types':',dyfi,general-link,general-link,geoserve,nearby-cities,origin,phase-data,','nst':17,'dmin':0.562,'rms':null,'gap':275.49,'magType':'ml','type':'problema', 'title':'Buraco na cal&ccedil;ada'},                   'geometry':{'type':'Point','coordinates':[-23.6069171,-46.9195135,0.2]},'id':'nn00517535'},"+
					"{'type':'Feature','properties':{'mag':4,'place':' Falta de ilumina&#231;&#227;o','time':1445962917510,'updated':1445991908156,'tz':-300,'url':'http://earthquake.usgs.gov/earthquakes/eventpage/us10003rwm','detail':'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us10003rwm.geojsonp','felt':null,'cdi':null,'mmi':null,'alert':null,'status':'reviewed','tsunami':0,'sig':284,'net':'us','code':'10003rwm','ids':',us10003rwm,','sources':',us,','types':',cap,geoserve,nearby-cities,origin,phase-data,tectonic-summary,','nst':null,'dmin':0.775,'rms':0.76,'gap':97,'magType':'mb','type':'melhorado',       'title':'Problema na ilumina&ccedil;&#227;o'},'geometry':{'type':'Point','coordinates':[-23.6034014,-46.9222468,20.12]},'id':'us10003rwm'},"+
					"{'type':'Feature','properties':{'mag':2,'place':'&#201; necess&#225;rio uma lombada no trevo sentido centro','time':1445960681200,'updated':1445966773714,'tz':-300,'url':'http://earthquake.usgs.gov/earthquakes/eventpage/us10003rvd','detail':'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us10003rvd.geojsonp','felt':5,'cdi':2,'mmi':null,'alert':null,'status':'reviewed','tsunami':0,'sig':149,'net':'us','code':'10003rvd','ids':',us10003rvd,','sources':',us,','types':',cap,dyfi,general-link,geoserve,nearby-cities,origin,phase-data,tectonic-summary,','nst':null,'dmin':null,'rms':0.65,'gap':60,'magType':'ml','type':'working',   'title':'Falta lombada'},                     'geometry':{'type':'Point','coordinates':[-23.6033787,-46.9231427,4.798]},'id':'us10003rvd'},"+
					"{'type':'Feature','properties':{'mag':1,'place':' A falta de uma lombada est&#225; causando alguns acidentes','time':1445956743000,'updated':1445985709419,'tz':-660,'url':'http://earthquake.usgs.gov/earthquakes/eventpage/ak11755660','detail':'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/ak11755660.geojsonp','felt':null,'cdi':null,'mmi':null,'alert':null,'status':'reviewed','tsunami':0,'sig':148,'net':'ak','code':'11755660','ids':',ak11755660,','sources':',ak,','types':',cap,general-link,geoserve,nearby-cities,origin,tectonic-summary,','nst':null,'dmin':null,'rms':0.44,'gap':null,'magType':'ml','type':'info',      'title':'Falta lombada'},                     'geometry':{'type':'Point','coordinates':[-23.6057502,-46.9178099,26.6]},'id':'ak11755660'}"+
					"],'bbox':[-177.8789,-60.9782,0.1,179.9497,68.5169,612.82]}"+
					");";
	}
	
	

}
