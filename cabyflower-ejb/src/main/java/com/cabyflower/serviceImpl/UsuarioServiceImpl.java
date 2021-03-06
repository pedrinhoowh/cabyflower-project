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
		if (usuario.getSeqUser() != null) {
			this.comparaSenhaDB(usuario.getDesSenha(), this.getInEmail(usuario.getDesLogin()));
			em.merge(usuario);
		} else {
			usuario.setDesSenha(criptografaSenha(usuario.getDesSenha()));
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
		if (!usuario.getDesSenha().equals(senhaCriptografada)) {
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
		usuario.setDatCriacao(usuarioDTO.getDataCriacao());
		usuario.setDesSenha(usuarioDTO.getPassword());
		usuario.setDesLogin(usuarioDTO.getLoginUser());
		usuario.setTipoUsuario(new TipoUsuario(usuarioDTO.getTipoUsuario().getIdTipoUsuario()));
		usuario.setSeqUser(usuarioDTO.getIdUser() != null ? usuarioDTO.getIdUser() : null);
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
		usuarioDTO.setDataCriacao(usuario.getDatCriacao());
		usuarioDTO.setLoginUser(usuario.getDesLogin());
		usuarioDTO.setPassword(usuario.getDesSenha());
		usuarioDTO.setTipoUsuario(new TipoUsuarioDTO(usuario.getTipoUsuario().getSeqTipoUsuario()));
		usuarioDTO.setIdUser(usuario.getSeqUser() != null ? usuario.getSeqUser() : null);
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
		sql.append(" SELECT u FROM Usuario u WHERE u.seqUser = :idUser ");

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
		sql.append(" SELECT u FROM Usuario u WHERE u.desLogin = :email ");

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
