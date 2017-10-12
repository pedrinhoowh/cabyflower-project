package com.cabyflower.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "USUARIO_COMUM")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuarioComum", scope = UsuarioComum.class)
public class UsuarioComum implements Serializable{

	private static final long serialVersionUID = 3180067818970738965L;

	@Id
	@Column(name = "SEQ_USUARIO_COMUM", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuarioComum;
	
	@Size(max = 400)
	@Column(name = "NOM_USUARIO_COMUM", nullable = false)
	private String nome;
	
    @Temporal(TemporalType.DATE)
	@Column(name = "DAT_NASCIMENTO", nullable = false)
	private LocalDate nascimento;
	
	@OneToOne(mappedBy = "endereco")
	private Endereco endereco;

	@JoinColumn(name = "SEQ_USUARIO", nullable = false)
	private Usuario usuario;

	public Long getIdUsuarioComum() {
		return idUsuarioComum;
	}

	public void setIdUsuarioComum(Long idUsuarioComum) {
		this.idUsuarioComum = idUsuarioComum;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
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

}
