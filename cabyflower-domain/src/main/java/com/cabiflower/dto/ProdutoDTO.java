package com.cabiflower.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ProdutoDTO implements Serializable{

	private static final long serialVersionUID = 7135951175609215869L;

	private Long idProduto;
	
	private String nomeProduto;
	
	private Double valorProduto;
	
	private String descricaoProduto;
	
	private BigInteger quantidade;
	
	private EmpresaDTO empresa;
	
	private TipoProdutoDTO tipoProduto;
	
	private Date dataCriacao;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public BigInteger getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigInteger quantidade) {
		this.quantidade = quantidade;
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public TipoProdutoDTO getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProdutoDTO tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
