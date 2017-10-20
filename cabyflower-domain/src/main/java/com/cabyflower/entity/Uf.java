package com.cabyflower.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the UF database table.
 * 
 */
@Entity
@NamedQuery(name="Uf.findAll", query="SELECT u FROM Uf u")
public class Uf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEQ_UF")
	private Long seqUf;

	@Column(name="NOM_UF")
	private String nomUf;

	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="uf")
	private List<Municipio> municipios;

	public Uf() {
	}

	public Long getSeqUf() {
		return this.seqUf;
	}

	public void setSeqUf(Long seqUf) {
		this.seqUf = seqUf;
	}

	public String getNomUf() {
		return this.nomUf;
	}

	public void setNomUf(String nomUf) {
		this.nomUf = nomUf;
	}

	public List<Municipio> getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public Municipio addMunicipio(Municipio municipio) {
		getMunicipios().add(municipio);
		municipio.setUf(this);

		return municipio;
	}

	public Municipio removeMunicipio(Municipio municipio) {
		getMunicipios().remove(municipio);
		municipio.setUf(null);

		return municipio;
	}

}