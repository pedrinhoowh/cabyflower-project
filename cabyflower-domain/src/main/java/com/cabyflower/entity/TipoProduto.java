package com.cabyflower.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEQ_TIPO_PRODUTO")
	private Long seqTipoProduto;

	@Column(name="DES_TIPO_PRODUTO")
	private String desTipoProduto;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="tipoProduto")
	private List<Produto> produtos;

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

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setTipoProduto(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setTipoProduto(null);

		return produto;
	}

}