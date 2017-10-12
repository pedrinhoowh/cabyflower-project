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
@Table(name = "USUARIO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUser", scope = Usuario.class)
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 3180067818970738965L;
	
	@Id
	@Column(name = "SEQ_USER", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser;
	
	@Size(max = 400)
	@Column(name = "DES_LOGIN", nullable = false, unique = true)
	private String loginUser;
	
	@Size(max = 400)
	@Column(name = "DES_SENHA", nullable = false)
	private String password;
	
	@OneToOne(mappedBy = "tipoUsuario")
	@JoinColumn(name = "TIP_USER", nullable = false)
	private TipoUsuario tipoUsuario;
	
    @Temporal(TemporalType.DATE)
	@Column(name = "DAT_CRIACAO", nullable = false)
	private LocalDate dataCriacao;
	
	@Column(name = "ATV_USER", nullable = false)
	private Boolean ativo = true;
	
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((loginUser == null) ? 0 : loginUser.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (loginUser == null) {
			if (other.loginUser != null)
				return false;
		} else if (!loginUser.equals(other.loginUser))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
}
