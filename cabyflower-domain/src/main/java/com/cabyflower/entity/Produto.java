package com.cabyflower.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the PRODUTO database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEQ_PRODUTO")
	private Long seqProduto;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_CRIACAO")
	private Date datCriacao;

	@Column(name="DES_PRODUTO")
	private String desProduto;

	@Column(name="NOM_PRODUTO")
	private String nomProduto;

	@Column(name="QUA_PRODUTO")
	private BigInteger quaProduto;

	@Column(name="VAL_PRODUTO")
	private Double valProduto;

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_EMPRESA")
	private Empresa empresa;

	//bi-directional many-to-one association to TipoProduto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_TIPO_PRODUTO")
	private TipoProduto tipoProduto;

	public Produto() {
	}

	public Long getSeqProduto() {
		return this.seqProduto;
	}

	public void setSeqProduto(Long seqProduto) {
		this.seqProduto = seqProduto;
	}

	public Date getDatCriacao() {
		return this.datCriacao;
	}

	public void setDatCriacao(Date datCriacao) {
		this.datCriacao = datCriacao;
	}

	public String getDesProduto() {
		return this.desProduto;
	}

	public void setDesProduto(String desProduto) {
		this.desProduto = desProduto;
	}

	public String getNomProduto() {
		return this.nomProduto;
	}

	public void setNomProduto(String nomProduto) {
		this.nomProduto = nomProduto;
	}

	public BigInteger getQuaProduto() {
		return this.quaProduto;
	}

	public void setQuaProduto(BigInteger quaProduto) {
		this.quaProduto = quaProduto;
	}

	public Double getValProduto() {
		return this.valProduto;
	}

	public void setValProduto(Double valProduto) {
		this.valProduto = valProduto;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public TipoProduto getTipoProduto() {
		return this.tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

}