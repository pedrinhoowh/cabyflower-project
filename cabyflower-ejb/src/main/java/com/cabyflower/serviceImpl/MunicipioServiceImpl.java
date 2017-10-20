package com.cabyflower.serviceImpl;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cabiflower.dto.MunicipioDTO;
import com.cabyflower.entity.Municipio;
import com.cabyflower.service.MunicipioService;
import com.cabyflower.service.UfService;

@Stateless
public class MunicipioServiceImpl implements MunicipioService {
	
	@PersistenceContext(unitName = "cabyflowerUI")
	private EntityManager em;

	@EJB
	private UfService ufService;

	/**
	 * convert municipioDTO in municipio
	 * 
	 * @param municipioDTO
	 * @return municipio
	 */
	@Override
	public Municipio convertMunicipioDTOInMunicipio(MunicipioDTO municipioDTO) {
		Municipio municipio = new Municipio();
		municipio.setSeqMunicipio(municipioDTO.getIdMunicipio() != null ? municipioDTO.getIdMunicipio() : null);
		municipio.setNomMunicipio(municipioDTO.getNomeMunicipio());
		municipio.setUf(ufService.convertUfDtoInUf(municipioDTO.getUf()));
		return municipio;
	}

	/**
	 * convert municipio in municipioDTO
	 * 
	 * @param municipio
	 * @return municipioDTO
	 */
	@Override
	public MunicipioDTO convertMunicipioInMunicipioDTO(Municipio municipio) {
		MunicipioDTO municipioDTO = new MunicipioDTO();
		municipioDTO.setIdMunicipio(municipio.getSeqMunicipio() != null ? municipio.getSeqMunicipio() : null);
		municipioDTO.setNomeMunicipio(municipio.getNomMunicipio());
		municipioDTO.setUf(ufService.convertUfInUfDTO(municipio.getUf()));
		return municipioDTO;
	}
	
	/**
	 * convert list municipio in list municipioDTO
	 * 
	 * @param listMunicipio
	 * @return list municipioDTO
	 */
	private List<MunicipioDTO> convertListEntityInListDTO(List<Municipio> listMunicipio){
		List<MunicipioDTO> listRetorno = new LinkedList<>();
		listMunicipio.forEach(municipio -> {
			listRetorno.add(this.convertMunicipioInMunicipioDTO(municipio));
		});
		return listRetorno;
	}
	
	/**
	 * get all municipio
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MunicipioDTO> getAll(){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT m FROM Municipio m ");
		Query query = em.createQuery(sql.toString());
		return this.convertListEntityInListDTO(query.getResultList());
	}
	
	/**
	 * get all municipios in uf
	 * 
	 * @param idUf
	 * @return list municipioDTO
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MunicipioDTO> getAllMunicipioInUf(Long idUf){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT m FROM Municipio m WHERE m.uf.idUf = :idUf");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idUf", idUf);
		return this.convertListEntityInListDTO(query.getResultList());
	}
	
	/**
	 * get municipio
	 * 
	 * @param idMunicipio
	 * @return municipioDTO
	 */
	@Override
	public MunicipioDTO findOne(Long idMunicipio) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT m FROM Municipio m WHERE m.idMunicipio = :idMunicipio");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idMunicipio", idMunicipio);
		return this.convertMunicipioInMunicipioDTO((Municipio) query.getSingleResult());
	}

}
