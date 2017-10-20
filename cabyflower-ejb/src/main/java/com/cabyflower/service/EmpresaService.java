package com.cabyflower.service;

import java.util.List;

import javax.ejb.Local;

import com.cabiflower.dto.EmpresaDTO;
import com.cabiflower.dto.EmpresaFIlterDTO;
import com.cabyflower.entity.Empresa;

@Local
public interface EmpresaService {
	
	/**
	 * save Empresa
	 * @Param empresaDTO
	 * @return empresaDTO persist in database
	 */
	EmpresaDTO save(EmpresaDTO empresaDTO);
	
	/**
	 * convert EMpresaDTO in Empresa
	 * @Param empresaDTO
	 * @return Empresa 
	 */
	Empresa convertEmpresaDTOInEmpresa(EmpresaDTO empresaDTO);
	
	/**
	 * convert empresa in empresaDTO
	 * @Param empresa
	 * @return empresaDTO 
	 */
	EmpresaDTO convertEmpresaInEmpresaDTO(Empresa empresa);
	
	/**
	 * get Empresa contains idEmpresa
	 * 
	 * @Param idEmpresa
	 * @return empresaDTO
	 */
	EmpresaDTO findOne(Long idEmpresa);
	
	/**
	 * get Empresas for filter
	 * 
	 * @Param empresaFilter
	 * @return empresaDTOList
	 */
	List<EmpresaDTO> getEmpresaForFilter(EmpresaFIlterDTO empresaFilter);
	
	/**
	 * get Empresa for usuario
	 * 
	 * @Param idUsuario
	 * @return EmpresaDTO
	 */
	EmpresaDTO getEmpresaForUsuario(Long idUsuario);
}
