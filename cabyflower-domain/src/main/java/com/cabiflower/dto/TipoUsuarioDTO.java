package com.cabiflower.dto;

import java.io.Serializable;

public class TipoUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 7135951175609215869L;

	private static Long USUARIO_COMUM = 1L;
	
	private static Long USUARIO_ESTABELECIMENTO = 2L;
	
	private Long idTipoUsuario;

	private String descricao;

	public static Long getUSUARIO_COMUM() {
		return USUARIO_COMUM;
	}

	public static void setUSUARIO_COMUM(Long uSUARIO_COMUM) {
		USUARIO_COMUM = uSUARIO_COMUM;
	}

	public static Long getUSUARIO_ESTABELECIMENTO() {
		return USUARIO_ESTABELECIMENTO;
	}

	public static void setUSUARIO_ESTABELECIMENTO(Long uSUARIO_ESTABELECIMENTO) {
		USUARIO_ESTABELECIMENTO = uSUARIO_ESTABELECIMENTO;
	}

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

	public TipoUsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoUsuarioDTO(Long tipoUsuario) {
		this.idTipoUsuario = tipoUsuario;
	}
}
