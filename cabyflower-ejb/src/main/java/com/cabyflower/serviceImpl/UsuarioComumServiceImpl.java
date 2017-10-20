package com.cabyflower.serviceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cabiflower.dto.UsuarioComumDTO;
import com.cabyflower.entity.UsuarioComum;
import com.cabyflower.service.EnderecoService;
import com.cabyflower.service.UsuarioComumService;
import com.cabyflower.service.UsuarioService;

@Stateless
public class UsuarioComumServiceImpl implements UsuarioComumService{
	
	@PersistenceContext(unitName = "cabyflowerUI")
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
		usuarioComum.setSeqUsuarioComum(usuarioComumDTO.getIdUsuarioComum() != null ? usuarioComumDTO.getIdUsuarioComum() : null);
		usuarioComum.setDatNascimento(usuarioComumDTO.getNascimento());
		usuarioComum.setNomUsuarioComum(usuarioComumDTO.getNome() != null ? usuarioComumDTO.getNome() : null);
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
		usuarioComumDTO.setIdUsuarioComum(usuarioComum.getSeqUsuarioComum() != null ? usuarioComum.getSeqUsuarioComum() : null);
		usuarioComumDTO.setNascimento(usuarioComum.getDatNascimento());
		usuarioComumDTO.setNome(usuarioComum.getNomUsuarioComum() != null ? usuarioComum.getNomUsuarioComum() : null);
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
		if(usuarioComum.getSeqUsuarioComum() != null)
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
