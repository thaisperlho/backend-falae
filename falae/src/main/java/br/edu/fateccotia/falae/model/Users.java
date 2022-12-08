package br.edu.fateccotia.falae.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String email;
	private String senha;
	private String nickname;
	private String picture;
	private String status;
	
	
	public Users() {
		
	}
	
	
	public Users(Integer id, String email, String senha, String nickname, String picture, String status) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nickname = nickname;
		this.picture = picture;
		this.status = status;
	}
	
	//GETTERS E SETTERS ID
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//GETTERS E SETTERS EMAIL
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//GETTERS E SETTERS SENHA
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//GETTERS E SETTERS NICKNAME
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	//GETTERS E SETTERS PICTURE
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	//GETTERS E SETTERS STATUS
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
