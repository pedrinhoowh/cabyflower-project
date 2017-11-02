package com.cabyflower.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the ENDERECO database table.
 * 
 */
@Entity
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SEQ_ENDERECO")
	private Long seqEndereco;

	@Column(name="DES_BAIRRO")
	private String desBairro;

	@Column(name="DES_COMPLEMENTO")
	private String desComplemento;

	@Column(name="DES_RUA")
	private String desRua;

	@Column(name="NUM_ENDERECO")
	private BigInteger numEndereco;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="endereco")
	private List<Empresa> empresas;

	//bi-directional many-to-one association to Municipio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_MUNICIPIO")
	private Municipio municipio;

	//bi-directional many-to-one association to UsuarioComum
	@OneToMany(mappedBy="endereco")
	private List<UsuarioComum> usuarioComums;

	public Endereco() {
	}

	public Long getSeqEndereco() {
		return this.seqEndereco;
	}

	public void setSeqEndereco(Long seqEndereco) {
		this.seqEndereco = seqEndereco;
	}

	public String getDesBairro() {
		return this.desBairro;
	}

	public void setDesBairro(String desBairro) {
		this.desBairro = desBairro;
	}

	public String getDesComplemento() {
		return this.desComplemento;
	}

	public void setDesComplemento(String desComplemento) {
		this.desComplemento = desComplemento;
	}

	public String getDesRua() {
		return this.desRua;
	}

	public void setDesRua(String desRua) {
		this.desRua = desRua;
	}

	public BigInteger getNumEndereco() {
		return this.numEndereco;
	}

	public void setNumEndereco(BigInteger numEndereco) {
		this.numEndereco = numEndereco;
	}

	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setEndereco(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setEndereco(null);

		return empresa;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<UsuarioComum> getUsuarioComums() {
		return this.usuarioComums;
	}

	public void setUsuarioComums(List<UsuarioComum> usuarioComums) {
		this.usuarioComums = usuarioComums;
	}

	public UsuarioComum addUsuarioComum(UsuarioComum usuarioComum) {
		getUsuarioComums().add(usuarioComum);
		usuarioComum.setEndereco(this);

		return usuarioComum;
	}

	public UsuarioComum removeUsuarioComum(UsuarioComum usuarioComum) {
		getUsuarioComums().remove(usuarioComum);
		usuarioComum.setEndereco(null);

		return usuarioComum;
	}

}