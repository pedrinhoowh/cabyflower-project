package com.cabyflower.service;

import javax.ejb.Local;

import com.cabiflower.dto.UsuarioComumDTO;
import com.cabyflower.entity.UsuarioComum;

@Local
public interface UsuarioComumService {

	/**
	 * convert UsuarioComumDTO in UsuarioComum
	 * 
	 * @param usuarioComumDTO
	 * @return UsuarioComum
	 */
	UsuarioComum convertDTOInEntity(UsuarioComumDTO usuarioComumDTO);

	/**
	 * convert usuarioComum in UsuarioComumDTO
	 * 
	 * @param usuarioComum
	 * @return UsuarioComumDTO
	 */
	UsuarioComumDTO convertEntityInDTO(UsuarioComum usuarioComum);

	/**
	 * persist usuarioComum in db
	 * 
	 * @param usuarioComum
	 * @return UsuarioComumDTO
	 */
	UsuarioComumDTO save(UsuarioComumDTO usuarioComumDTO);
	
	/**
	 * get usuarioComum in db
	 * 
	 * @param idUser
	 * @return UsuarioComumDTO
	 */
	UsuarioComumDTO findOne(Long idUser);
	
	/**
	 * get usuarioComum in db where exist usuario
	 * 
	 * @param idUser
	 * @return UsuarioComumDTO
	 */
	UsuarioComumDTO getUsuarioComumForUsuario(Long idUsuario); 
}
