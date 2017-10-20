package com.cabiflower.dto;

import java.io.Serializable;

public class EnderecoDTO implements Serializable{
	
	private static final long serialVersionUID = 7135951175609215869L;

	private Long idEndereco;
	
	private String rua;
	
	private String bairro;
	
	private Long numero;
	
	private String complemento;
	
	private MunicipioDTO municipio;

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public MunicipioDTO getMunicipio() {
		return municipio;
	}

	public void setMunicipio(MunicipioDTO municipio) {
		this.municipio = municipio;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
