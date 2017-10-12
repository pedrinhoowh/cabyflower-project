package com.cabyflower.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "TIPO_USUARIO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTipoUsuario", scope = TipoUsuario.class)
public class TipoUsuario implements Serializable {

	private static final long serialVersionUID = 3180067818970738965L;

	private static final Long USUARIO_COMUM = 1L;
	
	private static final Long USUARIO_ESTABELECIMENTO = 2L;
	
	@Id
	@Column(name = "SEQ_TIPO_USUARIO", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipoUsuario;

	@Size(max = 4000)
	@Column(name = "DES_TIPO_USUARIO", nullable = false)
	private String descricao;

	public Long getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoUsuario(Long tipoUsuario) {
		this.idTipoUsuario = tipoUsuario;
	}

	public static Long getUsuarioComum() {
		return USUARIO_COMUM;
	}

	public static Long getUsuarioEstabelecimento() {
		return USUARIO_ESTABELECIMENTO;
	}
	
}
