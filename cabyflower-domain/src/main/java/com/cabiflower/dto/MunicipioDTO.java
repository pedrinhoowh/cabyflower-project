package com.cabiflower.dto;

import java.io.Serializable;

public class MunicipioDTO implements Serializable{

	private static final long serialVersionUID = 7135951175609215869L;

	private Long idMunicipio;
	
	private String nomeMunicipio;
	
	private UfDTO uf;

	public Long getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	public UfDTO getUf() {
		return uf;
	}

	public void setUf(UfDTO uf) {
		this.uf = uf;
	}
	
}
