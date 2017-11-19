package com.cabyflower.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the TIPO_USUARIO database table.
 * 
 */
@Entity
@Table(name="TIPO_USUARIO")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SEQ_TIPO_USUARIO")
	private Long seqTipoUsuario;

	@Column(name="DES_TIPO_USUARIO")
	@NotNull
	private String desTipoUsuario;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipoUsuario")
	private List<Usuario> usuarios;

	public TipoUsuario() {
	}
	
	public TipoUsuario(Long seqTipoUsuario) {
		this.seqTipoUsuario = seqTipoUsuario;
	}
	
	public Long getSeqTipoUsuario() {
		return this.seqTipoUsuario;
	}

	public void setSeqTipoUsuario(Long seqTipoUsuario) {
		this.seqTipoUsuario = seqTipoUsuario;
	}

	public String getDesTipoUsuario() {
		return this.desTipoUsuario;
	}

	public void setDesTipoUsuario(String desTipoUsuario) {
		this.desTipoUsuario = desTipoUsuario;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipoUsuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipoUsuario(null);

		return usuario;
	}

}