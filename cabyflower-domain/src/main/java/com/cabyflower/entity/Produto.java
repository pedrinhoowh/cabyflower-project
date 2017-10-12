package com.cabyflower.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "PRODUTO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduto", scope = Produto.class)
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 3180067818970738965L;

	@Id
	@Column(name = "SEQ_PRODUTO", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProduto;
	
	@Size(max = 400)
	@Column(name = "NOM_PRODUTO", nullable = false)
	private String nomeProduto;
	
	@Column(name = "VAL_PRODUTO", nullable = false)
	private Double valorProduto;
	
	@Size(max = 4000)
	@Column(name = "DES_PRODUTO")
	private String descricaoProduto;
	
	@Column(name = "QUA_PRODUTO", nullable = false)
	private Long quantidade;
	
	@JoinColumn(name = "SEQ_EMPRESA", nullable = false)
	private Empresa empresa;
	
	@JoinColumn(name = "SEQ_TIPO_PRODUTO", nullable = false)
	private TipoProduto tipoProduto;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_CRIACAO", nullable = false)
	private LocalDate dataCriacao;

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

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
