package com.cabyflower.service;

import javax.ejb.Local;

import com.cabiflower.dto.UsuarioDTO;
import com.cabyflower.entity.Usuario;

import exception.SenhaException;

/**
 * @author pedrocotta
 *
 */
@Local
public interface UsuarioService{
	
	/**
	 * save usuario
	 * @Param UsuarioDTO usuarioDTO
	 * @return usuarioDTO persist in database
	 */
	UsuarioDTO save (UsuarioDTO usuarioDTO) throws SenhaException;
	
	/**
	 * transform usuarioDTO in usuario
	 * @Param usuarioDTO
	 * @return usuario
	 */
	Usuario convertUsuarioDTOInUsuario(UsuarioDTO usuarioDTO);
	
	/**
	 * transform Usuario in UsuarioDTO
	 * @Param  usuario
	 * @return UsuarioDTO
	 */
	UsuarioDTO convertUsuarioInUsuarioDTO(Usuario usuario);
	
	/**
	 * get Usuario contains idUser
	 * @Param idUsuario
	 * @return UsuarioDTO
	 */
	UsuarioDTO findOne(Long idUser);
	
	/**
	 * get Usuario contains email and password is correct for login
	 * 
	 * @Param dsEmail
	 * @param dsPassword
	 * @return UsuarioDTO
	 */
	UsuarioDTO loginUser(String dsEmail, String dsPassword) throws SenhaException;
	
}
