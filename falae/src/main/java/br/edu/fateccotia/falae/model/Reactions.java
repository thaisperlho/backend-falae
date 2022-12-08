package br.edu.fateccotia.falae.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reactions")
public class Reactions {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "dt_reactions")
	private Date dataReaction;
	@Column(name = "tipo_reaction")
	private Integer tipoReaction;
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "fk_post_id")
	private Posts post;

	
	public Reactions() {

	}

	public Reactions(Integer id, Date dataReaction, Integer tipoReaction, Users user, Posts post) {

		this.id = id;
		this.dataReaction = dataReaction;
		this.tipoReaction = tipoReaction;
		this.user = user;
		this.post = post;
	}
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Posts getPost() {
		return post;
	}
	public void setPost(Posts post) {
		this.post = post;
	}
	
	
	//GETTERS E SETTERS ID
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//GETTERS E SETTERS DATA REACTION
	public Date getDataReaction() {
		return dataReaction;
	}
	public void setDataReaction(Date dataReaction) {
		this.dataReaction = dataReaction;
	}
	
	//GETTERS E SETTERS TIPO REACTION
	public Integer getTipoReaction() {
		return tipoReaction;
	}
	public void setTipoReaction(Integer tipoReaction) {
		this.tipoReaction = tipoReaction;
	}

}
