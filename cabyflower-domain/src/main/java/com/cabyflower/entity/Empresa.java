package com.cabyflower.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "EMPRESA")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEmpresa", scope = Empresa.class)
public class Empresa implements Serializable {

	private static final long serialVersionUID = 3180067818970738965L;

	@Id
	@Column(name = "SEQ_EMPRESA", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEmpresa;

	@Size(max = 4000)
	@Column(name = "DES_RAZAO_SOCIAL", nullable = false)
	private String razaoSocial;

	@Size(max = 100)
	@Column(name = "TEX_CNPJ", nullable = false)
	private String cnpj;

	@Size(max = 400)
	@Column(name = "NOM_FANTASIA", nullable = false)
	private String nomeFantasia;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "endereco")
	@Column(name = "SEQ_ENDERECO", nullable = false)
	private Endereco endereco;
	
	@JoinColumn(name = "SEQ_USUARIO", nullable = false)
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	private List<Produto> produtos = new ArrayList<>();
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_CRIACAO", nullable = false)
	private LocalDate dataCriacao;

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
