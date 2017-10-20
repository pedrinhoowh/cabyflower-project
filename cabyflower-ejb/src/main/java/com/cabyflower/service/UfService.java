package com.cabyflower.service;

import java.util.List;

import javax.ejb.Local;

import com.cabiflower.dto.UfDTO;
import com.cabyflower.entity.Uf;

@Local
public interface UfService {
	
	/**
	 * convert UfDTO in Uf
	 * @param ufDTO
	 * @return uf
	 */
	Uf convertUfDtoInUf(UfDTO ufDTO);
	
	/**
	 * convert Uf in UfDTO
	 * @param uf
	 * @return ufDTO
	 */
	UfDTO convertUfInUfDTO(Uf uf);
	
	/**
	 * get all uf in db
	 * 
	 */
	List<UfDTO> getAll();
	
	/**
	 * get uf exist in db
	 * 
	 * @param idMunicipio
	 * @return uf
	 */
	UfDTO findOne(Long idUf);

}
