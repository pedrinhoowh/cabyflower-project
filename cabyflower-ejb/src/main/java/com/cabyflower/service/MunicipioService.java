package com.cabyflower.service;

import java.util.List;

import javax.ejb.Local;

import com.cabiflower.dto.MunicipioDTO;
import com.cabyflower.entity.Municipio;

@Local
public interface MunicipioService {
	
	/**
	 * convert municipioDTO in municipio
	 * @param municipioDTO
	 * @return municipio
	 */
	Municipio convertMunicipioDTOInMunicipio (MunicipioDTO municipioDTO);
	
	/**
	 * convert municipio in municipioDTO
	 * @param municipio
	 * @return municipioDTO
	 */
	MunicipioDTO convertMunicipioInMunicipioDTO (Municipio municipio);
	
	/**
	 * get all municipio
	 * 
	 */
	List<MunicipioDTO> getAll();

	/**
	 * get all municipios in uf
	 * 
	 * @param idUf
	 * @return list municipioDTO
	 */
	List<MunicipioDTO> getAllMunicipioInUf(Long idUf);
	
	/**
	 * get municipio
	 * 
	 * @param idMunicipio
	 * @return municipioDTO
	 */
	MunicipioDTO findOne(Long idMunicipio);
}
