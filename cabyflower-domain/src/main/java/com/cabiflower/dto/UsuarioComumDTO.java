package com.cabiflower.dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioComumDTO implements Serializable {
	
	private static final long serialVersionUID = 7135951175609215869L;

	private Long idUsuarioComum;
	
	private String nome;
	
	private Date nascimento;
	
	private EnderecoDTO endereco;
	
	private UsuarioDTO usuario;

	public Long getIdUsuarioComum() {
		return idUsuarioComum;
	}

	public void setIdUsuarioComum(Long idUsuarioComum) {
		this.idUsuarioComum = idUsuarioComum;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}
