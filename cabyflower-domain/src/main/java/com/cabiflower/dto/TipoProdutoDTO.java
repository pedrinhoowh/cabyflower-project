package com.cabiflower.dto;

import java.io.Serializable;

public class TipoProdutoDTO implements Serializable {

	private static final long serialVersionUID = 7135951175609215869L;
	
	private Long idTipoProduto;

	private String descricao;

	public Long getIdTipoProduto() {
		return idTipoProduto;
	}

	public void setIdTipoProduto(Long idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoProdutoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoProdutoDTO(Long tipoProduto) {
		this.idTipoProduto = tipoProduto;
	}
}
