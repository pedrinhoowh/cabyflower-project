package com.cabyflower.serviceImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cabiflower.dto.TipoUsuarioDTO;
import com.cabiflower.dto.UsuarioDTO;
import com.cabyflower.entity.TipoUsuario;
import com.cabyflower.entity.Usuario;
import com.cabyflower.service.UsuarioService;

import exception.SenhaException;
import util.SenhaUtil;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	@PersistenceContext(unitName = "cabyflowerUI")
	private EntityManager em;

	/**
	 * save usuario
	 * 
	 * @Param usuarioDTO
	 * @return usuarioDTO persist in database
	 * @throws SenhaException 
	 */
	@Override
	public UsuarioDTO save(UsuarioDTO usuarioDTO) throws SenhaException {
		Usuario usuario = this.convertUsuarioDTOInUsuario(usuarioDTO);
		if (usuario.getIdUser() != null) {
			this.comparaSenhaDB(usuario.getPassword(), this.getInEmail(usuario.getLoginUser()));
			em.merge(usuario);
		} else {
			usuario.setPassword(criptografaSenha(usuario.getPassword()));
			em.persist(usuario);
		}
		return this.convertUsuarioInUsuarioDTO(usuario);
	}

	/**
	 * Compara senha que esta vindo com a senha que esta no usuario vindo do banco
	 * 
	 * @Param senha
	 */
	private void comparaSenhaDB(String senha, Usuario usuario) throws SenhaException {
		String senhaCriptografada = criptografaSenha(senha);
		if (!usuario.getPassword().equals(senhaCriptografada)) {
			throw new SenhaException();
		}
	}

	/**
	 * Criptografa a senha do usuario que sera persistido no banco ou que logara no
	 * sistema
	 * 
	 * @Param senha
	 */
	private String criptografaSenha(String senha) {
		return SenhaUtil.criptografar(senha);
	}

	/**
	 * transform usuarioDTO in usuario
	 * 
	 * @Param usuarioDTO
	 * @return usuario
	 */
	@Override
	public Usuario convertUsuarioDTOInUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setAtivo(usuarioDTO.getAtivo());
		usuario.setDataCriacao(usuarioDTO.getDataCriacao());
		usuario.setPassword(usuarioDTO.getPassword());
		usuario.setLoginUser(usuarioDTO.getLoginUser());
		usuario.setTipoUsuario(new TipoUsuario(usuarioDTO.getTipoUsuario().getIdTipoUsuario()));
		usuario.setIdUser(usuarioDTO.getIdUser() != null ? usuarioDTO.getIdUser() : null);
		return usuario;
	}

	/**
	 * transform Usuario in UsuarioDTO
	 * 
	 * @Param usuario
	 * @return UsuarioDTO
	 */
	@Override
	public UsuarioDTO convertUsuarioInUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setAtivo(usuario.getAtivo());
		usuarioDTO.setDataCriacao(usuario.getDataCriacao());
		usuarioDTO.setLoginUser(usuario.getLoginUser());
		usuarioDTO.setPassword(usuario.getPassword());
		usuarioDTO.setTipoUsuario(new TipoUsuarioDTO(usuario.getTipoUsuario().getIdTipoUsuario()));
		usuarioDTO.setIdUser(usuario.getIdUser() != null ? usuario.getIdUser() : null);
		return usuarioDTO;
	}

	/**
	 * get Usuario contains idUser
	 * 
	 * @Param idUsuario
	 * @return UsuarioDTO
	 */
	@Override
	public UsuarioDTO findOne(Long idUser) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT u FROM Usuario u WHERE u.idUser = :idUser ");

		Query query = em.createQuery(sql.toString());
		query.setParameter("idUser", idUser);

		return this.convertUsuarioInUsuarioDTO((Usuario) query.getSingleResult());
	}

	/**
	 * get Usuario contains email for user
	 * 
	 * @Param email
	 * @return UsuarioDTO
	 */
	private Usuario getInEmail(String email) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT u FROM Usuario u WHERE u.loginUser = :email ");

		Query query = em.createQuery(sql.toString());
		query.setParameter("email", email);

		return (Usuario) query.getSingleResult();
	}
	
	/**
	 * get Usuario contains email and password is correct for login
	 * 
	 * @Param dsEmail
	 * @param dsPassword
	 * @return UsuarioDTO
	 */
	@Override
	public UsuarioDTO loginUser(String dsEmail, String dsPassword) throws SenhaException {
		Usuario usuario = this.getInEmail(dsEmail);
		this.comparaSenhaDB(dsPassword, usuario);
		return this.convertUsuarioInUsuarioDTO(usuario);
	}
}
