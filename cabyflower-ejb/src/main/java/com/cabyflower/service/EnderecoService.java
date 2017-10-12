package com.cabyflower.service;

import javax.ejb.Local;

import com.cabiflower.dto.EnderecoDTO;
import com.cabyflower.entity.Endereco;

/**
 * @author pedrocotta
 *
 */
@Local
public interface EnderecoService {

	/**
	 * convert enderecoDTO in endereco
	 * @param enderecoDTO
	 *@return endereco
	 */
	Endereco convertEnderecoDTOInEndereco(EnderecoDTO enderecoDTO);
	
	/**
	 * convert endereco in enderecoDTO
	 * @param endereco
	 *@return enderecoDTO
	 */
	EnderecoDTO convertEnderecoInEnderecoDTO(Endereco endereco);
}
