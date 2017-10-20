package com.cabyflower.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MUNICIPIO database table.
 * 
 */
@Entity
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEQ_MUNICIPIO")
	private Long seqMunicipio;

	@Column(name="DES_BAIRRO")
	private String desBairro;

	@Column(name="NOM_MUNICIPIO")
	private String nomMunicipio;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="municipio")
	private List<Endereco> enderecos;

	//bi-directional many-to-one association to Uf
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_UF")
	private Uf uf;

	public Municipio() {
	}

	public Long getSeqMunicipio() {
		return this.seqMunicipio;
	}

	public void setSeqMunicipio(Long seqMunicipio) {
		this.seqMunicipio = seqMunicipio;
	}

	public String getDesBairro() {
		return this.desBairro;
	}

	public void setDesBairro(String desBairro) {
		this.desBairro = desBairro;
	}

	public String getNomMunicipio() {
		return this.nomMunicipio;
	}

	public void setNomMunicipio(String nomMunicipio) {
		this.nomMunicipio = nomMunicipio;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setMunicipio(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setMunicipio(null);

		return endereco;
	}

	public Uf getUf() {
		return this.uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

}