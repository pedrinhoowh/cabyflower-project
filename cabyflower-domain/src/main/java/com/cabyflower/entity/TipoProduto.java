package com.cabyflower.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the TIPO_PRODUTO database table.
 * 
 */
@Entity
@Table(name="TIPO_PRODUTO")
@NamedQuery(name="TipoProduto.findAll", query="SELECT t FROM TipoProduto t")
public class TipoProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SEQ_TIPO_PRODUTO")
	private Long seqTipoProduto;

	@Column(name="DES_TIPO_PRODUTO")
	@NotNull
	private String desTipoProduto;

	public TipoProduto() {
	}

	public TipoProduto(Long seqTipoProduto) {
		this.seqTipoProduto = seqTipoProduto;
	}
	
	public Long getSeqTipoProduto() {
		return this.seqTipoProduto;
	}

	public void setSeqTipoProduto(Long seqTipoProduto) {
		this.seqTipoProduto = seqTipoProduto;
	}

	public String getDesTipoProduto() {
		return this.desTipoProduto;
	}

	public void setDesTipoProduto(String desTipoProduto) {
		this.desTipoProduto = desTipoProduto;
	}

}