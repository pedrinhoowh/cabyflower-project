package com.cabyflower.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SEQ_USER")
	private Long seqUser;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_CRIACAO")
	private Date datCriacao;

	@Column(name="DES_LOGIN")
	private String desLogin;

	@Column(name="DES_SENHA")
	private String desSenha;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="usuario")
	private List<Empresa> empresas;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_TIPO_USUARIO")
	private TipoUsuario tipoUsuario;

	//bi-directional many-to-one association to UsuarioComum
	@OneToMany(mappedBy="usuario")
	private List<UsuarioComum> usuarioComums;

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

	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setUsuario(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setUsuario(null);

		return empresa;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<UsuarioComum> getUsuarioComums() {
		return this.usuarioComums;
	}

	public void setUsuarioComums(List<UsuarioComum> usuarioComums) {
		this.usuarioComums = usuarioComums;
	}

	public UsuarioComum addUsuarioComum(UsuarioComum usuarioComum) {
		getUsuarioComums().add(usuarioComum);
		usuarioComum.setUsuario(this);

		return usuarioComum;
	}

	public UsuarioComum removeUsuarioComum(UsuarioComum usuarioComum) {
		getUsuarioComums().remove(usuarioComum);
		usuarioComum.setUsuario(null);

		return usuarioComum;
	}

}