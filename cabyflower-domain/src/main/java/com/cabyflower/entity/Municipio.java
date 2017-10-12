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
@Table(name = "MUNICIPIO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMunicipio", scope = Municipio.class)
public class Municipio implements Serializable{
	
	private static final long serialVersionUID = 3180067818970738965L;

	@Id
	@Column(name = "SEQ_MUNICIPIO", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMunicipio;
	
	@Size(max = 500)
	@Column(name = "NOM_MUNICIPIO", nullable = false)
	private String nomeMunicipio;
	
	@JoinColumn(name = "SEQ_UF", nullable = false)
	private Uf uf;

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

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
}
