package com.cabiflower.dto;

import java.io.Serializable;

public class UfDTO implements Serializable {
	
	private static final long serialVersionUID = 7135951175609215869L;

	private Long idUf;
	
	private String nomeUf;

	public Long getIdUf() {
		return idUf;
	}

	public void setIdUf(Long idUf) {
		this.idUf = idUf;
	}

	public String getNomeUf() {
		return nomeUf;
	}

	public void setNomeUf(String nomeUf) {
		this.nomeUf = nomeUf;
	}
	
}
