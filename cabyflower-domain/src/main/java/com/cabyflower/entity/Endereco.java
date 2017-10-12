package com.cabyflower.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "ENDERECO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEndereco", scope = Endereco.class)
public class Endereco implements Serializable{

	private static final long serialVersionUID = 3180067818970738965L;

	@Id
	@Column(name = "SEQ_ENDERECO", nullable = false, unique = true )
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEndereco;
	
	@Size(max = 500)
	@Column(name = "DES_RUA", nullable = false)
	private String rua;
	
	@Size(max = 500)
	@Column(name = "DES_BAIRRO", nullable = false)
	private String bairro;
	
	@Column(name = "NUM_ENDERECO", nullable = false)
	private Long numero;
	
	@Column(name = "DES_COMPLEMENTO")
	private String complemento;
	
	@JoinColumn(name = "SEQ_MUNICIPIO", nullable = false)
	private Municipio municipio;

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

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
