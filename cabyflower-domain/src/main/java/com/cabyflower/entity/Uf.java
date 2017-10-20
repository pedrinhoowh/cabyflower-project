package com.cabyflower.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private String seqUf;

	@Column(name="NOM_UF")
	private String nomUf;

	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="uf")
	private List<Municipio> municipios;

	public Uf() {
	}

	public String getSeqUf() {
		return this.seqUf;
	}

	public void setSeqUf(String seqUf) {
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