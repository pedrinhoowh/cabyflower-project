package com.cabyflower.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
@Table(name = "USUARIO")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SEQ_USER")
	private Long seqUser;

	@Column(name="DAT_CRIACAO")
	@NotNull
	private Date datCriacao;

	@Column(name="DES_LOGIN", unique = true)
	@NotNull
	private String desLogin;

	@Column(name="DES_SENHA")
	@NotNull
	private String desSenha;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_TIPO_USUARIO")
	@NotNull
	private TipoUsuario tipoUsuario;

	public Usuario() {
	}

	public Long getSeqUser() {
		return this.seqUser;
	}

	public void setSeqUser(Long seqUser) {
		this.seqUser = seqUser;
	}

	public Date getDatCriacao() {
		return this.datCriacao;
	}

	public void setDatCriacao(Date datCriacao) {
		this.datCriacao = datCriacao;
	}

	public String getDesLogin() {
		return this.desLogin;
	}

	public void setDesLogin(String desLogin) {
		this.desLogin = desLogin;
	}

	public String getDesSenha() {
		return this.desSenha;
	}

	public void setDesSenha(String desSenha) {
		this.desSenha = desSenha;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}