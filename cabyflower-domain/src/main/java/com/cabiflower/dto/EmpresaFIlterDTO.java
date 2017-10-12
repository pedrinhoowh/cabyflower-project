package com.cabiflower.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class EmpresaFIlterDTO implements Serializable {
	
	private static final long serialVersionUID = 7135951175609215869L;
	
	private String razaoSocial;
	
	private String nomeFantasia;
	
	@NotNull
	private String nomeMunicipio;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}
	
}
