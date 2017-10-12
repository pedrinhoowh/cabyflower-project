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
@Table(name = "UF")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUf", scope = Uf.class)
public class Uf implements Serializable{
	
	private static final long serialVersionUID = 3180067818970738965L;
	
	@Id
	@Column(name = "SEQ_UF", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUf;
	
	@Size(max = 500)
	@Column(name = "NOM_UF", nullable = false)
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
