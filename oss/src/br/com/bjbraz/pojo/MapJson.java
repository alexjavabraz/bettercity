package br.com.bjbraz.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.bjbraz.entity.HSQLDao;

@XmlRootElement
public class MapJson {

    private static final String SEPARADOR = ",";
    private String type = "a";
    private String place = "b";
    private String mag = "c";
    private String url = "d";
    private String title;
    private String lat;
    private String lon;
    private String id;
    private List<Ponto> pontosDoMapa;

    public MapJson() {
        pontosDoMapa = new ArrayList<Ponto>();

        HSQLDao dao = new HSQLDao();
        pontosDoMapa = dao.listarDemandas();

        if (pontosDoMapa.size() == 0) {
            Ponto a = new Ponto();
            a.setDetalhe("Rua alga marinha,  problema na cal&ccedil;ada. Existe um enorme buraco na cal&ccedil;ada na altura do n&#250;mero 100");
            a.setTitle("Buraco na cal&ccedil;ada");
            a.setzIndex("1");
            a.setType("melhorado");
            a.setCoordenada(new Coordenada(-23.6069171, -46.9195135));
        }

    }

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
        }
        else if (!id.equals(other.id))
            return false;
        if (lat == null) {
            if (other.lat != null)
                return false;
        }
        else if (!lat.equals(other.lat))
            return false;
        if (lon == null) {
            if (other.lon != null)
                return false;
        }
        else if (!lon.equals(other.lon))
            return false;
        if (mag == null) {
            if (other.mag != null)
                return false;
        }
        else if (!mag.equals(other.mag))
            return false;
        if (place == null) {
            if (other.place != null)
                return false;
        }
        else if (!place.equals(other.place))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        }
        else if (!title.equals(other.title))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        }
        else if (!type.equals(other.type))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        }
        else if (!url.equals(other.url))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder app = new StringBuilder(
            "eqfeed_callback("
                + "{'type':'FeatureCollection','metadata':{'generated':1446559642000,'url':'http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.geojsonp','title':'USGS Magnitude 2.5+ Earthquakes, Past Week','status':200,'api':'1.0.17','count':270},'features':["
                + "");

        if (pontosDoMapa != null) {

            Iterator<Ponto> it = pontosDoMapa.iterator();

            while (it.hasNext()) {
                Ponto p = it.next();

                app = app.append(p.toString());

                if (it.hasNext()) {
                    app = app.append(SEPARADOR);
                }
            }
        }

        app = app.append("],'bbox':[-177.8789,-60.9782,0.1,179.9497,68.5169,612.82]});");

        return app.toString();
    }

    public List<Ponto> getPontosDoMapa() {
        return pontosDoMapa;
    }

    public void setPontosDoMapa(List<Ponto> pontosDoMapa) {
        this.pontosDoMapa = pontosDoMapa;
    }


}
