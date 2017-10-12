package com.cabyflower.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "TIPO_PRODUTO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTipoUsuario", scope = TipoProduto.class)
public class TipoProduto implements Serializable {

	private static final long serialVersionUID = 3180067818970738965L;

	private static final Long PRODUTO_GOLDEN = 1L;
	
	private static final Long PRODUTO_PRATA = 2L;
	
	private static final Long PRODUTO_SILVER = 3L;
	
	@Id
	@Column(name = "SEQ_TIPO_PRODUTO", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipoProduto;

	@Size(max = 4000)
	@Column(name = "DES_TIPO_PRODUTO", nullable = false)
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

	public TipoProduto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoProduto(Long tipoProduto) {
		this.idTipoProduto = tipoProduto;
	}

}
