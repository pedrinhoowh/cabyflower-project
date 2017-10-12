package com.cabyflower.serviceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.cabiflower.dto.UsuarioComumDTO;
import com.cabyflower.entity.UsuarioComum;
import com.cabyflower.service.EnderecoService;
import com.cabyflower.service.UsuarioComumService;
import com.cabyflower.service.UsuarioService;

@Stateless
@Transactional(value = TxType.NOT_SUPPORTED)
@TransactionManagement
public class UsuarioComumServiceImpl implements UsuarioComumService{
	
	@PersistenceContext(unitName = "nameDB")
	private EntityManager em;
	
	@EJB
	private UsuarioService usuarioService;
	
	@EJB 
	private EnderecoService enderecoService;
	
	/**
	 * convert UsuarioComumDTO in UsuarioComum
	 * 
	 * @param usuarioComumDTO
	 * @return UsuarioComum
	 */
	@Override
	public UsuarioComum convertDTOInEntity(UsuarioComumDTO usuarioComumDTO) {
		UsuarioComum usuarioComum = new UsuarioComum();
		usuarioComum.setIdUsuarioComum(usuarioComumDTO.getIdUsuarioComum() != null ? usuarioComumDTO.getIdUsuarioComum() : null);
		usuarioComum.setNascimento(usuarioComumDTO.getNascimento());
		usuarioComum.setNome(usuarioComumDTO.getNome() != null ? usuarioComumDTO.getNome() : null);
		usuarioComum.setUsuario(usuarioService.convertUsuarioDTOInUsuario(usuarioComumDTO.getUsuario()));
		usuarioComum.setEndereco(enderecoService.convertEnderecoDTOInEndereco(usuarioComumDTO.getEndereco()));
		return usuarioComum;
	}
	
	/**
	 * convert usuarioComum in UsuarioComumDTO
	 * 
	 * @param usuarioComum
	 * @return UsuarioComumDTO
	 */
	@Override
	public UsuarioComumDTO convertEntityInDTO(UsuarioComum usuarioComum) {
		UsuarioComumDTO usuarioComumDTO = new UsuarioComumDTO();
		usuarioComumDTO.setIdUsuarioComum(usuarioComum.getIdUsuarioComum() != null ? usuarioComum.getIdUsuarioComum() : null);
		usuarioComumDTO.setNascimento(usuarioComum.getNascimento());
		usuarioComumDTO.setNome(usuarioComum.getNome() != null ? usuarioComum.getNome() : null);
		usuarioComumDTO.setUsuario(usuarioService.convertUsuarioInUsuarioDTO(usuarioComum.getUsuario()));
		usuarioComumDTO.setEndereco(enderecoService.convertEnderecoInEnderecoDTO(usuarioComum.getEndereco()));
		return usuarioComumDTO;
	}
	
	/**
	 * persist usuarioComum in db
	 * 
	 * @param usuarioComum
	 * @return UsuarioComumDTO
	 */
	@Override
	public UsuarioComumDTO save(UsuarioComumDTO usuarioComumDTO) {
		UsuarioComum usuarioComum = this.convertDTOInEntity(usuarioComumDTO);
		if(usuarioComum.getIdUsuarioComum() != null)
			em.merge(usuarioComum);
		else
			em.persist(usuarioComum);
		return this.convertEntityInDTO(usuarioComum);
	}
	
	/**
	 * get usuarioComum in db
	 * 
	 * @param idUser
	 * @return UsuarioComumDTO
	 */
	@Override
	public UsuarioComumDTO findOne(Long idUser) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT u FROM UsuarioComum u WHERE u.idUsuarioComum = :idUser ");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idUser", idUser);
		return this.convertEntityInDTO((UsuarioComum)query.getSingleResult());
	}
	
	/**
	 * get usuarioComum in db where exist usuario
	 * 
	 * @param idUser
	 * @return UsuarioComumDTO
	 */
	@Override
	public UsuarioComumDTO getUsuarioComumForUsuario(Long idUsuario) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT u FROM UsuarioComum u WHERE u.usuario.idUser = :idUsuario ");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idUsuario", idUsuario);
		return this.convertEntityInDTO((UsuarioComum)query.getSingleResult());
	}

}
