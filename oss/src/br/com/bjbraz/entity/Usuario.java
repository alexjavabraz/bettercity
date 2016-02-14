package br.com.bjbraz.entity;

public class Usuario {

	// Campos obtidos pelo facebook login

	private String nome;
	private String email;
	private String id;
	private String idSocial;
	private String birthday;
	private String gender;
	private String locale;
	private String religion;

	// Campos da tela de cadastro
	private String sobreNome;
	private String telFixo;
	private String telCelular;
	private String cep;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String estado;
	private String cidade;
	private String linkFoto;
	
	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getTelFixo() {
		return telFixo;
	}

	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getIdSocial() {
		return idSocial;
	}

	public void setIdSocial(String idSocial) {
		this.idSocial = idSocial;
	}

	public String generateJson() {
		StringBuilder sb = new StringBuilder(350);
		sb.append("{\"nome\":\""+getNome()+"\",\"telfixo\":\""+getTelFixo()+"\",\"telcelular\":\""+getTelCelular()+"\",\"cep\":\""+getCep()+"\",\"endereco\":\""+getEndereco()+"\",\"numero\":\""+getNumero()+"\",\"complemento\":\""+getComplemento()+"\",\"bairro\":\""+getBairro()+"\",\"uf\":\""+getEstado()+"\",\"cidade\":\""+getCidade()+"\"}");
		return sb.toString();
	}

	/*
	 * 
	 * console.log('name, ' + response.name + '.'); console.log('email, ' +
	 * response.email + '.'); console.log('first_name, ' + response.first_name +
	 * '.'); console.log('last_name, ' + response.last_name + '.');
	 * console.log('id, ' + response.id + '.'); console.log('birthday, ' +
	 * response.birthday + '.'); console.log('Gender, ' + response.gender +
	 * '.'); console.log('locale, ' + response.locale + '.');
	 * console.log('Religion, ' + response.religion + '.');
	 */

}