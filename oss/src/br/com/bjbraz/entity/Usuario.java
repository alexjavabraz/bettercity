package br.com.bjbraz.entity;

public class Usuario {
	
	private String nome;
	private String email;
	private String id;
	private String birthday;
	private String gender;
	private String locale;
	private String religion;
	
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
	
	
	
	
	/*
	 * 
	 * console.log('name, ' + response.name + '.');
	      console.log('email, ' + response.email + '.');
	      console.log('first_name, ' + response.first_name + '.');
	      console.log('last_name, ' + response.last_name + '.');
	      console.log('id, ' + response.id + '.');
	      console.log('birthday, ' + response.birthday + '.');
	      console.log('Gender, ' + response.gender + '.');
	      console.log('locale, ' + response.locale + '.');
	      console.log('Religion, ' + response.religion + '.');
	      */

}
