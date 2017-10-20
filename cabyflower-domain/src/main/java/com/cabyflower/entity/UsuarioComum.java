package com.cabyflower.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the USUARIO_COMUM database table.
 * 
 */
@Entity
@Table(name="USUARIO_COMUM")
@NamedQuery(name="UsuarioComum.findAll", query="SELECT u FROM UsuarioComum u")
public class UsuarioComum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEQ_USUARIO_COMUM")
	private Long seqUsuarioComum;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_NASCIMENTO")
	private Date datNascimento;

	@Column(name="NOM_USUARIO_COMUM")
	private String nomUsuarioComum;

	//bi-directional many-to-one association to Endereco
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_ENDERECO")
	private Endereco endereco;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEQ_USUARIO")
	private Usuario usuario;

	public UsuarioComum() {
	}

	public Long getSeqUsuarioComum() {
		return this.seqUsuarioComum;
	}

	public void setSeqUsuarioComum(Long seqUsuarioComum) {
		this.seqUsuarioComum = seqUsuarioComum;
	}

	public Date getDatNascimento() {
		return this.datNascimento;
	}

	public void setDatNascimento(Date datNascimento) {
		this.datNascimento = datNascimento;
	}

	public String getNomUsuarioComum() {
		return this.nomUsuarioComum;
	}

	public void setNomUsuarioComum(String nomUsuarioComum) {
		this.nomUsuarioComum = nomUsuarioComum;
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

}