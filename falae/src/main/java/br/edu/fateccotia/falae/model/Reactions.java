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
	private Date dataReaction;
	private Integer tipoReaction;
	@ManyToOne()
	@JoinColumn(name = "fk_user_id")
	private Users user;
	
	@ManyToOne()
	@JoinColumn(name = "fk_post_id")
	private Posts post;
	
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
