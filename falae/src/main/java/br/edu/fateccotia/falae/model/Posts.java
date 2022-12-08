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
	private String post;
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private Users user;
	
	
	public Posts() {
		
	}
	
	public Posts(Integer id, Date dataPost, String post, Users user) {
		super();
		this.id = id;
		this.dataPost = dataPost;
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
	
	//GETTERS E SETTERS POST
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}

	
	
}
