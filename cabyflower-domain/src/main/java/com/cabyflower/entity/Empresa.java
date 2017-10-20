package com.cabyflower.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPRESA database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEQ_EMPRESA")
	private String seqEmpresa;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_CRIACAO")
	private Date datCriacao;

	@Column(name="DES_RAZAO_SOCIAL")
	private String desRazaoSocial;

	@Column(name="NOM_FANTASIA")
	private String nomFantasia;

	@Column(name="TEX_CNPJ")
	private String texCnpj;

	//bi-directional many-to-one association to Endereco
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_ENDERECO")
	private Endereco endereco;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="empresa")
	private List<Produto> produtos;

	public Empresa() {
	}

	public String getSeqEmpresa() {
		return this.seqEmpresa;
	}

	public void setSeqEmpresa(String seqEmpresa) {
		this.seqEmpresa = seqEmpresa;
	}

	public Date getDatCriacao() {
		return this.datCriacao;
	}

	public void setDatCriacao(Date datCriacao) {
		this.datCriacao = datCriacao;
	}

	public String getDesRazaoSocial() {
		return this.desRazaoSocial;
	}

	public void setDesRazaoSocial(String desRazaoSocial) {
		this.desRazaoSocial = desRazaoSocial;
	}

	public String getNomFantasia() {
		return this.nomFantasia;
	}

	public void setNomFantasia(String nomFantasia) {
		this.nomFantasia = nomFantasia;
	}

	public String getTexCnpj() {
		return this.texCnpj;
	}

	public void setTexCnpj(String texCnpj) {
		this.texCnpj = texCnpj;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setEmpresa(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setEmpresa(null);

		return produto;
	}

}