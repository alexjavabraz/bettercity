package br.com.bjbraz.pojo;


import java.io.ByteArrayOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Estabelecimento implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 3317885228874047507L;

    @XmlElement
    public String nome;
    
    @XmlElement
    public int id;
    
    @XmlElement
    public String email;

    @XmlElement
    public String endComplemento;

    @XmlElement
    public String endNumero;

    @XmlElement
    public String endRua;

    @XmlElement
    public String cidade;

    @XmlElement
    public String destaque;

    @XmlElement
    public String estado;

    @XmlElement
    public String nomeFantasia;

    @XmlElement
    public String razaoSocial;

    @XmlElement
    public String site;

    @XmlElement
    public String slogam;

    @XmlElement
    public String telefone;
    
    @XmlElement
    public String bairro;
    
    @XmlElement
    public String cep;
    
    @XmlElement
    public Boolean ehDestaque;
    
    @XmlElement
    private ByteArrayOutputStream bout;
    
    @XmlElement
    public String facebook;
    
    @XmlElement
    public byte[] biteArray;
    
    @XmlElement
    public byte[] biteArray2;
    
    @XmlElement
    public byte[] biteArray3;
    
    @XmlElement
    public byte[] biteArray4;    
    
    @XmlElement
    public String nomeSubGrupo;
    
    @XmlElement
    public int idSubGrupo;
 
    public Estabelecimento(String nome, int id,String email, String endComplemento,  String endNumero, String endRua, String cidade, 
        String destaque, String estado, String nomeFantasia, String razaoSocial, String site, String slogam, String telefone, 
        String bairro, String cep, ByteArrayOutputStream out
        ) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.endComplemento = endComplemento;
        this.endNumero = endNumero;
        this.endRua = endRua;
        this.cidade = cidade;
        this.destaque = destaque;
        this.estado = estado;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.site = site;
        this.slogam = slogam;
        this.telefone = telefone;
        this.bairro = bairro;
        this.cep = cep;
        bout = out;
    }
 
    // empty constructor needed for deserialization by JAXB
    public Estabelecimento() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
        result = prime * result + ((destaque == null) ? 0 : destaque.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((endComplemento == null) ? 0 : endComplemento.hashCode());
        result = prime * result + ((endNumero == null) ? 0 : endNumero.hashCode());
        result = prime * result + ((endRua == null) ? 0 : endRua.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + id;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
        result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
        result = prime * result + ((site == null) ? 0 : site.hashCode());
        result = prime * result + ((slogam == null) ? 0 : slogam.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
        Estabelecimento other = (Estabelecimento) obj;
        if (bairro == null) {
            if (other.bairro != null)
                return false;
        }
        else if (!bairro.equals(other.bairro))
            return false;
        if (cep == null) {
            if (other.cep != null)
                return false;
        }
        else if (!cep.equals(other.cep))
            return false;
        if (cidade == null) {
            if (other.cidade != null)
                return false;
        }
        else if (!cidade.equals(other.cidade))
            return false;
        if (destaque == null) {
            if (other.destaque != null)
                return false;
        }
        else if (!destaque.equals(other.destaque))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (endComplemento == null) {
            if (other.endComplemento != null)
                return false;
        }
        else if (!endComplemento.equals(other.endComplemento))
            return false;
        if (endNumero == null) {
            if (other.endNumero != null)
                return false;
        }
        else if (!endNumero.equals(other.endNumero))
            return false;
        if (endRua == null) {
            if (other.endRua != null)
                return false;
        }
        else if (!endRua.equals(other.endRua))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        }
        else if (!estado.equals(other.estado))
            return false;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        }
        else if (!nome.equals(other.nome))
            return false;
        if (nomeFantasia == null) {
            if (other.nomeFantasia != null)
                return false;
        }
        else if (!nomeFantasia.equals(other.nomeFantasia))
            return false;
        if (razaoSocial == null) {
            if (other.razaoSocial != null)
                return false;
        }
        else if (!razaoSocial.equals(other.razaoSocial))
            return false;
        if (site == null) {
            if (other.site != null)
                return false;
        }
        else if (!site.equals(other.site))
            return false;
        if (slogam == null) {
            if (other.slogam != null)
                return false;
        }
        else if (!slogam.equals(other.slogam))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        }
        else if (!telefone.equals(other.telefone))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return  "Estabelecimento {"  +
            "nome = '"  + nome + '\''  +
            ", bairro ='"  + bairro +"'}";
    }
    
}