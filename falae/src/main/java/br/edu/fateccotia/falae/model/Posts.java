package br.edu.fateccotia.falae.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Posts {
	//ATRIBUTO
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "dt_post")
	private Date dataPost;
	@Column(name = "model_post")
	private String modelo;
	private String post;
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private Users user;
	
	
	public Posts() {
		
	}


	public Posts(Integer id, Date dataPost, String modelo, String post, Users user) {
		super();
		this.id = id;
		this.dataPost = dataPost;
		this.modelo = modelo;
		this.post = post;
		this.user = user;
	}



	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	
	//GETTERS E SETTERS ID
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//GETTERS E SETTERS DATEPOST
	public Date getDataPost() {
		return dataPost;
	}
	public void setDataPost(Date dataPost) {
		this.dataPost = dataPost;
	}
	
	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	//GETTERS E SETTERS POST
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}

	
	
}
