package com.cabyflower.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
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
 * The persistent class for the EMPRESA database table.
 * 
 */
@Entity
@Table(name = "EMPRESA")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SEQ_EMPRESA")
	private Long seqEmpresa;

	@Column(name="DAT_CRIACAO")
	@NotNull
	private Date datCriacao;

	@Column(name="DES_RAZAO_SOCIAL")
	@NotNull
	private String desRazaoSocial;

	@Column(name="NOM_FANTASIA")
	private String nomFantasia;

	@Column(name="TEX_CNPJ")
	@NotNull
	private String texCnpj;

	//bi-directional many-to-one association to Endereco
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@NotNull
	@JoinColumn(name="SEQ_ENDERECO")
	private Endereco endereco;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_USUARIO")
	@NotNull
	private Usuario usuario;

	public Empresa() {
	}

	public Long getSeqEmpresa() {
		return this.seqEmpresa;
	}

	public void setSeqEmpresa(Long seqEmpresa) {
		this.seqEmpresa = seqEmpresa;
	}

	public Date getDatCriacao() {
		return this.datCriacao;
	}

	public void setDatCriacao(Date datCriacao) {
		this.datCriacao = datCriacao;
	}

	public String getDesRazaoSocial() {
		return this.desRazaoSocial;
	}

	public void setDesRazaoSocial(String desRazaoSocial) {
		this.desRazaoSocial = desRazaoSocial;
	}

	public String getNomFantasia() {
		return this.nomFantasia;
	}

	public void setNomFantasia(String nomFantasia) {
		this.nomFantasia = nomFantasia;
	}

	public String getTexCnpj() {
		return this.texCnpj;
	}

	public void setTexCnpj(String texCnpj) {
		this.texCnpj = texCnpj;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}